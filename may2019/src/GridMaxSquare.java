public class GridMaxSquare {
    public int maxSquareArea(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] memory = new int[2][n];
        int maxSize = 0;
        int flag = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || j == 0) {
                    memory[flag][j] = matrix[i][j] - '0';
                } else {
                    if (matrix[i][j] == '0') {
                        memory[flag][j] = 0;
                    } else {
                        memory[flag][j] = Math.min(memory[flag ^ 1][j], Math.min(memory[flag][j - 1], memory[flag ^ 1][j - 1])) + 1;
                    }
                }
                maxSize = Math.max(maxSize, memory[flag][j]);
                flag = flag ^ 1;
            }
        }
        return maxSize * maxSize;
    }
}

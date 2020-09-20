package optimization;

import java.util.Arrays;

public class MaxPaths {
    public int maxUniquePaths(int m, int n) {
        int[][] memory = new int[m - 1][n - 1];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(memory[i], -1);
        }

        for (int j = 0; j < n; ++j) {
            memory[0][j] = 1;
        }

        for (int i = 0; i < m; ++i) {
            memory[i][0] = 1;
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; j++) {
                memory[i][j] = memory[i-1][j] + memory[i][j-1];
            }
        }
        return memory[m - 1][n - 1];
    }
}

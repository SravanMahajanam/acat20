package assignments;

public class SearchIn2DArrayII {
    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; ++i) {
            int l = 0;
            int r = matrix[i].length - 1;
            if (r == -1) {
                continue;
            }
            if (matrix[i][l] == target || matrix[i][r] == target) {
                return true;
            }
            int m = l + (r - l)/2;
            if (matrix[i][m] == target) {
                return true;
            }
            while (r - l > 1) {
                if (matrix[i][m] > target) {
                    r = m;
                } else if (matrix[i][m] < target){
                    l = m;
                } else {
                    return true;
                }
                m = r - (r - l) / 2;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{5,1}};
        System.out.println(searchMatrix(matrix, 5));
    }
}

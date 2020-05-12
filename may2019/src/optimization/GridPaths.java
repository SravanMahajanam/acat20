package optimization;

// https://leetcode.com/problems/unique-paths/description/
public class GridPaths {
    public static int uniquePaths1(int m, int n) {
        return auxUniquePaths1(m, n, 0, 0);
    }

    private static int auxUniquePaths1(int m, int n, int currRow, int currCol) {
        if (currRow >= m || currCol >= n) {
            return 0;
        }
        if (currCol == n - 1 && currRow == m - 1) {
            return 1;
        }

        int down = auxUniquePaths1(m, n, currRow + 1, currCol);
        int right = auxUniquePaths1(m, n, currRow, currCol + 1);
        return down + right;
    }

    public static int uniquePaths(int m, int n) {
        int[][] memory = new int[m + 1][n + 1];
        memory[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (memory[i][j] == 0) {
                    memory[i][j] = memory[i + 1][j] + memory[i][j + 1];
                }
            }
        }
        return memory[0][0];
    }

    public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return auxUniquePathsWithObstacles1(obstacleGrid,m,n,0,0);
    }

    private static int auxUniquePathsWithObstacles1(int[][] grid, int m, int n, int currRow, int currCol) {
        if (currRow >= m || currCol >= n) {
            return 0;
        }
        if (currCol == n - 1 && currRow == m - 1) {
            return 1;
        }
        if (grid[currRow][currCol] == 1) {
            return 0;
        }

        int down = auxUniquePathsWithObstacles1(grid, m, n,currRow + 1, currCol);
        int right = auxUniquePathsWithObstacles1(grid, m, n, currRow, currCol + 1);
        return down + right;
    }

    public static int uniquePathsWithObstacles2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memory = new int[m + 1][n + 1];
        if (grid[m-1][n-1] != 1) {
            memory[m - 1][n - 1] = 1;
        }

        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (memory[i][j] == 0 && grid[i][j] == 0) {
                    memory[i][j] = memory[i + 1][j] + memory[i][j + 1];
                }
            }
        }
        return memory[0][0];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));
    }
}

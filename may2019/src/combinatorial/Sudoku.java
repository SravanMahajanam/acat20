package combinatorial;

import java.util.Arrays;

public class Sudoku {

    public static void sudokuSolver1(int[][] in) {
        int[][] out = new int[9][9];
        auxSudokuSolver1(0, 0, in, out);
    }

    private static void auxSudokuSolver1(int r, int c, int[][] in, int[][] out) {
        if (r == 9) {
            for (int i = 0; i < 9; ++i) {
                if (isValid1(out)) {
                    System.out.println(Arrays.toString(out[i]));
                }
            }
            System.out.println();
            return;
        }

        for (int j = 1; j <= 9; ++j) {
            if (in[r][c] != 0) {
                out[r][c] = in[r][c];
                auxSudokuSolver1(c == 8 ? r + 1 : r, c == 8 ? 0 : c + 1, in, out);
            } else {
                out[r][c] = j;
                auxSudokuSolver1(c == 8 ? r + 1 : r, c == 8 ? 0 : c + 1, in, out);
            }
        }
    }

    private static boolean isValid1(int[][] grid) {
        return true;
    }

    public static void sudokuSolver2(int[][] in) {
        auxSudokuSolver2(0, 0, in, new int[9][9]);
    }

    private static void auxSudokuSolver2(int r, int c, int[][] in, int[][] out) {
        if (r == 9) {
            for (int i = 0; i < 9; ++i) {
                System.out.println(Arrays.toString(out[i]));
            }
            System.out.println();
            return;
        }
        if (in[r][c] != 0) {
            out[r][c] = in[r][c];
            auxSudokuSolver2(c == 8 ? r + 1 : r, c == 8 ? 0 : c + 1, in, out);
        } else {
            for (int j = 1; j <= 9; ++j) {
                if (isValid2(out, j, r, c)) {
                    out[r][c] = j;
                    auxSudokuSolver2(c == 8 ? r + 1 : r, c == 8 ? 0 : c + 1, in, out);
                }
            }
            out[r][c] = 0;
        }
    }

    private static boolean isValid2(int[][] grid, int val, int r, int c) {
        // check row
        for (int i = 0; i < 9; ++i) {
            if (grid[r][i] == val) {
                return false;
            }
        }
        // check column
        for (int j = 0; j < 9; ++j) {
            if (grid[j][c] == val) {
                return false;
            }
        }
        // check sub grid
        int sr = r / 3 * 3;
        int sc = c / 3 * 3;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j<3; ++j) {
                if (grid[sr + i][sc + j] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] in = {
                {0, 0, 0, 5, 0, 0, 0, 9, 0},
                {0, 3, 0, 0, 0, 0, 0, 0, 5},
                {0, 0, 0, 8, 2, 7, 0, 0, 0},
                {1, 0, 0, 4, 0, 6, 0, 0, 0},
                {0, 9, 0, 0, 0, 0, 0, 7, 0},
                {2, 8, 0, 0, 5, 0, 0, 0, 0},
                {4, 0, 5, 0, 0, 0, 0, 0, 0},
                {7, 0, 0, 0, 0, 0, 9, 0, 2},
                {0, 0, 0, 0, 0, 0, 1, 5, 6}
        };
        sudokuSolver2(in);
    }
}

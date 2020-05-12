package combinatorial;

import java.util.Arrays;

public class NQueens {
    public static void printNQueensPositions_CS(int n) {
        int[] board = new int[n];
        auxPrintNQueensPositions_CS(0, board);
    }

    private static void auxPrintNQueensPositions_CS(int queensCount, int[] board) {
        if (board.length == queensCount) {
            if (isValid1(board)) {
                System.out.println(Arrays.toString(board));
            }
            return;
        }
        for (int i =0; i<board.length;++i) {
            board[queensCount] = i;
            auxPrintNQueensPositions_CS(queensCount+1, board);
        }

    }

    private static boolean isValid1(int[] board) {
        for (int i = 0; i<board.length;++i) {
            for (int j = i+1; j<board.length;++j) {
                if (board[i] == board[j] || Math.abs(i-j) == Math.abs(board[i] - board[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printNQueensPositions_BT(int n) {
        int[] board = new int[n];
        auxPrintNQueensPositions_BT(0, board);
    }

    private static void auxPrintNQueensPositions_BT(int queensCount, int[] board) {
        if (board.length == queensCount) {
            System.out.println(Arrays.toString(board));
            return;
        }
        for (int i =0; i<board.length;++i) {
            if (isValid2(board, queensCount, i)) {
                board[queensCount] = i;
                auxPrintNQueensPositions_BT(queensCount+1, board);
            }

        }
    }

    private static boolean isValid2(int[] board, int currentQueen, int currQueenPos) {
        for (int i=0;i<currentQueen;++i) {
            if (currQueenPos == board[i] || Math.abs(currentQueen - i)== Math.abs(currQueenPos- board[i])) {
                return false;
            }
        }
        return true;
    }

    public static  void nqueens2(int n) {
        int[] out = new int[n];
        auxQueens2(0, out);
    }
    private static boolean isValid2(int d, int c, int[] out) {
        for(int i = 0; i < d; ++i) {
            if(c == out[i]) return false;
            if(Math.abs(i-d) == Math.abs(out[i]-c)) return false;
        }
        return true;
    }
    private static void auxQueens2(int d, int[] out) {
        if(d == out.length) {
            System.out.println(Arrays.toString(out));
            return;
        }
        for(int c = 0; c < out.length; ++c) {
            if(isValid2(d, c, out)) {
                out[d] = c;
                auxQueens2(d+1, out);
            }
        }
    }

    public static void main(String[] args) {
        printNQueensPositions_CS(4);
        nqueens2(4);
        printNQueensPositions_BT(4);
    }
}

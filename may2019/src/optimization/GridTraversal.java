package optimization;

public class GridTraversal {
    public static int maxSumPath1(int[][] in) {
        MyInteger gMax = new MyInteger();
        auxMaxSumPath1(in, 0, 0,0,gMax);
        return gMax.get();
    }

    private static void auxMaxSumPath1(int[][] in,  int currSum, int row, int col, MyInteger gMax) {
        if (row == in.length || col == in.length) {
            return;
        }
        if (row == in.length-1 && col == in.length-1) {
            currSum = currSum + in[row][col];
            if (currSum > gMax.get()) {
                gMax.set(currSum);
            }
        }
        //bottom sum
        auxMaxSumPath1(in,currSum+in[row][col], row+1,col, gMax);
        // right sum
        auxMaxSumPath1(in, currSum+in[row][col], row, col+1, gMax);
    }

    public static int maxSumPath2(int[][] in) {
        return auxMaxSumPath2(in,0,0);
    }

    private static int auxMaxSumPath2(int[][] in, int row, int col) {
        if (row == in.length || col == in.length) {
            return 0;
        }
        int bottomSum = auxMaxSumPath2(in, row+1, col);
        int rightSum = auxMaxSumPath2(in, row, col+1);
        return Math.max(bottomSum, rightSum) + in[row][col];
    }

    public static int maxSumPath3(int[][] in) {
        int[][] memory = new int[in.length][in.length];
        auxMaxSumPath3(in, 0, 0, memory);
        return memory[0][0];
    }

    private static int auxMaxSumPath3(int[][] in, int row, int col, int[][] memory) {
        if (row == in.length || col == in.length) {
            return 0;
        }
        if (memory[row][col]!= 0) {
            return memory[row][col];
        }

        int bottomSum = auxMaxSumPath2(in, row+1, col);
        int rightSum = auxMaxSumPath2(in, row, col+1);
        memory[row][col] = Math.max(bottomSum, rightSum) + in[row][col];
        return Math.max(bottomSum, rightSum) + in[row][col];
    }

    public static int maxSumPath4(int[][] in) {
        int[][] memory = new int[in.length+1][in.length+1];
        for (int row = 0; row<in.length;++row) {
            memory[row][3] = 0;
        }
        for (int col = 0; col<in.length;++col) {
            memory[in.length][col] = 0;
        }

        for (int row = in.length-1;row>=0;--row) {
            for (int col = in.length-1;col>=0;--col) {
                memory[row][col] = Math.max(memory[row+1][col], memory[row][col+1]) + in[row][col];
            }
        }
        return memory[0][0];
    }

    public static void main(String[] args) {
        System.out.println(maxSumPath4(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
}

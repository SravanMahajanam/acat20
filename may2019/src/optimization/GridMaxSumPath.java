package optimization;

public class GridMaxSumPath {

    public static int maxSumPath1(int[][] in) {
        MyInteger gMax = new MyInteger();
        auxMaxSumPath1(in, 0, 0, 0, gMax);
        return gMax.get();
    }

    private static void auxMaxSumPath1(int[][] in, int currentSum, int i, int j, MyInteger gMax) {
        if (i == in.length || j == in.length) {
            return;
        }
        if (i == in.length - 1 && j == in.length - 1) {
            currentSum = currentSum + in[i][j];
            if (currentSum > gMax.get()) {
                gMax.set(currentSum);
            }
        }
        auxMaxSumPath1(in, currentSum + in[i][j], i, j + 1, gMax);
        auxMaxSumPath1(in, currentSum + in[i][j], i + 1, j, gMax);
        return;
    }

    public static int maxSumPath2(int[][] in) {
        return auxMaxSumPath2(in, 0, 0);
    }

    private static int auxMaxSumPath2(int[][] in, int i, int j) {
        if (i == in.length || j == in.length) {
            return 0;
        }

        int rightSum = auxMaxSumPath2(in, i, j + 1);
        int bottomSum = auxMaxSumPath2(in, i + 1, j);
        return Math.max(rightSum, bottomSum) + in[i][j];
    }

    public static int maxSumPath3(int[][] in) {
        int[][] memory = new int[in.length + 1][in.length + 1];
        return memory[0][0] = auxMaxSumPath3(in, 0, 0, memory);
    }

    private static int auxMaxSumPath3(int[][] in, int i, int j, int[][] memory) {
        if (i == in.length || j == in.length) {
            return 0;
        }
        if (memory[i][j] != 0) {
            return memory[i][j];
        }

        int rightSum = auxMaxSumPath3(in, i, j + 1, memory);
        int bottomSum = auxMaxSumPath3(in, i + 1, j, memory);
        memory[i][j] = Math.max(rightSum, bottomSum) + in[i][j];
        return memory[i][j];
    }

    public static int maxSumPath4(int[][] in) {
        int[][] memory = new int[in.length + 1][in.length + 1];
        for (int i = in.length; i < 0; --i) {
            memory[in.length][i] = 0;
            memory[i][in.length] = 0;
        }

        for (int i = 0; i < in.length - 1; ++i) {
            for (int j = 0; j < in.length - 1; ++j) {
                memory[i][j] = Math.max(memory[i + 1][j], memory[i][j + 1]) + in[i][j];
            }
        }
        traceOptimalPath(memory);
        return memory[0][0];
    }

    private static void traceOptimalPath(int[][] memory) {
        for (int i = 0; i < memory.length - 1; ++i) {
            for (int j = 0; j < memory.length - 1; ++j) {
                System.out.println("(" + i + "," + j + ")");
                if (memory[i + 1][j] > memory[i][j + 1]) {
                    i = i + 1;
                } else {
                    j = j + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(maxSumPath1(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
}

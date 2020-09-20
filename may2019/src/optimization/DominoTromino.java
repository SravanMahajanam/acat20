package optimization;

public class DominoTromino {
    public static int numTilings(int N) {
        int[][] memory = new int[N + 1][4];
        return auxNumTilings(0, N,true, true, memory);
    }

    private static int auxNumTilings(int i, int N, boolean t1, boolean t2, int[][] memory) {
        if (i == N) {
            return 1;
        }
        int state = makeState(t1, t2);
        if (memory[i][state] != 0) {
            return memory[i][state];
        }
        boolean t3 = i + 1 < N;
        boolean t4 = i + 1 < N;
        int count = 0;

        if (t1 && t2) {
            count += auxNumTilings(i + 1, N, true, true, memory);
        }
        if (t1 && !t2 && t3) {
            count += auxNumTilings(i + 1, N, false, true, memory);
        }
        if (!t1 && t2 && t4) {
            count += auxNumTilings(i + 1, N, true, false, memory);
        }
        if (t1 && !t2 && t3 && t4) {
            count += auxNumTilings(i + 1, N, false, false, memory);
        }
        if (!t1 && t2 && t3 && t4) {
            count += auxNumTilings(i + 1, N, false, false, memory);
        }
        if (t1 && t2 && t3) {
            count += auxNumTilings(i + 1, N, false, true, memory);
        }
        if (t1 && t2 && t4) {
            count += auxNumTilings(i + 1,N, true, false, memory);
        }
        if (t1 && t2 && t3 && t4) {
            count += auxNumTilings(i + 1, N, false, false, memory);
        }
        if (!t1 && !t2) {
            count += auxNumTilings(i + 1, N, true, true, memory);
        }

        memory[i][state] = count;
        return memory[i][state];
    }

    private static int makeState(boolean t1, boolean t2) {
        if (t1 && t2 ) {
            return 0;
        } else if (t1 && !t2) {
            return 1;
        } else if (!t1 && t2) {
            return 2;
        } else {
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(numTilings(30));
    }

}

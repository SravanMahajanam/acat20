package optimization;

public class NSteps {
    public static int countWays1(int n) {
        MyInteger count = new MyInteger();
        auxCountWays1(n, 0, count);
        return count.get();
    }

    private static void auxCountWays1(int n, int currStep, MyInteger count) {
        if (n == 0) {
            count.incr();
            return;
        }
        if (n < 0) {
            return;
        }
        auxCountWays1(n - 1, 1, count);
        auxCountWays1(n - 2, 2, count);
    }

    public static int countWays2(int n) {
        return auxCountWays2(n, 0);
    }

    private static int auxCountWays2(int n, int currStep) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return Integer.MIN_VALUE;
        }
        int oneStep = auxCountWays2(n - 1, 1);
        int twoStep = auxCountWays2(n - 2, 2);
        return (oneStep == Integer.MIN_VALUE ? 0 : oneStep) + (twoStep == Integer.MIN_VALUE ? 0 : twoStep);
    }

    public static int countWays3(int n) {
        int[][] memory = new int[2][n+1];
        return auxCountWays3(n, 1, memory);
    }

    private static int auxCountWays3(int n, int currStep, int[][] memory) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return Integer.MIN_VALUE;
        }
        if (memory[currStep-1][n] != 0) {
            return memory[currStep-1][n];
        }
        int oneStep = auxCountWays3(n - 1, 1, memory);
        int twoStep = auxCountWays3(n - 2, 2, memory);
        memory[currStep-1][n] = (oneStep == Integer.MIN_VALUE ? 0 : oneStep) + (twoStep == Integer.MIN_VALUE ? 0 : twoStep);
        return memory[currStep-1][n];
    }

    public static void main(String[] args) {
        System.out.println(countWays3(3));
    }

}

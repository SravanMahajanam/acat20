package optimization;

public class Fibonnaci {

    public static int fib1(int n) {
        if (n<=2) {
            return 1;
        }
        return fib1(n-1) + fib1(n-2);
    }

    public static int fib2(int n) {
        int[] memory = new int[n+1];
        if (n<=2) {
            return 1;
        }
        if (memory[n] != 0) {
            return memory[n];
        }
        memory[n] = fib2(n-1) + fib2(n-2);
        return memory[n];
    }

    public static int fib3(int n) {
        int[] memory = new int[n+1];
        memory[1] = 1;
        memory[2] = 1;
        for (int i = 3; i<=n; ++i) {
            memory[i] = memory[i-1] + memory[i-2];
        }
        return memory[n];
    }

    public static int fib4(int n) {
        int prev1 = 1;
        int prev2 = 1;
        int curr = 0;
        for (int i = 3; i<=n; ++i) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;

        }
        return curr;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        /*System.out.println(fib1(n));
        System.out.println(fib2(n));*/
        System.out.println(fib3(n));
        //System.out.println(fib4(n));
    }
}

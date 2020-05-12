package optimization;

import java.util.Arrays;
import java.util.Random;

public class MaxSum {

    public static int maxSum1(int[] in) {
        return auxMaxSum1(in, 0);
    }

    private static int auxMaxSum1(int[] in, int i) {
        if (i >= in.length) {
            return 0;
        }
        int inclusive = auxMaxSum1(in, i+2);
        int exclusive = auxMaxSum1(in, i+1);
        return Math.max(inclusive + in[i], exclusive);
    }

    public static int maxSum2(int[] in) {
        MyInteger max = new MyInteger();
        return auxMaxSum2(in, 0, max);
    }

    private static int auxMaxSum2(int[] in, int i, MyInteger max) {
        if (i >= in.length) {
            return 0;
        }
        int inclusive = auxMaxSum2(in, i+2, max);
        int exclusive = auxMaxSum2(in, i+1, max);
        max.set(Math.max(inclusive + in[i], exclusive));
        return max.get();
    }

    public static int maxSum3(int[] in) {
        int[] memory = new int[in.length];
        return auxMaxSum3(in, 0, memory);
    }

    private static int auxMaxSum3(int[] in, int i, int[] memory) {
        if (i >= in.length) {
            return 0;
        }
        if (memory[i] != 0) {
            return memory[i];
        }
        int inclusive = auxMaxSum3(in, i+2, memory);
        int exclusive = auxMaxSum3(in, i+1, memory);
        memory[i] = Math.max(inclusive + in[i], exclusive);
        return memory[i];
    }

    public static int maxSum4(int[] in) {
        int[] memory = new int[in.length + 2];
        for (int i = in.length-1; i>=0; --i) {
            int inclusive = in[i] + memory[i+2];
            int exclusive = memory[i+1];
            memory[i] = Math.max(inclusive, exclusive);
        }
        return memory[0];

    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] in = new int[n];
        Random r = new Random();
        for (int i = 0; i<n;++i) {
            in[i] = r.nextInt(5);
        }
        System.out.println(Arrays.toString(in));
        /*System.out.println(maxSum1(in));
        System.out.println(maxSum2(in));*/
        System.out.println(maxSum3(in));
//        System.out.println(maxSum4(in));
    }
}

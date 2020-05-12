import java.util.Arrays;
import java.util.Random;

public class ZeroCounter {

    public static int parseAllCount(int[] in) {
        for (int i=0; i < in.length; ++i) {
            if(in[i] > 0)
                return i;
        }
        return -1;
    }

    public static int divideAndPruneCountZeros(int[] in) {
        int l =0, r = in.length-1;
        while (l + 1 < r) { // till two elements are left
            int m = l + (r-l)/2;
            if(in[m] == 0) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        if(in[r] == 0) {
            return r + 1;
        }
        return l + 1;

    }

    public static int[] createTestArray(int n) {
        int in[] = new int[n];
        Random r = new Random(100);
        for (int i = n/3; i < n; i++) {
            in[i] = r.nextInt(100) + 1;
        }
        return in;
    }

    public static int[] createAllZerosArray(int n) {
        int[] in = new int[n];
        in[n-1] = 1;
        return in;
    }

    public static void main(String[] args) {
        //int[] in = createTestArray(Integer.parseInt(args[0]));
        int[] in = createAllZerosArray(Integer.parseInt(args[0]));
        System.out.println("Input : "+ Arrays.toString(in));
        System.out.println("zeros count : "+divideAndPruneCountZeros(in));
    }
}

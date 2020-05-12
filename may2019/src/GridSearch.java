import java.util.Arrays;

public class GridSearch {

    public static boolean linearSearch(int[][] in, int x) {
        int n = in.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if(in[i][j] == x) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean binaryRowSearch(int[][] in, int x) {
        int n = in.length;
        for (int i = 0; i < n; ++i) {
            if(Arrays.binarySearch(in[i], x) >= 0)
                return true;
        }
        return false;
    }

    /*ceil will give which row to consider.
    1   2   3
    4   5   6
    7   8   9

    if x = 5,
    ceil will give 1, means row = 1 should be considered.*/

    private static int ceil(int[][] in, int x) {
        int l = 0, r = in.length - 1;
        while(r - l > 1) {
            int m = l + (r - l) / 2;
            if (in[m][in.length - 1] > x)
                r = m;
            else
                l = m;
        }
        return r;
    }

    public static boolean ceilColumnSearch(int[][] in, int x) {
        int r = ceil(in,x);
        return Arrays.binarySearch(in[r], x) >= 0;
    }

    public static boolean oneDVirtualSearch(int[][] in, int x) {
        int n = in.length;
        int l = 0, r = n*n - 1;
        while(r - l > 1) {
            int m = l + (r-l)/2;
            if(in[m / n][m % n] == x)
                return true;
            if(in[m / n][m % n] > x) {
                r = m - 1;
            } else
                l = m + 1;
        }

        return false;

    }

    public static int[][] testcase1(int n) {
        int[][] in = new int[n][n];
        int k = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j){
                in[i][j] = ++k;
            }
        }
        return in;
    }

    public static void main(String[] args) {
        int[][] in = testcase1(Integer.parseInt(args[0]));
    }
}

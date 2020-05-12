import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class TwoSum {

    public static boolean parseLinearly(int[] in, int s) {
        for (int i = 0; i < in.length - 1; ++i) {
            for (int j = i + 1; j < in.length; ++j) {
                if (in[j] == s - in[i])
                    return true;
            }
        }
        return false;
    }

    public static boolean parseBinarySearch(int[] in, int s) {
        Arrays.sort(in);
        for (int i = 0; i < in.length; ++i) {
            if (Arrays.binarySearch(in, i, in.length, s - in[i]) >= 0)
                return true;
        }
        return false;
    }

    public static boolean parseWithHashing(int[] in, int s) {
        HashSet set = new HashSet();
        for (int i = 0; i < in.length; ++i) {
            if (set.contains(s - in[i]))
                return true;
            set.add(in[i]);
        }
        return false;
    }

    public static int[] createInputArray(int arraySize) {
        int[] testArray = new int[arraySize];
        Random r = new Random();
        for (int i = 0; i < arraySize; i++) {
            testArray[i] = r.nextInt(100);
        }
        return testArray;
    }

    public static void main(String[] args) {
        int[] in = createInputArray(Integer.parseInt(args[0])); //{34, 16, 19, 89, 86, 59, 31, 12, 5}
        System.out.println("input : " + Arrays.toString(in));
        System.out.println("pair exists : " + parseWithHashing(in, 138));
    }
}

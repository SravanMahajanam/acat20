package assignments;

import OrderedCollection.KEmptySlots;

// not complete. use hash map range of ums method instead
public class ContinousSubArraySum {

    public static boolean checkContinousSubArraySum(int[] array, int k) {
        for (int d = 2; d < array.length; ++d) {
            if (findSum(1, 0, d, array, 0, k, new Boolean(false)) == 1) {
                return true;
            }
        }
        return false;
    }

    private static int findSum(int iterations, int index, int d, int[] array, int sum, int k, Boolean checked) {
        if (iterations > d) {
            if (sum % k == 0) {
//                checked.
                return 1;
            }
            findSum(1, index - (d - 1) , d, array, 0, k, checked);
        }

        for (int i = index; i < array.length; ++i) {
            if (checked) {
                return 1;
            }
            findSum(iterations + 1,index + 1, d, array, sum + array[i], k, checked);
        }
        return 0;
    }


    public static boolean chkContSubArrSum(int[] ints, int k) {
        for (int elements = ints.length; elements > 1 ; --elements) {
            for (int startIndex = 0;ints.length - startIndex >= elements; ++startIndex) {
                if (getSum(ints, elements, startIndex) % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int getSum(int[] ints, int elements, int startIndex) {
        int sum = 0;
        for (int i = startIndex; i < elements; ++i) {
           sum += ints[i];
        }
        return sum;
    }

    public static boolean isContinousSubArrayExists(int[] in, int k) {
        int left = 0, right = 0;
        int currSum = 0;
        while (left < in.length && right < in.length) {
            if (currSum < k) {
                currSum += in[right];
                right++;
            } else if (currSum > k) {
                currSum -= in[left];
                left++;
            }
            else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isContinousSubArrayExists(new int[] {10, 2, 4, 0, 5}, 6));
    }
}

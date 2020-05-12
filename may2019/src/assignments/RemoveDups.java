package assignments;

import java.util.Arrays;

public class RemoveDups {

    public static int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[j - 1] != nums[i]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }


    public static int removeDoubleDuplicates(int[] nums) {
        int j = 2;
        for (int i = 2; i < nums.length; ++i) {
            if (nums[j-2] != nums[i]) {
                nums[j] = nums[i];
                j = j + 1;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] in = {1,1,1,2,2,3};
        System.out.println("unique count : "+removeDoubleDuplicates(in));
        System.out.println("New Array: "+ Arrays.toString(in));
    }
}

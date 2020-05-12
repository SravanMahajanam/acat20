package assignments;

import java.util.Arrays;

public class RemovePassedElement {

    public static int removeElements(int[] nums, int val) {
        int length = nums.length;
        int j;
        for (int i = 0; i<nums.length;++i) {
            if (nums[i] == val) {
                for (j = i+1;j<nums.length;++j) {
                    if (nums[j]!= val) {
                        nums[i] = nums[j];
                        nums[j] = val;
                        length++;
                        break;
                    }
                }
                length--;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElements(nums, val));
        System.out.println(Arrays.toString(nums));
    }
}

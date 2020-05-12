package assignments;

import java.util.Arrays;

public class NearByDuplicate {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 0)
            return false;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] == nums[j] && (j - i) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] in = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(in, k));
    }
}

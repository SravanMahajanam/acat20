package assignments;

import java.util.HashSet;

public class FirstMissPositveNum {
    public static int firstMissingPositive(int[] nums) {
        int miss = 1;
        if (nums.length == 0) {
            return miss;
        }
        HashSet set = new HashSet();
        for (int i = 0; i < nums.length; ++i) {
            set.add(nums[i]);
        }
        while (miss <= set.size()) {
            if (!set.contains(miss)) {
                break;
            }
            ++miss;
        }
        return miss;
    }
}

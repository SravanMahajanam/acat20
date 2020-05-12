package assignments;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public static int searchInsertByBinnary(int [] nums, int target) {
        int l = 0;
        int r = nums.length;
        int m = l + (r-l)/2;
        while(r-l>1) {
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m;
            }
            m = l + (r-l)/2;
        }
        if (nums[l] < target) {
            return l + 1;
        }
        return l;
    }
}

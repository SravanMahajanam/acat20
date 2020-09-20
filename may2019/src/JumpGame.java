public class JumpGame {
    public static boolean canReachEnd(int[] nums) {
        int jumpableFrom = nums.length - 1;

        for (int i = nums.length - 2 ; i >= 0; --i) {
            if (i + nums[i] >= jumpableFrom) {
                jumpableFrom = i;
            }
        }

        return jumpableFrom == 0;
    }
}

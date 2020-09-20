package optimization;

public class MaxContinousSubArray {

    //use kadane's algorith, which takes O(n)



   /* public int maxSubArraySum(int[] nums) {
        MyInteger gMax = new MyInteger(Integer.MIN_VALUE);
        auxMaxSubArraySum(nums, 0, 0, gMax);
        return gMax.get();
    }

    private void auxMaxSubArraySum(int[] nums, int i, int currSum, MyInteger gMax) {
        if (i == nums.length) {
            gMax.set(Math.max(currSum, gMax.get()));
            return;
        }
        int tempCurrSum = currSum;
        currSum = Math.max(currSum, currSum+nums[i]);
        auxMaxSubArraySum(nums, i + 1, currSum+nums[i], gMax);
        auxMaxSubArraySum(nums, i + 1, currSum, gMax);
    }*/
}

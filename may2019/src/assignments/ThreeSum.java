package assignments;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();
        HashSet uniqueSet = new HashSet();
        for (int k = 0; k < nums.length - 2; ++k) {
            int ref = nums[k];
            int sumLeftToZero = 0 - nums[k];

            for (int i = k + 1; i < nums.length - 1; ++i) {
                for (int j = i + 1; j < nums.length; ++j) {
                    ArrayList<Integer> subList = new ArrayList<Integer>();
                    if (nums[j] == sumLeftToZero - nums[i]) {
                        ArrayList combo = new ArrayList();
                        combo.add(nums[k]);
                        combo.add(nums[i]);
                        combo.add(nums[j]);
                        Collections.sort(combo);
                        System.out.println(combo);
                        if (!uniqueSet.contains(combo)) {
                            subList.add(nums[k]);
                            subList.add(nums[i]);
                            subList.add(nums[j]);
                            retList.add(subList);
                            uniqueSet.add(combo);
                        }
                    }
                }
            }
        }
        return retList;
    }

    public static int threeSumClosest(int[] nums, int target) {
        int closeTotarget = Integer.MAX_VALUE;
        for (int k = 0; k < nums.length - 2; ++k) {
            int twoSumTarget = target - nums[k];

            for (int i = k + 1; i < nums.length - 1; ++i) {
                for (int j = i + 1; j < nums.length; ++j) {
                    if (twoSumTarget - nums[i] - nums[j] < closeTotarget) {
                        closeTotarget = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return closeTotarget;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}

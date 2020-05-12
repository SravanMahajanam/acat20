package assignments;

import java.util.Arrays;

public class RotatedArray {

    public static int minElment(int[] nums) {
        int l = 0, r = nums.length - 1;
        int m;
        while (r - 1 > l) {
            if (nums[l] < nums[r]) {
                return nums[l];
            }
            m = l + (r - l) / 2;
            if (nums[m] > nums[l]) {
                l = m;
            } else if (nums[m] < nums[l]) {
                r = m;
            }
        }
        return nums[l] > nums[r] ? nums[r] : nums[l];
    }

    // this is not working in few cases
    public static int minElementInDuplicatedArray(int[] nums) {
        int l = 0, r = nums.length - 1;
        int m = l + (r - l) / 2;
        while (r - 1 > l) {
            if (nums[l] < nums[r] || nums[l] < nums[m]) {
                return nums[l];
            }
            if (nums[l] == nums[r]) {
                ++l;
                --r;
                continue;
            }
            if (nums[m] > nums[l]) {
                l = m;
            } else if (nums[m] < nums[l]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l] > nums[r] ? nums[r] : nums[l];

    }

    public static boolean searchInDupArray(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        int l = 0, r = nums.length - 1;
        int m;
        while (r - 1 > l) {
            if (nums[l] < nums[r]) {
                int[] seachArray = Arrays.copyOfRange(nums, l, r + 1);
                //return searchInArray(seachArray, target);
            }
            m = l + (r - l) / 2;
            if (nums[l] == nums[r]) {
                if (nums[l] == target) {
                    return true;
                }
                ++l;
                --r;
                continue;
            }
            if (nums[m] > target) {
                if (nums[l] > target) {
                    l = m + 1;
                } else {
                    r = m;
                }
            } else if (nums[m] < target) {
//                if (nums[r] < target) {
//                    r = m;
//                } else {
                l = m + 1;
//                }
            } else {
                return true;
            }
        }
        return (nums[l] == target || nums[r] == target);
    }

    public static boolean searchInArray(int[] nums, int pivot, int target) {
        if (nums.length == 0) {
            return false;
        }
        int l = 0;
        int r = nums.length - 1;
        int m;
        if (target == nums[pivot] || target == nums[l] || target == nums[r]) {
            return true;
        }
        if ((target > nums[l]) && (target > nums[pivot])) {
            r = pivot;
        } else if ((target < nums[r]) && (target > nums[pivot])) {
            l = pivot;
        }
        while (r - 1 > l) {
            m = l + (r - l) / 2;
            if (nums[m] > target) {
                r = m;
            } else if (nums[m] < target) {
                l = m;
            } else {
                return true;
            }
        }
        return (nums[l] == target || nums[r] == target);
    }

    public static int findPivot(int[] nums) {
        if (nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int l = 0;
        int r = nums.length - 1;
        int m = 0;
        if (nums[l] < nums[r])
            return -1;
        while (r - l > 1) {
            m = l + (r - l) / 2;
            if(nums[m] == nums[m + 1]) {
                ++m;
            }
            if (nums[m] > nums[m + 1]) {
                return m + 1;
            }
            if (nums[m] < nums[m + 1] && nums[m] > nums[l]) {
                l = m + 1;
            } else if (nums[m] < nums[m + 1] && nums[r] > nums[m]) {
                r = m;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8,1,2,3};
        int target = 9;
        int pivot = findPivot(nums);
        System.out.println("pivot : "+pivot);
        System.out.println(searchInArray(nums, pivot, target));
    }
}

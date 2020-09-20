package optimization;

public class Triplets {

    // t = O(n^2)
    public static boolean increasingTriplet(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        MyInteger count = new MyInteger();
        auxIncreasingTriplet(nums, 0, count, nums[0]);
        return count.get() == 2;
    }

    private static void auxIncreasingTriplet(int[] nums, int i, MyInteger count, int prevLeft) {
        if (nums.length - i > 2) {
            //left is first element
            int left = nums[i];

            if (prevLeft >= left) {
                count.set(0);
            }
            //right is rest of elements
            if (isLeftSmallerThanAnyRight(left, nums, i + 1)) {
                count.incr();
                prevLeft = left;
            }
            if (count.get() == 2) {
                return;
            }
            auxIncreasingTriplet(nums, i + 1, count, prevLeft);
        } else if (nums.length - i == 2) {
            if (nums[i] < nums[i + 1]) {
                int left = nums[i];
                if (prevLeft >= left) {
                    count.set(0);
                }
                count.incr();
            }
        }
    }

    private static boolean isLeftSmallerThanAnyRight(int left, int[] nums, int rightElemIndex) {
        for (int i = rightElemIndex; i < nums.length; ++i) {
            if (left < nums[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean increasingTriplet2(int[] nums) {
        int[] memory = new int[nums.length + 2];
        memory[nums.length] = Integer.MAX_VALUE;
        memory[nums.length+1] = Integer.MAX_VALUE;
        int count = 0;
        for (int i = nums.length-1;i>=0; --i) {
            if (nums[i] < Math.min(memory[i+1], memory[i+2])) {
                ++count;
            }
            memory[i] = nums[i];
        }

        return count >2;
    }

    public static boolean increasingTriples(int[] nums) {
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i <= nums.length - 1; ++i) {
            if (nums[i] > Math.min(firstLargest, secondLargest)) {
                count++;
                if (secondLargest < firstLargest) {
                    secondLargest = nums[i];
                } else {
                    firstLargest = nums[i];
                }
            }
        }
        return count > 2;
    }

    public static void main(String[] args) {
        int[] nums = {6,9,5,4,2,3};
        System.out.println(increasingTriples(nums));
    }
}

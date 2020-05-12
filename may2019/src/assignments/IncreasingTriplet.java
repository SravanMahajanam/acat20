package assignments;

public class IncreasingTriplet {
    public static boolean increasingTriplet(int[] nums) {
        for (int i = 0, j = 1, k = 2; k<nums.length; ++i, ++j, ++k) {
            if( (nums[i] < nums[j]) && (nums[j] < nums[k]))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[] {2,1,5,0,4,6}));
    }
}

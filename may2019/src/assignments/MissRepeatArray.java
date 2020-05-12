package assignments;

public class MissRepeatArray {
    public int[] findErrorNumsInline(int[] nums) {
        int miss = 0, dup = 0;
        for (int i = 0; i < nums.length; ++i) {
            int pos = nums[i] < 0 ? nums[i] * -1: nums[i];
            if (nums[pos - 1] < 0) {
                dup = pos;
            }
            nums[pos - 1] = nums[pos - 1] * -1;

        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0 && i != dup - 1) {
                miss = i + 1;
                break;
            }
        }
        return new int[] {dup, miss};
    }

    public static int[] findErrorNumsAdditonalMem(int[] nums) {
        int[] retArray = new int[2];
        int[] map = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            ++map[nums[i]];
        }

        int dup = 0;
        int miss = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 0) {
                miss = i;
            }
            if(map[i] == 2) {
                dup = i;
            }
            if(miss != 0 && dup !=0) {
                break;
            }
        }
        return new int[] {dup, miss};
    }
}

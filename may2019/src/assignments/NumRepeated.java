package assignments;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class NumRepeated {
    public static int[] findErrorNums(int[] nums) {
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
        }
        return new int[] {dup, miss};
    }

    public static int firstMissingPositive(int[] nums) {
        /*int[] map = new int[1000];
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= 0)
                continue;
            ++map[nums[i]];
        }

        int miss = 0;
        for (int i = 1; i < map.length; i++) {
            if (map[i] == 0) {
                miss = i;
                break;
            }
        }
        return miss;*/
        int miss = 1;
        if (nums.length == 0)
            return miss;
        HashSet set = new HashSet();
        for (int i = 0;i <nums.length;++i) {
            set.add(nums[i]);
        }

        int i;
        for (i = 1; i <= set.size(); i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return i;

    }

    public static void main(String[] args) {
        int[] in = {1};
        //System.out.println(Arrays.toString(findErrorNums(in)));

        System.out.println(firstMissingPositive(in));
    }
}

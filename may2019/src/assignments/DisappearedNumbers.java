package assignments;

import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int [] temp = new int[nums.length+1];
        for(int i=0; i<nums.length;i++){
            int indexAt = nums[i];
            if (temp[indexAt] != 0)
                continue;
            temp[indexAt] = 1;
        }
        List list = new ArrayList();
        for (int i = 1;i<temp.length;++i) {
            if(temp[i] != 1) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] in = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(in));
    }
}

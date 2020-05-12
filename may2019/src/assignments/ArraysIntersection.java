package assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ArraysIntersection {

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> retSet = new HashSet<Integer>();
        if (nums2.length > nums1.length) {
            for (int i = 0; i<nums1.length; ++i) {
                set.add(nums1[i]);
            }

            for (int i =0; i<nums2.length;++i) {
                if (set.contains(nums2[i])) {
                    retSet.add(nums2[i]);
                }
            }
        } else {
            for (int i = 0; i<nums2.length; ++i) {
                set.add(nums2[i]);
            }

            for (int i =0; i<nums1.length;++i) {
                if (set.contains(nums1[i])) {
                    retSet.add(nums1[i]);
                }
            }
        }
        int[] ret = new int[retSet.size()];
        int i = 0;
        for (int num: retSet) {
            ret[i++] = num;
        }
        return ret;
    }

    public static int[] intersectionDupElements(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (nums2.length > nums1.length) {
            for (int i = 0; i<nums1.length; ++i) {
                if (map.containsKey(nums1[i])) {
                    map.put(nums1[i], map.get(nums1[i]) + 1);
                } else {
                    map.put(nums1[i], 1);
                }
            }

            int[] ret = new int[nums2.length];
            int j = 0;
            for (int i =0; i<nums2.length;++i) {
                if (map.containsKey(nums2[i])) {
                    ret[j] = nums2[i];
                    j++;
                    if (map.get(nums2[i]) == 1) {
                        map.remove(nums2[i]);
                    } else {
                        map.put(nums2[i], map.get(nums2[1]) - 1);
                    }
                }
            }
            return Arrays.copyOfRange(ret, 0, j);
        } else {
            for (int i = 0; i<nums2.length; ++i) {
                if (map.containsKey(nums2[i])) {
                    map.put(nums2[i], map.get(nums2[i]) + 1);
                } else {
                    map.put(nums2[i], 1);
                }
            }

            int[] ret = new int[nums1.length];
            int j = 0;
            for (int i =0; i<nums1.length;++i) {
                if (map.containsKey(nums1[i])) {
                    ret[j] = nums1[i];
                    j++;
                    if (map.get(nums1[i]) == 1) {
                        map.remove(nums1[i]);
                    } else {
                        map.put(nums1[i], map.get(nums1[1]) - 1);
                    }
                }
            }
            return Arrays.copyOfRange(ret, 0, j);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{1,2,2,1}, new int[]{2,2})));
    }
}

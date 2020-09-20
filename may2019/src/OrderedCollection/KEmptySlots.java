package OrderedCollection;

import java.util.TreeSet;

public class KEmptySlots {
    public static int findDay(int[] in, int k) {
        TreeSet<Integer> tSet = new TreeSet<Integer>();
        tSet.add(in[0]);
        for (int i = 1; i < in.length; ++i) {
            Integer floor = tSet.floor(in[i]);
            if (floor != null && in[i] - floor - 1 == k) {
                return i + 1;
            }
            Integer ceil = tSet.ceiling(in[i]);
            if (ceil != null && ceil - in[i] - 1 == k) {
                return i + 1;
            }
            tSet.add(in[i]);
        }
        return 0;
    }
}

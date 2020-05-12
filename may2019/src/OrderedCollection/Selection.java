package OrderedCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

// find kth smallest in a unsorted array
public class Selection {
    public static int select1(int[] in, int k) {
        if(k>in.length) {
            return Integer.MIN_VALUE;
        }
        Arrays.sort(in);
        return in[k+1];
    }

    public static int select2(int[] in, int k) {
        if(k>in.length) {
            return Integer.MIN_VALUE;
        }
        TreeSet<Integer> tSet = new TreeSet<Integer>();
        for (Integer i: in) {
            tSet.add(i);
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i<=k ; ++i) {
            res = tSet.pollFirst();
        }
        return res;
    }

    public static int select3(int[] in, int k) {
        if(k>in.length) {
            return Integer.MIN_VALUE;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (Integer i: in) {
            pq.add(i);
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i<=k ; ++i) {
            res = pq.remove();
        }
        return res;
    }
}

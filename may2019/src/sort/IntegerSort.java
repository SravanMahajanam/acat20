package sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class IntegerSort {

    public static void sort_TreeSet(int[] in) {
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for (int i: in) {
            treeSet.add(i);
        }

        int i = 0;
        for (int x: treeSet) {
            in[i++] = x;
        }
    }

    public static void sort_PQ(int[] in) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i: in) {
            pq.add(i);
        }

        int i = 0;
        while (!pq.isEmpty()) {
            in[i++] = pq.remove();
        }
    }

    public static void mergeSort(int[] in) {
        int l = 0;
        int r = in.length-1;
        int[] aux = new int[r+1];
        auxMergeSort(in,l,r,aux);
    }

    private static void auxMergeSort(int[] in, int l, int r, int[] aux) {
        if (l >= r) {
            return;
        }
        int m = l + (r - l) / 2;
        auxMergeSort(in, l, m,aux);
        auxMergeSort(in, m+1, r,aux);
        merge(in,l,m,r,aux);
    }

    private static void merge(int[] in,  int l, int m, int r, int[] aux) {
        int ls =l, le=m, rs=m+1, re=r;
        int i =0;
        while (ls<=le && rs<=re) {
            if (in[ls] < in[rs]) {
                aux[i++] = in[ls++];
            } else {
                aux[i++] = in[rs++];
            }
        }

        while (ls<=le) {
            aux[i++] = in[ls++];
        }
        while (rs<=re) {
            aux[i++] = in[rs++];
        }
        for(int j = 0; j < i; ++j)
            in[l++] = aux[j];
    }

    public static void main(String[] args) {
        int[] in =new int[]{5,2,7,1,9,4};
        mergeSort(in);
        System.out.println(Arrays.toString(in));
    }
}

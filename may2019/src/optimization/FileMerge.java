package optimization;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class FileMerge {

    public static int minFileMergeCost(int[] files) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for (int file: files) {
            priorityQueue.add(file);
        }

        int mergeCost = 0;
        while (priorityQueue.size()!=1) {
            int minFile1 = priorityQueue.remove();
            int minFile2 = priorityQueue.remove();
            mergeCost = mergeCost+ minFile1+minFile2;
            priorityQueue.add(mergeCost);

        }
        return priorityQueue.remove();
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] in = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; ++i)
            in[i] = r.nextInt(10);
        System.out.println(Arrays.toString(in));
        System.out.println(minFileMergeCost(in));

    }
}

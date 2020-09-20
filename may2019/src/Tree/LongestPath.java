package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LongestPath {

    // pass on the current length (for root pass 0) and increment it for every leaf in its subtrees
    // Have a max property (in Heap) per each stack section and replace it if current length is more than current max proeprty
    public static int longestRootToLeafPath1(TreeNode root) {
        MyInteger gMax = new MyInteger();
        auxLongestRootToLeafPath(root, 0, gMax);
        return gMax.get();
    }

    private static void auxLongestRootToLeafPath(TreeNode root, int currLen, MyInteger gMax) {
        if (root.left == null && root.right == null) {
            if (currLen > gMax.get()) {
                gMax.set(currLen);
            }
            return;
        }
        ++currLen;
        auxLongestRootToLeafPath(root.left, currLen, gMax);
        auxLongestRootToLeafPath(root.right, currLen, gMax);
        return;
    }

    //calculate no.of rows for each sub tree and compare it with current rows value
    public static int longestRootToLeafPath2(TreeNode root) {
        int rows = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            if (temp == null) {
                ++rows;
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return rows;
    }

    // using recursion at idea level, means do not pass the current linght to the subtree as in idea1.
    // Instead let child subtree tell the length to parent
    public static int longestRootToLeafPath3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int ls = longestRootToLeafPath3(root.left);
        int rs = longestRootToLeafPath3(root.right);

        return Math.max(ls, rs) + 1;
    }

    public int longestLeafToLeafPath(TreeNode root) {
        int[] max = new int[1];
        auxLongestLeafToLeafPath(root, max);
        return max[0];
    }

    private int  auxLongestLeafToLeafPath(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int lLen = auxLongestLeafToLeafPath(root.left, max);
        int rLen = auxLongestLeafToLeafPath(root.right, max);

        max[0] = Math.max(max[0], lLen + rLen); // this will hold the max value passed with out root
        return Math.max(lLen, rLen) + 1;
    }
}

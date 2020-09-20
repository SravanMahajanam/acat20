//https://leetcode.com/problems/binary-tree-maximum-path-sum/

package Tree;

public class Leaf2LeafMaxSum {
    public int maxPathSum(TreeNode root) {
        MyInteger gSum = new MyInteger(Integer.MIN_VALUE); // its not zero because if the tree has only one node say (-3) then sum shouldn't be 0 it should be -3.
        auxMaxPathSum(root, gSum);
        return gSum.get();
    }

    private int auxMaxPathSum(TreeNode root, MyInteger gSum) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(0, auxMaxPathSum(root.left, gSum));
        int rightSum = Math.max(0, auxMaxPathSum(root.right, gSum));
        int sum = leftSum + root.val + rightSum;
        gSum.set(Math.max(gSum.get(), sum));
        return root.val + Math.max(leftSum, rightSum);
    }
}

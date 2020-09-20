package Tree;

public class TiltTree {
    public int findTilt(TreeNode root) {
        int leftSum = findSum(root.left);
        int rightSum = findSum(root.right);
        if (leftSum < rightSum) {
            return rightSum - leftSum;
        }
        return leftSum - rightSum;
    }

    private int findSum(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        if (tree.left == null && tree.right == null) {
            return tree.val;
        }

        int left = findSum(tree.left);
        int right = findSum(tree.right);
        return  tree.val + left + right;
    }
}

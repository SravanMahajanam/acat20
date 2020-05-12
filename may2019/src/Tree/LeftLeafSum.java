package Tree;

public class LeftLeafSum {

    public static int leftLeafSum(TreeNode root) {
        return auxLeftLeafSum(root, 'B');
    }

    public static int auxLeftLeafSum(TreeNode root, char type) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null && type == 'L') {
            if (type == 'L') {
                return root.val;
            }
            return 0;
        }
        int lsLSum = auxLeftLeafSum(root.left, 'L');
        int rsLSum = auxLeftLeafSum(root.right, 'R');
        return lsLSum + rsLSum;
    }
}

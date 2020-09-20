package BST;


public class TreeChecks {
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        return Math.abs(lHeight - rHeight) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public boolean isValidBST(TreeNode root) {
        return auxIsValidBST(root, null, null);
    }

    private boolean auxIsValidBST(TreeNode root, TreeNode lower, TreeNode upper) {
        if (root == null) {
            return true;
        }

        if (lower != null && lower.val > root.val) {
            return false;
        }
        if (upper != null && upper.val < root.val) {
            return false;
        }

        if (!auxIsValidBST(root.left, lower, root)) {
            return false;
        }

        if (!auxIsValidBST(root.right, root, upper)) {
            return false;
        }
        return true;
    }
}

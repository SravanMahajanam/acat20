package BST;

public class BSTTrimmer {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return root;
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        if (root.val < L) {
            return root.right;
        }
        if (root.val > R) {
            return root.left;
        }
        return root;
    }
}

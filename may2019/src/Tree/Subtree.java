package Tree;

import java.util.Collections;

public class Subtree {
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        if (s == null) { // dont need to check t == null ?
            return false;
        }
        // breaking condition
        if (isIdentical(s, t)) {
            return true;
        }

        return isSubtree(s.left, t) || isSubtree(s.right, t);

    }

    private static boolean isIdentical(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if ((s == null && t != null) || (s != null && t == null)) {
            return false;
        }

        if (s.val != t.val) {
            return false;
        }

        return isIdentical(s.left, t.left) && isIdentical(s.right, t.right);
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        isSubtree(s, treeNode);
    }
}

package Tree;


import java.util.LinkedList;
import java.util.Queue;

public class LCA {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        // left traversal
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // right traversal
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left!=null && right!=null) {
            return root;
        } else if(left != null) {
            return left;
        } else if(right != null) {
            return right;
        } else {
            return null;
        }

    }

}


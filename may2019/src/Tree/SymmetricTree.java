package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTree {
    public boolean isSymmetric_Iterative(TreeNode root) {
        Queue<TreeNode> lTree = new LinkedList();
        Queue<TreeNode> rTree = new LinkedList();
        lTree.add(root);
        rTree.add(root);
        while (!lTree.isEmpty() &&  !rTree.isEmpty()) {
            TreeNode node1 = lTree.remove();
            TreeNode node2 = rTree.remove();

            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }

            if (node1.val != node2.val) {
                return false;
            }

            lTree.add(node1.left);
            lTree.add(node1.right);

            rTree.add(node2.right);
            rTree.add(node2.left);
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return auxIsSymmetric(root.left, root.right);
    }

    private boolean auxIsSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return auxIsSymmetric(left.left, right.right) && auxIsSymmetric(left.right, right.left);
    }

}

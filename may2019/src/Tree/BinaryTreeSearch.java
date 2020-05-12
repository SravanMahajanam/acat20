package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSearch {

    public static boolean searchElement1(TreeNode root, int x) {
        if (root == null) {
            return false;
        }
        if (root.val == x) {
            return true;
        }
        if (searchElement1(root.left, x)) {
            return true;
        }
        return searchElement1(root.right, x);
    }

    public static boolean searchElement2(TreeNode root, int x) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        if (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            if (temp.val == x) {
                return true;
            }
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.left);
            }
        }
        return false;
    }

    private static TreeNode findPredecessor(TreeNode root) {
        TreeNode temp = root;
        temp = temp.left;
        while (temp.right != null && temp.right != root) {
            temp = temp.right;
        }
        return temp;
    }

    public static boolean searchElement3(TreeNode root, int x) {
        while (root!=null) {
            if (root == null) {
                return false;
            }
            if (root.val == x) {
                return true;
            }
            // should traverse left or right of root?
            if (root.left != null) { // traverse left
                TreeNode temp = findPredecessor(root);
                if (temp.right == null) {
                    temp.right = root;
                    root = root.left;
                } else { // traverse right
                    root = root.right;
                }
            } else {// traverse right
                root = root.right;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        TreeNode root = BinaryTreeUtils.createUniqueBinaryTree(n);
        BinaryTreeUtils.displayTree(root);
        System.out.println("searchElement 1 : " + searchElement1(root, 1));
        System.out.println("searchElement 2 : " + searchElement2(root, 1));
        System.out.println("searchElement 3 : " + searchElement3(root, 1));

    }
}

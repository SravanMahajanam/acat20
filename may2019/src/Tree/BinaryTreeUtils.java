package Tree;

import java.util.Random;

public class BinaryTreeUtils {

    private static TreeNode add1(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        TreeNode current = root, parent = null;
        Random r = new Random();
        while (current != null) {
            parent = current;
            if (r.nextInt(2) == 0) {
                if (current.left == null) {
                    parent.left = new TreeNode(val);
                    break;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    parent.right = new TreeNode(val);
                    break;
                }
                current = current.right;
            }
        }
        return root;
    }

    private static TreeNode add2(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        TreeNode current = root, parent = null;
        Random r = new Random();
        while (current != null) {
            parent = current;
            if (r.nextInt(2) == 0) {
                if (current.left == null) {
                    parent.left = new TreeNode(val);
                    break;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    parent.right = new TreeNode(val);
                    break;
                }
                current = current.right;
            }
        }
        return root;
    }


    //it is generating biased binary trees not the random binary tree
    public static TreeNode createBinaryTree(int n) {
        Random r = new Random();
        TreeNode root = null;
        for (int i = 0; i < n; ++i) {
            int val = r.nextInt(n) + 1;
            root = add1(root, val);
        }
        return root;
    }

    public static TreeNode createUniqueBinaryTree(int n) {
        TreeNode root = null;
        for (int i = 0; i < n; ++i)
            root = add1(root, i + 1);
        return root;
    }

    public static TreeNode createOneSidedBinaryTree(int n) {
        Random r = new Random();
        TreeNode root = null;
        for (int i = 0; i < n; ++i) {
            int val = r.nextInt(n) + 1;
            TreeNode tmp = new TreeNode(val);
            if (root != null) {
                tmp.left = root;
            }
            root = tmp;
        }
        return root;
    }


    public static void displayTree(TreeNode root) {
        auxDisplay(root, 0, "Root");
    }

    private static void auxDisplay(TreeNode root, int nspaces, String type) {
        if (root == null)
            return;
        for (int i = 0; i < nspaces; ++i)
            System.out.print(' ');
        System.out.println(root.val + "(" + type + ")");
        auxDisplay(root.left, nspaces + 4, "L");
        auxDisplay(root.right, nspaces + 4, "R");
    }

    public static void main(String[] args) {
        //int n = Integer.parseInt(args[0]);
        TreeNode root = BinaryTreeUtils.createBinaryTree(3);
        BinaryTreeUtils.displayTree(root);

    }
}

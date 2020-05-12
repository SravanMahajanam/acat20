package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeSize {

    // use recursion call left and right sub trees.
    // If leaves are null add the left and right subtrees count and 1 (1 is for current node)
    public static int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int ls = countNodes1(root.left);
        int rs = countNodes1(root.right);
        return ls + rs + 1;
    }

    // keep adding the root node to the list at the end
    // Till the list is empty, remove a node increment counter
    // Now add its left and right nodes if they aren't null

    // keep this repeating
    // every time a node is added to queue (list) we will check its children and add them to queue.
    // queue will be the driving force if all elements are added and removed from queue then it will be empty and we are done.
    public static int countNodes2(TreeNode root) {
        int count = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.remove();
            ++count;
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
        return count;
    }

    // use inplace traversal and use the null pointers to remember the root node
    // so that we can come back and traverse right subtree.
    // The right most leaf node of a left subtree can be pointed to the root.

    // If node has left make its bottom most right (which will have its right as null) will be pointed to the current node.
    // Once the leaf is done its right will get the flow to the current (root)
    // Now we have to remove the temp link so that we dont get into a infinite loop (as we already done with left side traversal)
    // Start with the right subtree now
    public static int countNodes3(TreeNode root) {
        int count = 0;
        while (root != null) {
            if (root.left != null) {
                TreeNode temp = inlinePredecessor(root);
                if (temp.right == null) {
                    temp.right = root;
                    root = root.left;
                    ++count;
                } else {
                    root = root.right;
                    temp.right = null; // make the input tree is unchanged
                }
            } else {
                root  = root.right;
                ++count;
            }
        }
        return count;
    }

    private static TreeNode inlinePredecessor(TreeNode root) {
        TreeNode temp = root;
        root = root.left;
        while (root.right != null && root.right != temp) {
            root = root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtils.createBinaryTree(5);
        BinaryTreeUtils.displayTree(root);
        System.out.println(countNodes3(root));
    }
}

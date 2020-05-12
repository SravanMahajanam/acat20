package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftMostLeaf {
    public static int findBottomLeftValue_old(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        int leftLeaf = Integer.MIN_VALUE;
        boolean grabNext = true;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            if(temp!=null) {
                if (temp.left!=null) {
                    queue.add(temp.left);
                }
                if (temp.right!=null) {
                    queue.add(temp.right);
                }
                if (grabNext) {
                    leftLeaf = temp.val;
                    grabNext = false;
                }
            } else if (queue.size()>0){
                queue.add(null);
                grabNext = true;
            }
        }
        return leftLeaf;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(findBottomLeftValue(root));
    }

    public static int findBottomLeftValue(TreeNode root) {
        int returnVal = 0;
        boolean take = true;
        Queue queue = new LinkedList();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode temp = (TreeNode) queue.remove();
            if (temp != null && take) {
                returnVal = temp.val;
                take = false;
            }
            if (temp == null) {
                take = true;
                continue;
            }
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            if (temp != null && queue.peek() == null) {
                queue.add(null);
            }
        }
        return returnVal;
    }
}

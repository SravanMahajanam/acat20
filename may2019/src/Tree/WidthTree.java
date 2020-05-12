package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class WidthTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxWidth = 0;
        Queue queue = new LinkedList();
        queue.add(root);
        queue.add(new TreeNode(Integer.MIN_VALUE));
        int levelWidth = 0;
        int level = 0;
        while (!queue.isEmpty()) {
            int levelMaxWidth = 2 ^ level;
            while (levelMaxWidth > 0) {
                if (((LinkedList) queue).get(levelMaxWidth - 1) != null) {
                    maxWidth = levelMaxWidth;
                    break;
                }
                levelMaxWidth--;
            }
            TreeNode temp = (TreeNode) queue.remove();
            TreeNode nextNode = (TreeNode) queue.peek();
            if ((temp == null && nextNode == null) || (nextNode != null && nextNode.val != Integer.MIN_VALUE)) {
                queue.add(null);
                queue.add(null);
            } else {
                if (temp != null) {
                    queue.add(temp.left);
                    queue.add(temp.right);
                }
            }

            if (temp != null && nextNode != null && nextNode.val == Integer.MIN_VALUE) {
                queue.remove();
                queue.add(new TreeNode(Integer.MIN_VALUE));
                level++;
            }
        }
        return maxWidth;
    }
}

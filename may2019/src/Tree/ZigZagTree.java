package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTree {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList retList = new ArrayList<List>();
        if (root == null) {
            return retList;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        boolean left2Right = true;
        queue.add(root);
        queue.add(null);
        ArrayList levelList = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            if (temp != null) {
                if (left2Right) {
                    levelList.add(temp.val);
                } else {
                    levelList.add(0, temp.val);
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            if (temp == null && !queue.isEmpty()) {
                retList.add(levelList);
                levelList = new ArrayList<Integer>();
                left2Right = !left2Right;
                continue;
            }
            if (temp != null && queue.peek() == null) {
                queue.add(null);
            }
        }
        return retList;
    }


}

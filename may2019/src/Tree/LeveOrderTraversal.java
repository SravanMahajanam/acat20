package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeveOrderTraversal {
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> largestList = new LinkedList<Integer>();
        if (root == null) {
            return largestList;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);
        queue.add(null);
        int lLarge = Integer.MIN_VALUE;
        int currValue = 0;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            if (temp!=null) {
                if (temp.left!=null) {
                    queue.add(temp.left);
                }
                if (temp.right!=null) {
                    queue.add(temp.right);
                }
                currValue = temp.val;
                if (currValue>lLarge) {
                    lLarge = currValue;
                }
            } else if (queue.size()>0){
                largestList.add(lLarge);
                lLarge = Integer.MIN_VALUE;
                queue.add(null);
            }
        }
        largestList.add(lLarge);
        return largestList;
    }
}

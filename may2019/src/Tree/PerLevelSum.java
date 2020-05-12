package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class PerLevelSum {

    public static void perLevelSum(TreeNode root) {
        int levelSum = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            if(temp == null) {
                System.out.println(levelSum);
                levelSum = 0;
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                levelSum = levelSum + temp.val;
                if (temp.left!= null) {
                    queue.add(temp.left);
                }
                if (temp.right!= null) {
                    queue.add(temp.right);
                }
            }
        }
    }

    public static int totalLevels(TreeNode root) {
        int levels = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null); // add null as we know one level (first level) is finished.

        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            if(temp == null) {
                levels++;
                if (!queue.isEmpty()) {
                    queue.add(null); // null insertion should happen only if temp ==null, because only now we know that a leve is finished.
                }
            } else {
                if (temp.left!= null) {
                    queue.add(temp.left);
                }
                if (temp.right!= null) {
                    queue.add(temp.right);
                }
                /* null insertion shouldn't happen here because we dont know if the temp is either the left node or right node of its parent.
                 * If its left node we level is not yet finished becase there might be a right node.
                  * So only after both left and right of temp are added w should add null.
                  * This is known when we get null because when we are removed node from queue its children are added here*/
            }
        }
        return levels;
    }

    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtils.createBinaryTree(5);
        BinaryTreeUtils.displayTree(root);
        System.out.println(totalLevels(root));
    }
}

package BST;

import java.util.ArrayList;

public class NodeDifference {
    public int minDiffInBST(TreeNode root) {
        ArrayList<Integer> inOrder = new ArrayList();
        inOrder(root, inOrder);
        MyInteger minDiff = new MyInteger(Integer.MAX_VALUE);
        findMinDiff(inOrder, minDiff);
        return minDiff.get();
    }

    private void inOrder(TreeNode root, ArrayList<Integer> inOrder) {
        if (root == null) {
            return;
        }
        inOrder(root.left, inOrder);
        inOrder.add(root.val);
        inOrder(root.right, inOrder);
    }

    private void findMinDiff(ArrayList<Integer> inOrder, MyInteger minDiff) {
        for (int i = 1; i < inOrder.size(); ++i) {
            if (inOrder.get(i) - inOrder.get(i - 1) < minDiff.get()) {
                minDiff.set(inOrder.get(i) - inOrder.get(i - 1));
            }
        }
    }


}

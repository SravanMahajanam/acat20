package Tree;

import java.util.ArrayList;
import java.util.List;

public class FlattenTree {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList();
        auxFlatten(root, list);
        int index = 1;
        while (index < list.size()) {
            root.left = null;
            root.right = list.remove(index);
            root = root.right;
            ++index;
        }
    }

    private void auxFlatten(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }

        list.add(root);
        auxFlatten(root.left, list);
        auxFlatten(root.right, list);
    }
}

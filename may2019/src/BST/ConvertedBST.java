package BST;

public class ConvertedBST {
    public TreeNode convertBST(TreeNode root) {
        MyInteger currSum = new MyInteger();
        auxConvertBST(root, currSum);
        return root;
    }

    private void auxConvertBST(TreeNode root, MyInteger currSum) {
        if (root == null) {
            return;
        }
        auxConvertBST(root.right, currSum);
        root.val = root.val + currSum.get();
        currSum.set(root.val);
        auxConvertBST(root.left, currSum);
    }
}

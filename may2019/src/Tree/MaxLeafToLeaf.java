package Tree;

public class MaxLeafToLeaf {
    public static int leaf2LeafMaxLength(TreeNode root) {
        MyInteger gMax = new MyInteger(0);
        auxLeaf2LeafMaxLength(root, gMax);
        return gMax.get();
    }

    private static int auxLeaf2LeafMaxLength(TreeNode root, MyInteger gMax) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = auxLeaf2LeafMaxLength(root.left, gMax);
        int right = auxLeaf2LeafMaxLength(root.right, gMax);
        gMax.set(Math.max(gMax.get(), (left + right + 1)));
        return (Math.max(left, right) + 1);
    }

    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtils.createBinaryTree(10);
        BinaryTreeUtils.displayTree(root);
        System.out.println(leaf2LeafMaxLength(root));
    }

}

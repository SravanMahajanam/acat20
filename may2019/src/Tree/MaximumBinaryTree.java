package Tree;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return auxConstructMaxTree(nums, 0, nums.length );
    }

    private TreeNode auxConstructMaxTree(int[] nums, int start, int end) {
        TreeNode root = null;
        if (start < end) {
            int position = findMaxPos(nums, start, end);
            root = new TreeNode(nums[position]);
            root.left = auxConstructMaxTree(nums, start, position);
            root.right = auxConstructMaxTree(nums, position + 1, end);
        }
        return root;
    }

    private int findMaxPos(int[] nums, int start, int end) {
        int max = nums[start];
        int maxPos = start;
        for (int i = start + 1; i < end; ++i) {
            if (nums[i] > max) {
                maxPos = i;
                max = nums[i];
            }
        }
        return maxPos;
    }

    public static void main(String[] args) {
        MaximumBinaryTree maximumBinaryTree = new MaximumBinaryTree();
        int[] input = new int[]{3,2,1,6,0,5};
        maximumBinaryTree.constructMaximumBinaryTree(input);
    }
}

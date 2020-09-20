package BST;

public class BSTCreator {
    public BSTNode sortedArrayToBST(int[] nums) {
        return auxSortedArrayToBST(nums, 0, nums.length);
    }

    private BSTNode auxSortedArrayToBST(int[] nums, int start, int end) {
        BSTNode temp = null;
        if (end > start) {
            int mid = (start + end) / 2;
            temp = new BSTNode(nums[mid]);
            temp.left = auxSortedArrayToBST(nums, start, mid - 1);
            temp.right = auxSortedArrayToBST(nums, mid + 1, end);
        }
        return temp;
    }
}

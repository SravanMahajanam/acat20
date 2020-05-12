package BST;

import Tree.MyInteger;

public class KthSmallest {

    public static int findKthSmallest1(BSTNode root, int k) {
        MyInteger count = new MyInteger(0);
        int res = auxFindKthSmallest1(root, k, count).val;
        if (auxFindKthSmallest1(root, k, count) == null) {
            return Integer.MIN_VALUE;
        }
        return res;
    }

    private static BSTNode auxFindKthSmallest1(BSTNode root, int k, MyInteger count) {
        if (root == null) {
            return null;
        }
        BSTNode temp = auxFindKthSmallest1(root.left, k, count);
        if (temp != null) {
            return temp;
        }
        count.incr();
        if (count.get() == k) {
            return root;
        }
        return auxFindKthSmallest1(root.right,k,count);
    }

    public static int findKthSmallest2(BSTNode root, int k) {
        int res = Integer.MIN_VALUE;
        /*while (root!=null) {
            if (root.LST_SIZE + 1 == k) {
                return root.val;
            }
            if (root.LST_SIZE + 1 < k) {
                //consider right sub tree
                k = k - (root.LST_SIZE + 1);
                root = root.right;
            } else {
                // consider left sub tree
                root = root.left;
            }
        }*/
        return res;
    }
}

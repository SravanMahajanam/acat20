package Tree;

import org.omg.PortableInterceptor.INACTIVE;

public class SecondMinimumNode {

    public static int secondMinNode(TreeNode root) {
        MyInteger ssLS = new MyInteger(Integer.MAX_VALUE);
        MyInteger ssRS = new MyInteger(Integer.MAX_VALUE);
        return auxSecondMinNode(root, ssLS, ssRS);
    }

    // failing in few cases
    private static int auxSecondMinNode(TreeNode root, MyInteger ssLS, MyInteger ssRS) {
        if (root == null) {
            return -1;
        }
        if (root.left != null) {
            if (root.val < root.left.val && ssLS.get() >= root.left.val) {
                ssLS.set(root.left.val);
                if (root.left.val == Integer.MAX_VALUE) { // this for edge case when value is MAX_VALUE
                    ssLS.setMaxFound(true);
                }
            }
            auxSecondMinNode(root.left, ssLS, ssRS);
        }
        if (root.right != null) {
            if (root.val < root.right.val && ssRS.get() >= root.right.val) { // this for edge case when value is MAX_VALUE
                ssRS.set(root.right.val);
                if (root.right.val == Integer.MAX_VALUE) {
                    ssLS.setMaxFound(true);
                }
            }
            auxSecondMinNode(root.right, ssLS, ssRS);
        }
        if ((ssLS.get()== Integer.MAX_VALUE && ssRS.get() == Integer.MAX_VALUE) && !(ssLS.isMaxFound() || ssRS.isMaxFound())) {
            return -1;
        }
        return ssLS.get() < ssRS.get() ? (ssLS.isMaxFound() || ssRS.isMaxFound()) ? Integer.MAX_VALUE : ssLS.get() : (ssLS.isMaxFound() || ssRS.isMaxFound()) ? Integer.MAX_VALUE : ssRS.get();
    }

    public static void main(String[] args) {
        TreeNode rootmain = new TreeNode();
        TreeNode temprootmain = new TreeNode();
        TreeNode root = new TreeNode(2);
        TreeNode temp = new TreeNode(2147483647);
        root.left = temp;
        temp = new TreeNode(2);
        root.right = temp;
       /* rootmain = root;
        temprootmain = root;

        root = root.left;
        temp = new TreeNode(3);
        root.left = temp;
        temp = new TreeNode(4);
        root.right = temp;
        temprootmain = root;

        root = root.left;
        temp = new TreeNode(5);
        root.left = temp;
        temp = new TreeNode(3);
        root.right = temp;

        root = temprootmain.right;
        temp = new TreeNode(4);
        root.left = temp;
        temp = new TreeNode(4);
        root.right = temp;

        root = rootmain.right;
        temp = new TreeNode(2);
        root.left = temp;
        temp = new TreeNode(5);
        root.right = temp;

        root = root.left;
        temp = new TreeNode(5);
        root.left = temp;
        temp = new TreeNode(2);
        root.right = temp;

        root = rootmain;*/

        //BinaryTreeUtils.displayTree(root);
        System.out.println(secondMinNode(root));
    }

    public static int findSecondMinimumValue(TreeNode root) {
        int[] minElements = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        auxFindSecondMinimumValue(root, minElements);
        if (minElements[0] == minElements[1] || minElements[0] == Integer.MIN_VALUE) {
            return -1;
        }
        return minElements[1];
    }

    public static void auxFindSecondMinimumValue(TreeNode root, int[] minElements) {
        if (minElements[0] == Integer.MIN_VALUE || minElements[0] >= root.val) {
            minElements[0] = root.val;
        } else if (minElements[1] == Integer.MIN_VALUE || minElements[1] >= root.val) {
            minElements[1] = root.val;
        } else {
            if (minElements[0] == minElements[1] && minElements[0] != Integer.MAX_VALUE) {
                minElements[1] = root.val;
            }
        }
        if (root.left == null && root.right == null) {
            return;
        }
        auxFindSecondMinimumValue(root.left, minElements);
        auxFindSecondMinimumValue(root.right, minElements);
    }
}

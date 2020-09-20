package BST;

public class Ceil {

    public static Integer ceilElement1(BSTNode root, int x) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int element = ceilElement1(root.left, x);
        if (element > x) {
            return element;
        }
        if (root.val >= x) {
            return root.val;
        }
        element = ceilElement1(root.right, x);
        if (element > x) {
            return element;
        }
        return Integer.MIN_VALUE;
    }

    public static int ceilElement2(BSTNode root, int x) {
        int res = Integer.MIN_VALUE;
        return auxCeilElement2(root, x, res);
    }

    public static int auxCeilElement2(BSTNode root, int x, int res) {
        while (root != null) {
            if (root.val >= x) {
                // prune right
                res = root.val;
                root = root.left;
            } else {
                //prune left
                root = root.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BSTNode root = new BSTNode(20);
       // root.left = new BSTNode(10);
        //root.right = new BSTNode(30);
        System.out.println(ceilElement2(root, 10));
    }
}

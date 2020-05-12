package BST;

public class SearchElement {

    public static boolean isElementFound(BSTNode root, int x) {
        while (root == null) {
            if (root.val == x) {
                return true;
            }
            if (x < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return false;
    }
}

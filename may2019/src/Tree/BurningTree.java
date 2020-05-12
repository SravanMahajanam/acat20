package Tree;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;

import java.util.ArrayList;
import java.util.List;

public class BurningTree {

    public static void burnTree(TreeNode root, int target) {
        ArrayList in = new ArrayList();
        inorder(root, in);
        ArrayList pre = new ArrayList();
        preOrder(root, pre);
        ArrayList post = new ArrayList();
        postOrder(root, post);

        ArrayList temp = new ArrayList();
        System.out.println(target);
        temp.add(target);
        int element = 0;

        while (!temp.isEmpty()) {
            boolean printNewLine = false;
            int burn = (Integer) temp.get(0);
            if (!(burn == (Integer) in.get(0) && burn == (Integer) post.get(0))) {
                if (in.indexOf(burn) - 1 >= 0) {
                    element = (Integer) in.get(in.indexOf(burn) - 1);
                    if (!(element == (Integer) in.get(0) && element == (Integer) post.get(0))) {
                        if (!temp.contains(element)) {
                            temp.add(element);
                            System.out.print(element);
                            System.out.print(',');
                        }
                    }
                }

                if (pre.indexOf(burn) - 1 >= 0) {
                    element = (Integer) pre.get(pre.indexOf(burn) - 1);
                    if (!(element == (Integer) in.get(0) && element == (Integer) post.get(0))) {
                        if (!temp.contains(element)) {
                            temp.add(element);
                            System.out.print(element);
                            System.out.print(',');
                        }
                    }
                }

                if (post.indexOf(burn) - 1 >= 0) {
                    element = (Integer) post.get(post.indexOf(burn) - 1);
                    if (!(element == (Integer) in.get(0) && element == (Integer) post.get(0))) {
                        if (!temp.contains(element)) {
                            temp.add(element);
                            System.out.print(element);
                        }
                    }
                    printNewLine = true;
                }
                in.remove(in.indexOf(burn));
                pre.remove(pre.indexOf(burn));
                post.remove(post.indexOf(burn));
            }
            temp.remove(0);
            if (printNewLine) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(12);

        root.left = new TreeNode(19);
        root.right = new TreeNode(82);

        root.left.left = new TreeNode(41);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(95);

        root.left.left.right = new TreeNode(2);

        root.right.left.left = new TreeNode(21);

        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(16);

        int targetNode = 41;*/

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(13);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(15);
        root.right.left.left = new TreeNode(21);
        root.right.left.right = new TreeNode(22);
        root.right.right.left = new TreeNode(23);
        root.right.right.right = new TreeNode(24);
        int targetNode = 14;


        burnTree(root, targetNode);
    }

    public static void inorder(TreeNode root, ArrayList in) {
        if (root == null) {
            return;
        }
        inorder(root.left, in);
        in.add(root.val);
        inorder(root.right, in);
    }

    public static void preOrder(TreeNode root, ArrayList pre) {
        if (root == null) {
            return;
        }
        pre.add(root.val);
        preOrder(root.left, pre);
        preOrder(root.right, pre);
    }

    public static void postOrder(TreeNode root, ArrayList post) {
        if (root == null) {
            return;
        }
        postOrder(root.left, post);
        postOrder(root.right, post);
        post.add(root.val);
    }
}

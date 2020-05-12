package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerDe {

    public static String serialize1(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        auxSerialize1(root, sb);
        return sb.toString();
    }

    private static void auxSerialize1(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val + ",");
        auxSerialize1(root.left, sb);
        auxSerialize1(root.right, sb);
        return;
    }

    public static TreeNode deserialize11(String in) {
        String[] inArray = in.split(",");
        Queue<String> queue = new LinkedList<String>();
        for (String elemval : inArray) {
            queue.add(elemval);
        }
        return auxDeserialize11(queue);
    }

    private static TreeNode auxDeserialize11(Queue<String> queue) {
        //while (!queue.isEmpty()) {
        String val = queue.remove();
        if (val.equals("#")) {
            return null;
        }
        TreeNode temp = new TreeNode(Integer.parseInt(val));
        temp.left = auxDeserialize11(queue);
        temp.right = auxDeserialize11(queue);
        return temp;
//        }
    }

    public static TreeNode deserialize12(String in) {
        String[] inArray = in.split(",");
        MyInteger index = new MyInteger(0);
        return auxDeserialize12(inArray, index);
    }

    private static TreeNode auxDeserialize12(String[] in, MyInteger index) {
        String val = in[index.get()];
        index.incr();
        if (val.equals("#")) {
            return null;
        }
        TreeNode temp = new TreeNode(Integer.parseInt(val));
        temp.left = auxDeserialize12(in, index);
        temp.right = auxDeserialize12(in, index);
        return temp;
    }

    public static TreeNode deserialize2(String[] in, String[] pre) {
        MyInteger index = new MyInteger(0);
        return auxDeserialize2(in, pre, 0, in.length - 1, index);
    }

    private static TreeNode auxDeserialize2(String[] in, String[] pre, int l, int r, MyInteger index) {
        TreeNode root = null;
        if (l < r) {
            int val = Integer.parseInt(pre[index.get()]);
            root = new TreeNode(val);
            index.incr();
            int pos = findPosition(in, val);
            root.left = auxDeserialize2(in, pre, l, pos - 1, index);
            root.right = auxDeserialize2(in, pre, pos + 1, r, index);
        }
        return root;
    }

    private static int findPosition(String[] in, int val) {
        for (int i = 0; i < in.length - 1; ++i) {
            if (Integer.parseInt(in[i]) == val) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        MyInteger index = new MyInteger(postorder.length-1);
        return auxBuildTree(inorder, postorder, index, 0, inorder.length-1);
    }

    private TreeNode auxBuildTree(int[] inorder, int[] postorder, MyInteger index, int startIndex, int endIndex) {
        TreeNode root = null;
        while (index.get() >= 0 && startIndex <= endIndex) {
            int currentValue = postorder[index.get()];
            root = new TreeNode(currentValue);
            int pos = findPosition(inorder, currentValue);
            index.decr();
            root.right = auxBuildTree(inorder, postorder, index, pos + 1, endIndex);
            root.left = auxBuildTree(inorder, postorder, index, startIndex, pos - 1);
        }
        return root;
    }

    private static int findPosition(int[] in, int val) {
        for (int i = 0; i < in.length - 1; ++i) {
            if (in[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        TreeNode root = BinaryTreeUtils.createBinaryTree(n);
        BinaryTreeUtils.displayTree(root);
        String tmp = serialize1(root);
        System.out.println(tmp);
        root = deserialize12(tmp);
        BinaryTreeUtils.displayTree(root);
    }
}

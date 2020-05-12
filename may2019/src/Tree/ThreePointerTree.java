package Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ThreePointerTree {
    public static Node connectNext(Node root) {
        Queue<Node> queue1 = new LinkedList<Node>();
        Node temp = null;
        Node temp1 = null;
        queue1.add(root);
        int level = 0;
        int levelCount = 0;
        int currNodeCount = 0;
        while (!queue1.isEmpty()) {
            levelCount = (int) Math.pow(2, level);
            temp = queue1.remove();
            ++currNodeCount;
            if (temp!=null) {
                queue1.add(temp.left);
                queue1.add(temp.right);
            }
            temp1 = queue1.peek();
            if (temp!=null) {
                if (currNodeCount == levelCount) {
                    temp.next = null;
                    ++level;
                    currNodeCount = 0;
                } else {
                    if (temp1 != null) {
                        temp.next = temp1;
                    } else {
                        queue1.remove();
                        ((LinkedList<Node>) queue1).addFirst(temp);
                    }
                }
            }
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue queue = new LinkedList();
        queue.add(root);
        queue.add(new Node(Integer.MIN_VALUE, null, null, null));
        while (!queue.isEmpty()) {
            Node currNode = (Node) queue.remove();
            Node nextNode = (Node) queue.peek();
            if (currNode != null && currNode.val != Integer.MIN_VALUE) {
                if (nextNode != null && nextNode.val == Integer.MIN_VALUE) {
                    currNode.next = null;
                } else {
                    currNode.next = nextNode;
                }
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            if ((currNode.val != Integer.MIN_VALUE) && (nextNode != null && nextNode.val == Integer.MIN_VALUE)) {
                queue.add(new Node(Integer.MIN_VALUE, null, null, null));
            }
        }
        return root;
    }
};
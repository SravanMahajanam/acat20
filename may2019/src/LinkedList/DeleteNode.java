package LinkedList;

public class DeleteNode {

    public static void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
        nextNode = null;
    }
}

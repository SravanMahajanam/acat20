package LinkedList;

public class RemoveNode {

    public static ListNode removeNthNodeFromEnd(ListNode head, int n) {
        int l = getLength(head);
        int nodeFromStart = l - n;
        int i = 0;
        ListNode curr = head;
        while (curr != null) {
            if (i == l - n - 1) {
                curr.next = curr.next.next;
            }
            ++i;
        }
        return head;

    }

    private static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }
}

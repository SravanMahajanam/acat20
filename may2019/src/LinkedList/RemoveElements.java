package LinkedList;

public class RemoveElements {
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        int i = 0;
        ListNode prev = head;
        ListNode curr = head;
        while (curr!=null) {
            if (i == 0 && head.val == val) {
                head = head.next;
                curr = head;
                prev = head;
                continue;
            }
            ++i;
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}

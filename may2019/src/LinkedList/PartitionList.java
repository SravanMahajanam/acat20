package LinkedList;

public class PartitionList {
    public static ListNode partition(ListNode head, int x) {
        ListNode left = null;
        ListNode leftTemp = null;
        ListNode right = null;
        ListNode rightTemp = null;

        while (head != null) {
            if (head.val < x) {
                if (left == null) {
                    left = head;
                    leftTemp = left;
                }else {
                    leftTemp.next = head;
                    leftTemp = leftTemp.next;
                }
            } else {
                if (right == null) {
                    right = head;
                    rightTemp = right;
                }else {
                    rightTemp.next = head;
                    rightTemp = rightTemp.next;
                }
            }
            head = head.next;
        }
        rightTemp.next = null;
        if (leftTemp != null) {
            leftTemp.next = right;
        } else {
            left = right;
        }
        return left;
    }
}

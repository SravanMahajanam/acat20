package LinkedList;

public class RemoveDupedElements {

    /*
    Runtime: 3 ms, faster than 5.88% of Java online submissions
    Memory Usage: 36.3 MB, less than 100.00% of Java online submissions
    */
    public ListNode removeDups(ListNode head) {
        if (head == null) {
            return null;
        }
        int i = 0;
        boolean first = false;
        ListNode temp = head;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                if (i == 0) {
                    first = true;
                }
                int dupVal = curr.val;
                temp.next = curr.next.next;
                if (curr != null && curr.next != null) {
                    if (first) {
                        curr = curr.next;
                    } else {
                        curr = curr.next.next;
                    }
                    while (curr!=null && curr.val == dupVal) {
                        temp.next = curr.next;
                        curr = curr.next;
                    }
                } else {
                    curr = null;
                }

            } else {
                temp = curr;
                curr = curr.next;
            }
            ++i;
        }
        if (head != null && head.next != null && head.val == head.next.val) {
            head = head.next.next;
            first = false;
        }
        if (first) {
            head = head.next;
            if (head!= null && head.next!=null && head.val == head.next.val) {
                head = head.next.next;
            }
        }
        return head;
    }
}

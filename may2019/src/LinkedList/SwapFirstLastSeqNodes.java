package LinkedList;


import java.util.ArrayList;

public class SwapFirstLastSeqNodes {

    public static void swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode curr = head;
        ListNode prev = head;
        ListNode temp = head;
        while (curr != null) {
            if (curr.next == null) {
                return;
            }
            if (curr.next.next == null) {
                temp = prev.next;
                if (temp.next != null) {
                    prev.next = curr.next;
                    curr.next.next = temp;
                    curr.next = null;
                }
                curr = prev = temp;
            } else {
                curr = curr.next;
            }
        }
        return;
    }

    public static void swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }
        int n = list.size() - 1;
        head = null;
        curr = null;
        int i;
        for (i = 0; i < n; ++i) {
            if (i==0) {
                head = list.get(0);
                curr = head;
            } else {
                curr.next = list.get(i);
                curr = curr.next;
            }
            // break the loop as the half traversal is reached
            if (curr == list.get(n-i)){
                if (curr!=null) {
                    curr.next = null;
                }
                return;
            }
            curr.next = list.get(n-i);
            curr = curr.next;
        }
        if (i+1 == n) {
            if (curr!=null) {
                curr.next = list.get(i);
                curr = curr.next;
            }
        }
        if (curr!=null) {
            curr.next = null;
        }

    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode curr = head;
        ListNode temp = head;
        ListNode prev = head;
        while (curr != null) {
            if (curr.next.next == null) {
                temp = prev.next;
                prev.next = curr.next;
                curr.next.next = temp;
                curr.next = null;
                curr = prev = temp;
            } else {
                curr = curr.next;
            }
        }
    }

}

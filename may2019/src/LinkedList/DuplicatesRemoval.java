package LinkedList;

import java.util.HashSet;
import java.util.TreeSet;

public class DuplicatesRemoval {

    public static ListNode removeDups(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        ListNode temp = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static ListNode removeDupsUsingDS(ListNode head) {
        TreeSet<Integer> set = new TreeSet();
        HashSet<Integer> removeSet = new HashSet();
        for (ListNode curr = head; curr != null; curr = curr.next) {
            if(!removeSet.contains(curr.val) && !set.add(curr.val)) {
                set.remove(curr.val);
                removeSet.add(curr.val);
            }
        }
        ListNode retList = null;
        ListNode temp = null;
        for (int i: set) {
            if (retList == null) {
                retList = new ListNode(i);
                temp = retList;
            } else {
                temp.next = new ListNode(i);
                temp = temp.next;
            }
        }
        return retList;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode returnList = dummy;
        int count = 1;
        ListNode pre = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val == pre.val) {
                ++count;
            } else {
                if (count == 1) {
                    pre.next = null; // add only pre node not the chain from where pre is pointing
                    dummy.next = pre;
                    dummy = dummy.next;
                }
                count = 1;
            }
            pre = curr;
            curr = curr.next;
        }
        if (count == 1) {
            dummy.next = pre;
        }
        return returnList.next;
    }

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        ListNode head = new ListNode();
        head = node;
        ListNode temp = new ListNode(2);
        node.next = temp;
        node = temp;
        temp = new ListNode(2);
        node.next = temp;
        node = temp;
        temp = new ListNode(2);
        node.next = temp;
        node = temp;
        /*temp = new ListNode(1);
        node.next = temp;*/
        System.out.println(removeDups(head).val);

    }
}

package LinkedList;

import java.util.HashMap;
import java.util.HashSet;

public class CircularList {

    public static boolean isloopFound1(ListNode head) {
        HashSet<ListNode> hSet = new HashSet<ListNode>();
        ListNode current = head.next;
        while (current != null) {
            if (hSet.contains(current)) {
                return true;
            }
            hSet.add(current);
            current = current.next;
        }
        return false;

    }

    public static boolean isLoopFound2(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        do {
            slow = head.next;
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
        } while (slow != fast);
        return true;
    }

    public static boolean isLoopFound3(ListNode head) {
        int l = 1;
        // current should be found only after i steps from head.
        // so start current as head.next, this should not be found before i steps
        for (ListNode current = head.next; current.next != null; current = current.next) {
            ListNode temp = head;
            for (int i = 1; i <= l; ++i) {
                // check if current is found before i steps
                // for instance, if before first step itself head.next shouldn't be found
                // so check if current == temp before making temp = temp.next
                if (temp == current) {
                    return true;
                }
                temp = temp.next;
            }
            l = l + 1;
        }
        return false;
    }

    public static ListNode loopNodePos(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        HashMap<ListNode, Integer> map = new HashMap<ListNode, Integer>();
        ListNode curr = head;
        int i =0;
        while (curr!=null) {
            if (map.get(curr)!= null) {
                break;
            }
            map.put(curr, i);
            ++i;
            curr = curr.next;
        }
        System.out.println("tail connects to node index "+map.get(curr));
        return head;
    }
}

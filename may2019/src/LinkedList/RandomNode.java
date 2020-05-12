package LinkedList;

import java.util.Random;

public class RandomNode {
    public static ListNode random1(ListNode head) {
        int length = 0;
        ListNode curr;
        for (curr = head.next; curr != null; curr = curr.next) {
            ++length;
        }

        Random r = new Random();
        for (int i = 0; i < r.nextInt(length) + 1; ++i) {
            curr = curr.next;
        }
        return curr;
    }

    public static ListNode random2(ListNode head) {
        ListNode random = head.next;
        Random r = new Random();
        ListNode curr = null;
        for (curr = head.next; curr != null; curr = curr.next) {
            if (r.nextInt(2) == 1) {
                random = random.next;
            }
        }
        return random;
    }

    public static ListNode random3(ListNode head) {
        ListNode random = head.next;
        Random r = new Random();
        int n = 2;
        for (int i = 0; i < 10; ++i) {
            if (r.nextInt(n) == 1) {
                random = random.next;
            }
            ++n;
        }
        return random;
    }
}

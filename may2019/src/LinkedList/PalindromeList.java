package LinkedList;

public class PalindromeList {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode second = null;
        while(slow!=null) {
            fast = fast.next.next;
            if (fast == null) { // even length
                second = slow.next;
                slow.next = null;
                break;
            }
            if (fast.next == null) { // odd length
                second = slow.next.next;
                slow.next = null;
                break;
            }
            slow = slow.next;
        }
        slow = head;
        second = reverseList(second);

        while (second!=null) {
            if (second.val != slow.val) {
                return false;
            }
            second = second.next;
            slow = slow.next;
        }
        return true;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode temp = null;
        ListNode prev = null;
        while(curr!=null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head = prev;
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode head = new ListNode();
        head = node;
        ListNode temp = new ListNode(2);
        node.next = temp;
        node = temp;
        temp = new ListNode(3);
        node.next = temp;
        node = temp;
        temp = new ListNode(1);
        node.next = temp;
        node = temp;
        /*temp = new ListNode(1);
        node.next = temp;*/
        //reverseList(head);
        System.out.println(isPalindrome(head));
    }
}

package LinkedList;

public class ReverseList {

    static ListNode head;

    // assuming head is first node
    public static ListNode reverse(ListNode node) {
        ListNode prev, current, temp;
        prev = current = temp = null;
        current = node;
        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        node = prev;
        return node;
    }

    // we are assuming head is first node, as it is followed by leetcode
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        System.out.println(m+", "+n);
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        if (m==n) {
            return head;
        }
        ListNode curr = head;
        ListNode temp = null;
        ListNode prev = null;
        ListNode prevFinal = head;
        int count = 1;
        while (curr != null) {
            if (count < m) {
                prevFinal = curr;
                curr = curr.next;
                ++count;
                continue;
            }
            if (count > n) {
                curr = curr.next;
                continue;
            }
            ++count;
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        if (prevFinal.next == null) {
            if (temp!=null) {
                prevFinal.next = temp;
            }
            head = prev;
        } else {
            prevFinal.next.next = temp;
            prevFinal.next = prev;
        }
        return head;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        /*keep traversing till k nodes
          take curr into temp and make curr.next = null. This sublist is to be reversed.
          Now after reverse make reversed list .next to temp.next
          repeat this for next k group*/

        ListNode curr = head;
        ListNode currPrev = null;
        ListNode headFinal = head;
        int count = 1;
        ListNode temp = null;
        boolean firstGroup = true;
        while (curr != null) {
            if (count == k) {
                temp = curr.next;
                curr.next = null;
                head = reverse(head);
                if (firstGroup) {
                    headFinal = head;
                    firstGroup = false;
                }
                if (currPrev != null) {
                    currPrev.next = head;
                }
                count = 1;
                while (count != k) {
                    curr = curr.next;
                    ++count;
                }
                curr.next = temp;
                currPrev = curr;
                curr = head = temp;
                count = 1;
                continue;
            }
            ++count;
            curr = curr.next;
        }
        return headFinal;
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
        temp = new ListNode(4);
        node.next = temp;
        node = temp;
        /*temp = new ListNode(5);
        node.next = temp;
        node = temp;
*/

        /*temp = new ListNode(1);
        node.next = temp;*/
        //reverseList(head);
        reverseKGroup(head,2);
    }
}

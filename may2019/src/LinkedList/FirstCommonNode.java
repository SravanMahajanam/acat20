package LinkedList;

import java.util.HashSet;

public class FirstCommonNode {

    // adhoc: traverse first list by comparing if it is equal to any node of the second list
    public static ListNode firstCommon1(ListNode head1, ListNode head2) {
        for (ListNode first = head1.next; first != null; first = first.next) {
            for (ListNode second = head2.next; second != null; second = second.next) {
                if (first == second) {
                    return first;
                }
            }
        }
        return null;
    }

    // add nodes of first list to a set and check if any of the second list node is matching with the entires in the set
    public static ListNode firstCommon2(ListNode head1, ListNode head2) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        ListNode curr = head1.next;
        while (curr != null) {
            set.add(curr);
            curr = curr.next;
        }

        curr = head2.next;
        while (curr != null) {
            if (set.contains(curr)) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    private static int getLength(ListNode head) {
        return 0;
    }

    // find the lenghts of lists and then move the larger list till the offset point ad start comparing the nodes there on
    public static ListNode firstCommon31(ListNode head1, ListNode head2) {
        int length1 = getLength(head1);
        int length2 = getLength(head2);

        while (length1 > length2) {
            head1 = head1.next;
            ++length1;
        }

        while (length2 > length1) {
            head2 = head2.next;
            ++length2;
        }

        for (ListNode curr = head1.next; curr != null; curr = curr.next) {
            if (curr == head2.next) {
                return head1;
            }
            head2 = head2.next;
        }
        return null;
    }

    // Do not explicitly calculate lengths,
    // keep traversing the lists, when a node is null point it to the head of the other list
    // this way we are making circular path ( fast slow pointer aproach is used now on)
    public static ListNode firstCommon32(ListNode head1, ListNode head2) {
        ListNode first = head1;
        ListNode second = head2;

        while (first != second) {
            first = first.next;
            if (first == null) {
                first = head2;
            }
            second = second.next;
            if (second == null) {
                second = head1;
            }
        }
        return first;
    }

    // negation trick can also be used - mark the visited nodes as -ve and
    // if the curr node is -ve then it means its already visited so it is the one we are looking for.
    // But java doesn't allow address manipulation, so we can't implement it now.
}

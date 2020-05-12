package LinkedList;

import java.util.Iterator;
import java.util.TreeSet;

public class MergeLists {

    /*failing case:
        [-4,-2,0,1,4]
        [-9,-8,-6,-6,-5,-1,1,4,9]

        Output: [-9,-8,-6,-6,-5,-4,-2,-1,0,1,4,4,9]

        Expected: [-9,-8,-6,-6,-5,-4,-2,-1,0,1,1,4,4,9]*/

    public static ListNode mergeTwoLists_old(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) {
            return l2;
        }
        if (l2 == null && l1 != null) {
            return l1;
        }
        ListNode alpha = l1;
        ListNode beta = l2;
        ListNode temp = null;
        boolean ret = true;
        while (alpha != null && beta != null) {
            while (alpha.next != null && alpha.next.val <= beta.val) {
                alpha = alpha.next;
            }
            while (beta.next != null && beta.next.val < alpha.val) {
                beta = beta.next;
                ret = false;
            }
            if (alpha != null && beta != null && alpha.val <= beta.val) {
                temp = beta;
                beta = alpha.next;
                alpha.next = temp;
                alpha = temp;
            }
            if (beta != null && alpha != null && beta.val <= alpha.val) {
                temp = alpha;
                alpha = beta.next;
                beta.next = temp;
                beta = temp;
                ret = false;
            }
        }
        if (ret) {
            return l1;
        }
        return l2;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) {
            return l2;
        }
        if (l2 == null && l1 != null) {
            return l1;
        }

        ListNode alpha = l1; // 1 2 4
        ListNode beta = l2; // 1 3 4
        ListNode returnList = new ListNode();
        ListNode temp = returnList;
        // iterate till all nodes of both lists are done
        while (alpha != null && beta != null) {
            if (alpha.val < beta.val) {
                temp.next = new ListNode(alpha.val);
                temp = temp.next;
                alpha = alpha.next;
            } else {
                temp.next = new ListNode(beta.val);
                temp = temp.next;
                beta = beta.next;
            }
        }
        while (alpha != null) {
            temp.next = new ListNode(alpha.val);
            temp = temp.next;
            alpha = alpha.next;
        }
        while (beta != null) {
            temp.next = new ListNode(beta.val);
            temp = temp.next;
            beta = beta.next;
        }
        return returnList.next;
    }

    public ListNode mergeTwoLists_DS(ListNode l1, ListNode l2) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        while (l1 != null) {
            treeSet.add(l1.val);
        }
        while (l2 != null) {
            treeSet.add(l2.val);
        }
        Iterator treeSetIterator = treeSet.iterator();
        ListNode returnNode = new ListNode();
        ListNode temp = returnNode;
        while (treeSetIterator.hasNext()) {
            temp.next = new ListNode((Integer) treeSetIterator.next());
            temp = temp.next;
        }
        return returnNode.next;
    }
}

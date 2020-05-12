package LinkedList;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AddLists {
    public static ListNode addTwoNumbers_old(ListNode l1, ListNode l2) {
        MyInteger l1Size = new MyInteger(0);
        MyInteger l2Size = new MyInteger(0);
//        l1 = reverseList(l1, l1Size);
//        l2 = reverseList(l2, l2Size);
        int size = l1Size.get() > l2Size.get() ? l1Size.get(): l2Size.get();
        int sum = 0;
        int carry = 0;
        ListNode sumList = null;
        ListNode sumHead = null;
        while (size > 0) {
            sum = (l1 == null? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode newNode = new ListNode(sum);
            if (sumList == null) {
                sumList = newNode;
                sumHead = sumList;
            } else {
                sumList.next = newNode;
                sumList = sumList.next;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            --size;
        }
        if (carry > 0 ) {
            sumList.next = new ListNode(carry);
            sumList = sumList.next;
        }
        return sumHead;
    }

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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1.val == 0 && l2.val == 0) {
            return new ListNode();
        }
        l1 = reverse(l1);
        l2 = reverse(l2);
        int l1Num = 0;
        int l2Num = 0;

        while (l1 != null) {
            l1Num = (l1Num * 10) + l1.val;
            l1 = l1.next;
        }
        while (l2 != null) {
            l2Num = (l2Num * 10) + l2.val;
            l2 = l2.next;
        }

        int resNum = l1Num + l2Num;
        ListNode res = new ListNode();
        ListNode temp = res;
        while ((resNum / 10 != 0 ) || (resNum % 10 != 0)) {
            int num = resNum % 10;
            temp.next = new ListNode(num);
            temp = temp.next;
            resNum = resNum / 10;
            if (resNum == 0) {
                break;
            }
        }
        return res.next;
    }

    private static int findLength(ListNode listNode) {
        int length = 0;
        while (listNode != null) {
            length++;
            listNode = listNode.next;
        }
        return length;
    }
    // passed all test cases
    public static ListNode addTwoNumbers_directlyFromList(ListNode l1, ListNode l2) {
        ListNode retNode = null;
        ListNode temp = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val = carry;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            carry = val / 10;
            ListNode newNode = new ListNode(val % 10);
            if(retNode == null){
                retNode = newNode;
                temp = retNode;
            } else {
                temp.next = newNode;
                temp = temp.next;
            }
        }
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return retNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        addTwoNumbers_directlyFromList(l1,l2);
    }

    public static ListNode addTwoNumbersFromNormalLists(ListNode l1, ListNode l2) {
        ArrayList<Integer> list1 = new ArrayList();
        while (l1 != null) {
            list1.add(l1.val);
            l1 = l1.next;
        }
        ArrayList<Integer> list2 = new ArrayList();
        while (l2 != null) {
            list2.add(l2.val);
            l2 = l2.next;
        }
        int size1 = list1.size() - 1;
        int size2 = list2.size() - 1;
        int carry = 0;
        ListNode retNode = null;
        ListNode temp = null;
        while (size1 >= 0 || size2 >= 0) {
            int val1 = 0;
            int val2 = 0;
            int val = carry;
            if (size1 >= 0) {
                val1 = list1.get(size1);
                size1--;
            }
            if (size2 >= 0) {
                val2 = list2.get(size2);
                size2--;
            }
            val = val + val1 + val2;
            carry = val / 10;
            ListNode newNode = new ListNode(val % 10);
            if (temp == null) {
                temp = newNode;
            } else {
                newNode.next = temp;
                temp = newNode;
            }
        }
        retNode = temp;
        if (carry > 0) {
            retNode = new ListNode(carry);
            retNode.next = temp;
        }
        return retNode;
    }

}

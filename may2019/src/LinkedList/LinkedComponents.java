package LinkedList;

import java.util.HashMap;

public class LinkedComponents {
    public static int countLinkedComponents(ListNode head, int[] G) {
        if (G.length == 0 || head == null) {
            return 0;
        }
        HashMap<Integer, Integer> llComponentsMap = new HashMap<Integer, Integer>();
        for (ListNode curr = head; curr != null; curr = curr.next) {
            if (curr.next == null) {
                llComponentsMap.put(curr.val, null);
                break;
            }
            llComponentsMap.put(curr.val, curr.next.val);
        }
        System.out.println(llComponentsMap);

        int count = 0;
        int i;
        for (i = 0; i < G.length - 1; ++i) {
            if (llComponentsMap.get(G[i]) == null) {
                ++count;
                continue;
            }
            if (llComponentsMap.get(G[i]) == G[i + 1]) {
                ++count;
            }
        }
        if (llComponentsMap.get(G[i]) == null) {
            ++count;
        }
        return count;
    }
}

package LinkedList;

public class DLinkedListNode {

    DLinkedListNode prev, next;
    String key;
    Integer value;

    public DLinkedListNode() {
        prev = next = this;
    }

    public DLinkedListNode(String key, Integer value) {
        this.key = key;
        this.value = value;
    }
}

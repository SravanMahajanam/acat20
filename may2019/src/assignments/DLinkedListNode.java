package assignments;

public class DLinkedListNode {
    String key;
    Integer value;
    DLinkedListNode prev;
    DLinkedListNode next;

    public DLinkedListNode() {
        prev = next = this;
    }

    public DLinkedListNode(String key, Integer value) {
        this.key = key;
        this.value = value;
    }
}

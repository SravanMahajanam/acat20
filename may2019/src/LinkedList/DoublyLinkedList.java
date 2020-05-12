package LinkedList;

public class DoublyLinkedList {

    private DoublyLinkedList list;
    int size;
    private DLinkedListNode head;

    public DoublyLinkedList() {
        head = new DLinkedListNode();
        size = 0;
    }

    public void removeAddLast(DLinkedListNode temp) {
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;

        temp.prev = head.prev;
        temp.next = head;
        head.prev.next = temp;
        head.prev = temp;
    }

    public DLinkedListNode removeFirst() {
        DLinkedListNode temp = head.next;
        temp.next.prev = head;
        head.next = temp.next;
        --size;
        return temp;
    }

    public DLinkedListNode addLast(String key, Integer value) {
        DLinkedListNode temp = new DLinkedListNode(key, value);
        temp.next = head;
        temp.prev = head.prev;

        head.prev.next = temp;
        head.prev = temp;
        ++size;
        return temp;
    }

    public int getSize() {
        return size;
    }

    public void display() {
        for (DLinkedListNode current = head.next; current!=head; current=current.next) {
            System.out.print("(" + current.key + ", " + current.value + ")");
        }
        System.out.println();
    }

}

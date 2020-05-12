package assignments;

public class DoubleLinkedList {
    DLinkedListNode head;
    int size;

    public DoubleLinkedList() {
        head = new DLinkedListNode();
    }

    public void removeAddLast(DLinkedListNode temp) {
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.prev = head.prev;
        temp.next = head;
        head.prev.next = temp;
        head.prev = temp;
    }

    public DLinkedListNode removeFirst() {
        DLinkedListNode temp = head.next;
        head.next = head.next.next;
        temp.next.prev = head;
        --size;
        return temp;
    }

    public void addLast(DLinkedListNode temp) {
        temp.next = head;
        temp.prev = head.prev;

        head.prev.next = temp;
        head.prev = temp;


        ++size;
    }

    public int getSize() {
        return this.size;
    }

    public void display() {
        for (DLinkedListNode curr = head.next; curr.next!=head; curr=curr.next) {
            System.out.print("(" + curr.key +", "+ curr.value + ")");
        }
        System.out.println();
    }
}

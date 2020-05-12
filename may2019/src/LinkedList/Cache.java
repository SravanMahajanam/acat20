package LinkedList;

import java.util.HashMap;
import java.util.Random;

public class Cache {

    private DoublyLinkedList list;
    private HashMap<String, DLinkedListNode> index;
    private int capacity;

    public Cache(int capacity) {
        this.capacity = capacity;
        list = new DoublyLinkedList();
        index = new HashMap<String, DLinkedListNode>();
    }

    public void put(String key, Integer value) {
        // if key is already present update the value
        DLinkedListNode temp = index.get(key);
        if (temp!=null){
            temp.value = value;
            list.removeAddLast(temp);
            return;
        }
        //if size is full, remove first node
        if (list.getSize() == capacity) {
            temp = list.removeFirst();
            index.remove(temp.key);
        }
        // add new node to last.
        temp = list.addLast(key, value);
        index.put(key, temp);
    }

    public Integer get(String key) {
        DLinkedListNode temp = index.get(key);
        if(temp == null) {
            return null;
        }
        list.removeAddLast(temp);
        return temp.value;

    }

    public void display() {
        list.display();
    }

    public static void main(String[] args) {
        Cache cache = new Cache(3);
        Random r = new Random(100);
        for (int i =0; i<10;++i) {
            String key = "random"+i;
            Integer value = r.nextInt(100);
            cache.put(key, value);
            cache.display();
            if (i == 5) {
                cache.get("random2");
                cache.display();
            }
        }
    }
}

package assignments;

import java.util.HashMap;
import java.util.Random;

public class Cache {
    private HashMap<String, DLinkedListNode> index;
    private DoubleLinkedList list;
    private int capacity;

    public Cache(int capacity) {
        this.capacity = capacity;
        this.index = new HashMap<String, DLinkedListNode>();
        this.list = new DoubleLinkedList();
    }

    public void put(String key, Integer value) {
        DLinkedListNode temp = index.get(key);
        if (temp != null) {
            list.removeAddLast(temp);
            return;
        }
        // if cache is not full
        if (list.getSize() == this.capacity) {
            temp = list.removeFirst();
            index.remove(temp.key);
        }

        temp = new DLinkedListNode(key, value);
        list.addLast(temp);
        index.put(key, temp);
    }

    public Integer get(String key) {
        DLinkedListNode temp = index.get(key);
        if (temp == null) {
            return null;
        }
        list.removeAddLast(temp);
        return temp.value;
    }

    void display() {
        list.display();
    }

    public static void main(String[] args) {
        Cache cache = new Cache(3);
        Random r = new Random(100);
        for (int i = 0; i < 10; ++i) {
            String key = "random"+i;
            Integer value = r.nextInt(100);
            cache.put(key,value);
            if (i == 5)
                cache.get("random2");
            cache.display();
        }
    }
}

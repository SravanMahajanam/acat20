package LinkedList;

public class MyInteger {
    int data;
    boolean maxFound;

    public boolean isMaxFound() {
        return maxFound;
    }

    public void setMaxFound(boolean maxFound) {
        this.maxFound = maxFound;
    }

    public MyInteger() {
        this.data = 1;
    }

    public MyInteger(int data) {
        this.data = data;
    }

    public int get() {
        return data;
    }

    public void set(int data) {
        this.data = data;
    }

    public void incr() {
        ++this.data;
    }
}

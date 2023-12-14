package MainTaxiApp.Classes;

interface List<T> {

    boolean isEmpty();

    void moveToFirst();

    void moveToNext();

    boolean isLast();

    T getData();

    void updateData(T e);

    void insert(T e);

    void remove();

    int size();

    void printAllData();
}

public class LinkedList<T> implements List<T> {
    private Node head;
    private Node current;
    private int size;

    public void remove(T entryToRemove) {
        if (head == null) {
            return;
        }

        if (head.data.equals(entryToRemove)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.data.equals(entryToRemove)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    private class Node {
        public T data;
        public Node next;

        public Node(T val) {
            data = val;
            next = null;
        }
    }

    public LinkedList() {
        head = null;
        current = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void moveToFirst() {
        current = head;
    }

    @Override
    public void moveToNext() {
        if (!isEmpty() && current.next != null) {
            current = current.next;
        }
    }

    @Override
    public boolean isLast() {
        return !isEmpty() && current.next == null;
    }

    @Override
    public T getData() {
        if (isEmpty()) {
            System.out.println("List is empty, null will be returned");
            return null;
        }
        return current.data;
    }

    @Override
    public void updateData(T e) {
        if (!isEmpty()) {
            current.data = e;
        } else {
            System.out.println("List is empty, data not updated");
        }
    }

    @Override
    public void insert(T e) {
        if (isEmpty()) {
            head = current = new Node(e);
        } else {
            Node tmp = current.next;
            current.next = new Node(e);
            current = current.next;
            current.next = tmp;
        }
        size++;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            System.out.println("List is empty, nothing to remove.");
            return;
        }

        if (current == head) {
            // If removing the first node, update head
            head = head.next;
            current = head;
        } else {
            // Otherwise, update the next reference of the previous node
            Node prev = findPreviousNode();
            if (prev != null) {
                prev.next = current.next;
                current = prev; // Move the cursor back to the previous node
            }
        }

        size--;
    }
    private Node findPreviousNode() {
        Node temp = head;
        while (temp != null && temp.next != current) {
            temp = temp.next;
        }
        return temp;
    }
   public void printAllData(){
        moveToFirst();
       int size= size();
       for(int i =0; i<size; i++){
           System.out.println(getData().toString()+" ");
           moveToNext();
       }
    }

    public int size() {
        return size;
    }
}

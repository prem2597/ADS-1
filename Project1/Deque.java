import java.util.Iterator;
// import java.util.ListIterator;
// import java.lang;
import java.util.NoSuchElementException;
// import java.lang.*;
/**
 * Implements the Deque.
 * @author PREM
 * @param <Item> Generic type.
 * reference Bob Sedgewick, Stack overFlow, Geek for Geeks, coursera.
 */
public class Deque<Item> implements Iterable<Item> {
    private class ListIterator<Item> implements Iterator<Item> {
        Node cursor;
        // private int x;
        ListIterator() {
            cursor = front;
        }
        public boolean hasNext() {
            return cursor.next == null;
        }
        public boolean hasPrevious() {
            return cursor.prev != front.prev;
        }
        public Item previous() {
            if (hasPrevious()) {
                return (Item) cursor.value;
            } else {
                throw new java.util.NoSuchElementException();
            }
        }
        public Item next() {
            if (hasNext()) {
                cursor = cursor.next;
                return (Item) cursor.value; 
            } else {
                throw new NoSuchElementException();
            }
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    private class Node<Item> {
        /**
         * prev to represent the previous value in the linked list.
         */
        private Node<Item> prev;
        /**
         * next represents the next value in the linked list.
         */
        private Node<Item> next;
        private Item value;
        Node() {
            // this.value = value;
        }
        // public Node<Item> getPrev() {
        //     return prev;
        // }
        // public void setPrev(Node<Item> prev) {
        //     this.prev = prev;
        // }
        // public Node<Item> getNext() {
        //     return next;
        // }
        // public void setNext(Node<Item> next) {
        //     this.next = next;
        // }
        // public Item getValue() {
        //     return value;
        // }
        // public void setValue(Item value) {
        //     this.value = value;
        // }
    }
    private Node<Item> front;
    private Node<Item> rear;
    private int size;
    public Deque() {
        front = null;
        rear = null;
        size = 0;
    }
    public boolean isEmpty() {
        if (front == null && rear == null) {
            return true;
        } else {
            return false;
        }
        // return front = null;
    }
    public int size() {
        if (front == null) {
            return 0;
        }
        Node t = front;
        int count = 0;
        while (t != null) {
            count = count + 1;
            t = t.next;
        }
        return count;
    }
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        // System.out.println("Adding element at the front : "+item);
        // Node<Item> nd = new Node<>();
        // nd.setValue(item);
        // nd.setNext(front);
        // if (front != null) {
        //     front.setPrev(nd);
        // }
        // if (front == null) {
        //     rear = nd;
        // }
        // front = nd;
        if (size == 0) {
            front = new Node();
            front.value = item;
            rear = front;
        } else {
            Node temp = front;
            front = new Node();
            front.value = item;
            front.next = temp;
            temp.prev = front;
        }
        size++;
    }
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        // System.out.println("Adding the element at the rear : "+ item);
        Node<Item> nd = new Node<Item>();
        // nd.setValue(item);
        // nd.setPrev(rear);
        // if (rear != null) {
        //     rear.setNext(nd);
        // }
        // if (rear == null) {
        //     front = nd;
        // }
        // rear = nd;
        nd.value = item;
        if (rear != null) {
            nd.prev = rear;
            rear.next = nd;
        }
        rear = nd;
        if (front == null) {
            front = rear;
        }
        size++;
    }
    public Item removeFirst() {
        if (front == null) {
            // System.out.println("Underflow state");
            throw new NoSuchElementException();
        }
        // Node<Item> tempFront = front.getNext();
        // if (tempFront != null) {
        //     tempFront.setPrev(null);
        // }
        // if (tempFront == null) {
        //     rear = null;
        // }
        // // System.out.println("Remove element from the front : "+front.getValue());
        // front = tempFront;
        // return front.value;
        Item item = front.value;
        if (size == 1) {
            rear = null;
            front = null;
        } else {
            front.next.prev = null;
            front = front.next;
        }
        size--;
        return item;

    }
    public Item removeLast() {
        if (rear == null) {
            // System.out.println("UnderFlow State");
            throw new NoSuchElementException();
        }
        // Node<Item> tempRear = rear.getPrev();
        // if (tempRear != null) {
        //     tempRear.setNext(null);
        // }
        // if (tempRear == null) {
        //     front = null;
        // }
        // // System.out.println("Removed element from the rear :"+rear.getValue());
        // rear = tempRear;
        // return rear.value;
        Item item = rear.value;
        if (rear.prev == null) {
            rear = null;
            front = null;
        } else {
            rear.prev.next = null;
            rear = rear.prev;
        }
        size--;
        return item;
    }
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    public static void main(String[] args) {
        Deque<Integer> q = new Deque<Integer>();
        for (int i = 0; i < 4; i++) {
            q.addFirst(i);
            q.removeFirst();
        }
        // q.removeFirst();
        for (int j = 10; j < 14; j++) {
            q.addLast(j);
            // q.size();
            q.removeLast();
            // q.size();
            // q.isEmpty();
        }

    }
}


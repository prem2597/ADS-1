/**
 * @author PREM
 * @param <Item> generic type.
 */
public class CircularLinkedList<Item> {
    /**
     * default constructor.
     */
    public CircularLinkedList() {
    }
    /**
     * Node class.
     */
    public class Node {
        /**
         * value is the data stored in the node.
         */
        private Item value;
        /**
         * link is the next Node.
         */
        private Node link;
    }
    // public static class Queue {
    //     Node rear;
    //     Queue() {
    //         rear = null;
    //     }
    // }
    // private class Itr implements Iterator {
    //     private int size = 0;
    //     private int nextNode = 0;
    //     private Node last = null;
    //     private Node next;

    //     public boolean hasNext() {
    //         return nextNode < size;
    //     }

    //     public int next() {
    //         last = next;
    //         next = next.getNext();
    //         nextNode++;
    //         return last.value;
    //     }
    //     public void remove() {

    //     }
    // }
    /**
     * rear is the tail of the Circular Linked list.
     */
    private Node rear;
    /**
     * size of the linked list.
     */
    private int size = 0;
    /**
     * isempty or not.
     * @return true or false.
     */
    public boolean isEmpty() {
        return size == 0;

    }
    /**
     * size of the circular linked list.
     * @return size.
     */
    public int size() {
        return size;
    }
    /**
     * to insert the elements.
     * @param item value.
     */
    public void enqueue(final Item item) {
        Node nd = rear;
        rear = new Node();
        rear.value = item;
        // if (q.rear == null) {
        //     q.rear= nd;
        // } else {
        //     q.rear.link = nd;
        // }
        // q.rear = nd;
        // q.rear.link = q.front;
        if (isEmpty()) {
            rear.link = rear;
        } else {
            rear.link = nd.link;
            nd.link = rear;
        }
        size++;
    }
    /**
     * to remove the elements.
     * @return item
     */
    public Item dequeue() {
        // if (q.front == null) {
        //     System.out.println("Queue is empty");
        //     throw new NullPointerException();
        // }
        // int value;
        // if (q.front == q.rear) {
        //     value = q.front.value;
        //     q.front = null;
        //     q.rear = null;
        // } else {
        //     Node nd = q.front;
        //     value = nd.value;
        //     q.front = q.front.link;
        //     q.rear.link = q.front;
        // }
        Item item = rear.link.value;
        rear.link = rear.link.link;

        if (rear.link == rear) {
            rear = null;
        }
        size--;
        return item;
    }
    // public void display() {
    //     Node temp = q.rear;
    //     System.out.println("Elements in the circular queue are : ");
    //     while (temp.link != q.rear) {
    //         System.out.println(temp.value);
    //         temp = temp.link;
    //     }
    //     // for (String s : q) {
    //     //     System.out.println(s+" ");
    //     // }
    //     System.out.println(temp.value);
    // }
    /**
     * Main method.
     * @param args arguments
     */
    public static void main(final String[] args) {
        // Queue q = new Queue();
        CircularLinkedList<Integer> q = new CircularLinkedList<Integer>();
        q.enqueue(25);
        q.enqueue(5);
        q.enqueue(42);
        q.enqueue(97);
        // q.display();
        // System.out.println(q.value);

        System.out.println("dequeue : " + q.dequeue());
        System.out.println("dequeue : " + q.dequeue());
        System.out.println("dequeue : " + q.dequeue());
        // q.display();
    }
}

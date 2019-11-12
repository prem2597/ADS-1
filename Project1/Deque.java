import java.util.Iterator;
import java.lang.*;
import java.util.NoSuchElementException;
/**
 * Implements the Deque.
 * @author Prem
 * @param <Item> Generic type.
 */
public class Deque<Item> implements Iterable<Item> {
    /**
     * Size of the array.
     */
    int size;
    /**
     * array initialization.
     */
    int arr;
    /**
     * front of the queue.
     */
    int front;
    /**
     * rear of the queue.
     */
    int rear;
    /**
     * construts an empty deque.
     */
    public Deque() {
        /**
         * taking array of size;
         */
        int arr[] = new int[size];
        front = -1;
        rear = -1;
    }
    /**
     * checks whether the queue is empty or not.
     * @return boolean true or false.
     */
    public boolean isEmpty() {
        if (front == -1) {
            return true;
        } else {
            return false;
        }
    }
    public in size() {
        
    }
    public void addFirst(Item item) {
        
    }

}


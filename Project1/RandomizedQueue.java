import java.util.Iterator;
// import edu.princeton.cs.algs4.*;
import java.util.NoSuchElementException;
/**
 * Implements a randomized queue that is except the.
 * removed is chosen uniformly at random.
 * @param <Item> generic type
 * @author PREM
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private class RandomIterator implements Iterator<Item> {
        private int i = size;
        private Item[] randomItems;
        public RandomIterator() {
            randomItems = (Item[]) new Object[size];
            System.arraycopy(items, 0, randomItems, 0, size);
            StdRandom.shuffle(randomItems);
        }
        public boolean hasNext() {
            return i > 0;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return randomItems[--i];
        }
    }
    private Item[] items;
    private int size;
    public RandomizedQueue() {
        items = (Item[]) new Object[1];
        size = 0;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void resize(int capacity) {
        Item[] x = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            x[i] = items[i];
        }
        items = x;
    }
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (size == items.length) {
            resize(2 * items.length);
        }
        items[size++] = item;
    }
    public Item dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int position = StdRandom.uniform(size);
        Item item = items[position];
        items[position] = items[--size];
        items[size] = null;
        if (size > 0 && size == items.length/4) {
            resize(items.length/2);
        }
        return item;
    }
    public Item sample() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int position = StdRandom.uniform(size);
        return items[position];
    }
    public Iterator<Item> iterator() {
        return new RandomIterator();
    }
    public static void main(String[] args) {
        RandomizedQueue<Integer> r = new RandomizedQueue<Integer>();
        r.enqueue(4);
        r.enqueue(5);
        r.dequeue();
        r.sample();
        // System.out.println(r.iterator());
    }
}

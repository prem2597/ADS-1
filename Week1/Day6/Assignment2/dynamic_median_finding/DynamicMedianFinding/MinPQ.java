import java.util.Comparator;
import java.util.Iterator;

public class MinPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int n;
    private Comparator<Key> comparator;

    public MinPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty() {
        return n = 0;
    }

    public int size() {
        return n;
    }

    public void insert(Key key) {
        pq[++N] = x;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N + 1] = null;
        return max;
    }

    public Key min() {
        return pq[1];
    }

    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && greater(j, j+1)) {
                j++;
            }
            if(!greater(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private boolean greater (int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        } else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}
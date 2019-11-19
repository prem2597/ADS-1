import java.util.*;
/**
 * BinarySearch Symbol Table.
 * @param <Key> key type
 * @param <Value> value type.
 * @author PREM
 * reference Bob Sedgweick.
 */
public class BinarySearchST<Key extends Comparable, Value> {
    private Key[] keys;
    private Value[] vals;
    private int n = 0;
    int range = 10;
    public BinarySearchST() {
        keys = (Key[]) new Comparable[range];
        vals = (Value[]) new Object[range];
    }
    private void resize(int range) {
        Key[] x = (Key[]) new Comparable[range];
        Value[] y = (Value[]) new Object[range];
        for (int i = 0; i < n; i++) {
            x[i] = keys[i];
            y[i] = vals[i];
        }
        vals = y;
        keys = x;
    }
    public int size() {
        return n;
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public boolean contains(Key key) {
        return get(key) != null;
    }
    public Value get(Key key) {
        if(isEmpty()) {
            return null;
        }
        int i = rank(key);
        if(i < n && keys[i].compareTo(key) == 0) {
            return vals[i];
        }
        return null;
    }
    public int rank(Key key) {
        int lo = 0;
        int hi = n-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
    public void put(Key key, Value val) {
        if (n == keys.length - 1) {
            resize(2 * keys.length);
        }
        if (n == 0) {
            keys[n] = key;
            vals[n++] = val;
            return;
        }
        int m = n;
        if (n != 0 && keys[m - 1].compareTo(key) < 0) {
            keys[n] = key;
            vals[n++] = val;
            return;
        }
        int i = rank(key);
        if(i < n && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        if (n == keys.length) {
            resize(2 * keys.length);
        }
        for (int j = n; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }
    public int size(Key lo, Key hi) {
        if (lo.compareTo(hi) > 0) {
            return 0;
        }
        if (contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        } else {
            return rank(hi) - rank(lo);
        }
    }
}

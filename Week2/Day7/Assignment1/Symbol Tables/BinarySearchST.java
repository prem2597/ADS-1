import java.util.NoSuchElementException;
import java.util.Arrays;
import java.util.List;
// import java.util.Queue;
/**
 * implments Binary Search API
 * @param <Key> type
 * @param <Value> type
 * @author PREM
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
//    private static final int capacity = 2;
   private Key[] keys;
   private Value[] vals;
   private int n = 0;
   private int size;
   int capacity = 5;
   
   public BinarySearchST() {
       keys = (Key[]) new Comparable[capacity];
       vals = (Value[]) new Object[capacity];
       size = 0;
   }

   private void resize(int capacity) {
       Key[] x = (Key[]) new Comparable[capacity];
       Value[] y = (Value[]) new Object[capacity];
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
       if (key == null) {
           throw new IllegalArgumentException("argument to contains() is null");
        }
        return get(key) != null;
   }

   public Value get(Key key) {
       if (key == null) {
           throw new IllegalArgumentException("argument to get() is null");
       }
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
       if (key == null) {
           throw new IllegalArgumentException("argument to rank() is null");
       }
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
       if (key == null) {
           throw new IllegalArgumentException("first argument to put() is null");
       }
       if(val == null) {
           delete(key);
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

   public void delete(Key key) {
       if (key == null) {
           throw new IllegalArgumentException("argument to delete() is null");
       }
       if (isEmpty()) {
           return;
       }
       int i = rank(key);
       if (i == n || keys[i].compareTo(key) != 0) {
           return;
       }
       for (int j = i; j < n - 1; j++) {
           keys[j] = keys[j + 1];
           vals[j] = vals[j+1];
       }
       n--;
       keys[n] = null;
       vals[n] = null;
       if (n > 0 && n == keys.length/4) {
           resize(keys.length/2);
       }
   }

   public void deleteMin() {
       if (isEmpty()) {
           throw new NoSuchElementException("Symbol table underflow error");
       }
       delete(min());
   }

   public void deletemax() {
       if (isEmpty()) {
           throw new NoSuchElementException("Symbol table underflow error");
       }
       delete(max());
   }

   public Key min() {
       return keys[0];
   }

   public Key max() {
       return keys[n - 1];
   }

   public Key select(int k) {
       return keys[k];
   }

   public Key floor(Key key) {
       int i = rank(key);
       if(i < n && key.compareTo(keys[i]) == 0) {
           return keys[i];
       }
       if (i == 0) {
           return null;
       } else {
           return keys[i - 1];
       }
   }

   public Key ceiling(Key key) {
       int i = rank(key);
       if (i == n) {
           return null;
       } else {
           return keys[i];
       }
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

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<Key>(); 
        if (lo.compareTo(hi) > 0) {
            return queue;
        }
        for (int i = rank(lo); i < rank(hi); i++) {
            queue.enqueue(keys[i]);
        }   
        if (contains(hi)) {
            queue.enqueue(keys[rank(hi)]);
        }
        return queue; 
    }

    private boolean check() {
        return isSorted() && rankCheck();
    }

    private boolean isSorted() {
        for (int i = 1; i < size(); i++) {
            if (keys[i].compareTo(keys[i-1]) < 0) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean rankCheck() {
        for (int i = 0; i < size(); i++) {
            if (i != rank(select(i))) {
                return false;
            }
        }
        for (int i = 0; i < size(); i++) {
            if (keys[i].compareTo(select(rank(keys[i]))) != 0) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    // public String keys() {
    //     String data = "";
    //     for (int i = 0; i < n; i++) {
    //         data += keys[i] + " ";
    //     }
    //     return data;
    // }
}

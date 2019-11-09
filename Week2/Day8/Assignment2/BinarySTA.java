import java.util.Arrays;
/**
 * @author PREM.
 * @param <Key> key
 * @param <Value> value
 */
public class BinarySTA<Key extends Comparable<Key>,Value> {
    Key[] keys;
    Value[] val;
    int[] leftLinks;
    int[] rightLinks;
    int[] sizes;
    private final int sizeLimit = 1000;
    int count;
    BinarySTA() {
        keys = (Key[]) new Comparable[sizeLimit];
        val = (Value[]) new Object[sizeLimit];
        leftLinks = new int[sizeLimit];
        rightLinks = new int[sizeLimit];
        sizes = new int[sizeLimit];
        count = 0;
    }

    public void put(Key k, Value v) {
        if (k == null) {
            throw new IllegalArgumentException("key cannot be empty");
        }
        // if (sizes == keys.length) {
        //     System.out.println("Size Limit Reached.");
        //     return;
        // }
        put(1, k, v);
    }

    private void put(int index, Key k, Value v) {
        if (index > keys.length - 1) {
            // resize();
            keys[index] = k;
            val[index] = v;
            sizes[index] = 1;
            return ;
        }
        if (keys[index] == null) {
            keys[index] = k;
            val[index] = v;
            return;
        }
        int cmp = k.compareTo(keys[index]);
        if (cmp < 0) {
            leftLinks[index] = 2 * index;
            put(2 * index, k, v);
        } else if (cmp > 0) {
            rightLinks[index] = (2 * index) + 1;
            put((2 * index) + 1, k, v);
        } else {
            val[index] = v;
        }

        sizes[index] = 1 + sizes[2 * index] + sizes[(2 * index) + 1];
        return;
    }

    public Value get(Key k) {
        if (k == null){
            throw new IllegalArgumentException("argument passed is null");
        }
        return get(1, k);
    }

    private Value get(int index, Key k) {
        if (keys[index] == null) {
            return null;
        }
        int cmp = k.compareTo(keys[index]);
        
        if (cmp < 0) {
            return get(2 * index, k);
        } else if (cmp > 0) {
            return get(1 + (2 * index),k);
        } else {
            return val[index];
        }
    }
}

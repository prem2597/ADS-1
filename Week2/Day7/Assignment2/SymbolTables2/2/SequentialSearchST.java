// import jdk.internal.org.objectweb.asm.tree.analysis.Value;

public class SequentialSearchST<Key extends Comparable<Key>,Value> {
    private int n;
    private Node first;

    public SequentialSearchST() {

    }

    Node<Key, Value> head;
    Node<Key, Value> key;
    Node<Key, Value> prevkey;
    Node<Key, Value> tail;

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void organize() {
        if (key != prevkey) {
            prevkey.setNext(key.getNext());
            key.setNext(null);
            tail.setNext(key);
            tail = key;
        }
    }

    public boolean contains(Key key1) {
        // if (key == null)
        // return get(key) != null;
        Node<Key,Value> temp = head;
        if (isEmpty()) {
            return false;
        }
        while (temp.getNext() != null) {
            if (key1.compareTo(temp.getKey()) == 0) {
                key = temp;
                return true;
            }
            prevkey = temp;
            temp = temp.getNext();
        }
        return false;
        
    }

    public Value get(Key key) {
        // for (Node x = first; x != null; x = x.next) {
        //     if (key.equals(x.key)) {
        //         return x.val;
        //     }
        //         // return x.val;
        // }
        // return null;
        if (contains(key)) {
            organize();
            return key.getValue();
        }
        return null;
    }

    public void put(Key key, Value val) {
        // if (val == null) {
        //     delete(key);
        //     return;
        // }

        // for (Node x = first; x != null; x = x.next) {
        //     if (key.equals(x.key)) {
        //         x.val = val;
        //         return;
        //     }
        // }
        // first = new Node(key, val, first);
        // n++;
        if (head == null) {
            head = new Node(key, val);
            tail = head;
            return;
        }
        
        if (contains(key)) {
            this.key.setVal(val);
            return;
        }

        Node<Key, Value> temp = new Node(key, val);
        temp.setNext(head);
        head = temp;
    }

    public void delete(Key key) {
        first = delete(first, key);
    }
    
    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public String keys() {
        if (head == null) {
            return "";
        }
        Node<Key,Value> temp = head;
        String x = "";
        while (temp.getNext() != null) {
            x += temp.getKey() + " ";
            temp = temp.getNext();
        }
        x += temp.getKey() + " ";
        return x;
    }
}

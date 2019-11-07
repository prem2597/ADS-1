// import java.util.Queue;
class SequentialSearchST<Key extends Comparable<Key>,Value> {
    
    private class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }
    
    private int n;
    private Node first;

    public SequentialSearchST() {

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
        Value value = null;
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                // System.out.println(x.val);
                value = x.val;
                delete(key);
            }
            if (x.next == null) {
                Node temp = new Node(key, value, null);
                x.next = temp;
                // System.out.println(value);
                return value;
            }
                // return x.val;
        }
        return null;
    }

    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        } 
        first = delete(first, key);
    }

    private Node delete(Node x, Key key) {
        
        // if (x == null) {
        //     return null;
        // }
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public void put(Key key, Value val) {
        if (key == null) {
            throw new IllegalArgumentException("first argument to put() is null");
        }
        if (val == null) {
            delete(key);
            return;
        }

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }

    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next) {
            queue.enqueue(x.key);
        }
        return queue;
    }

    // public String keys() {
    //     // if (head == null) {
    //     //     return "";
    //     // }
    //     Node temp = first;
    //     String answer = "";
    //     for (Node i = first; i != null; temp = i.next) {
    //         // if (key.equals(x.key)) {
    //         //     return x.val;
    //         // }
    //             // return x.val;
    //         answer += i.key + " ";
    //         temp = i.next;
    //     }
    //     // while (temp.getNext() != null) {
    //     //     answer += temp.getKey() + " ";
    //     //     temp = temp.getNext();
    //     // }
    //     answer += temp.key + " ";
    //     return answer;
    // }
}
class Node<Key, Value> {
    private Key key;
    private Value val;
    private Node next;

    public Node(Key key, Value val, Node next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }

    public Key getKey() {
        return this.key;
    }
    public void setKey(Key key) {
        this.key = key;
    }


    public Value getVal() {
        return this.val;
    }
    public void setVal(Value val) {
        this.val = val;
    }


    public Node getNext() {
        return this.next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
}

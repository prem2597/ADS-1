import java.util.*;
class Node {
    int value;
    Node next;
    Node prev;
    Node (int val) {
        this.value = val;
    }
}
class Linkedlist {
    Node head;
    Node tail;

    public void add(int val) {
        Node node = new Node(val);
        if (this.head == null){
            this.head = node;
            this.tail = node;
        }else {
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
    }

    public void formCircle() {
        this.tail.next = this.head;
        this.head.prev = this.tail;
    }
}

class Solution{
	public static String Josephus(int a, int b){
		// fill you code Here
		Linkedlist data = new Linkedlist();
		for (int i = 0; i < a; i++) {
			Node node = new Node(i);
			data.add(i);
		}
		data.formCircle();
		int position = 1;
		Node x = data.head;
		int del = 0;
		String toReturn =" ";
		while(del != a) {
			x = x.next;
			position++;
			if(position == b) {
				position = 1;
				toReturn += x.value + " ";
				Node prevNode = x.prev;
				Node nextNode = x.next;
				prevNode.next = nextNode;
				nextNode.prev = prevNode;
				del++;
				x = x.next;
			}
		}
		toReturn = toReturn.trim();
		return toReturn;
	}
}
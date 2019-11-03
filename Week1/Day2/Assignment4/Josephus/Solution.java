import java.util.*;
class Queue {
	private static int[] arr;
	private static int size;
	public int[] getArr() {
		return arr;
	}
	public int getSize() {
		return size;
	}
	Queue(final int capacity) {
		arr = new int[capacity];
		size = capacity;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
	}
	public void enqueue(final int item) {
		arr[size++] = item;
	}
	public int dequeue() {
		if (!isempty()) {
			int removedItem = arr[0];
			for (int i = 0; i < arr.length - 1; i++) {
				arr[i] = arr[i + 1];
			}
			arr[--size] = 0;
			return removedItem;
		}
		return 0;
	}
	public boolean isempty() {
		return size == 0;
	}

}
class Solution {
	public static String Josephus(int a, int b){
		// fill you code Here
		String x = "";
		Queue queue = new Queue(a);
		int count = 0;
		int result;

		while (count < a - 1) {
			if (b > queue.getSize()) {
				result = b % queue.getSize();
				if (result == 0) {
					result = queue.getSize();
				}
			} else {
				result = b;
			}
			while (result > 1) {
				queue.enqueue(queue.dequeue());
				result--;
			}
			x += queue.dequeue() + " ";
			count++;
		}
		return x + queue.getArr()[0];
	}
}
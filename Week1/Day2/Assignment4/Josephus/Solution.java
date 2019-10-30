import java.util.*;
class Solution{
	public static String Josephus(int a, int b){
		// fill you code Here
		String s = "";
		int x;
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < a; i++) {
			queue.add(i);
		}
		System.out.println(queue);
		while (queue.size() > 1) {
			for (int j = 0; j < b - 1; j++) {
				x = queue.remove();
				queue.add(x);
			}
			s = s + queue.remove() + " ";
		}
		s = s + queue.remove();
		return s;
	}
}
import java.util.*;
public class LearnByDoing1 {
	public static class GenericStack <T> {
		private ArrayList<T> stack = new ArrayList<T> ();
		private int top = 0;
		public int size() {
			return top;
		}
		public void push (T item) {
			stack.add(top++, item);
		}
		public T pop() {
			return stack.remove(--top);
		}
	}
	public static void main(String[] args) {
		GenericStack<String> st = new GenericStack<String> ();
		String testString = "it was - the best - of times - - - it was - the - -";
		// char[] stringToCharArray = testString.toCharArray();
		String[] exp = testString.split(" ");
		// for(String  output : exp) {
		//     System.out.println(output);
		// }
		// System.out.println(exp[]);
		for(int i = 0; i < exp.length ; i++) {
			if(exp[i] != "-") {
				st.push(exp[i]);
			} else if (exp[i] == "-") {
				st.pop();
			}
			System.out.println(Arrays.toString(st));
		}
		// System.out.println(st);
		// PrintStack(st);
		
	}
}

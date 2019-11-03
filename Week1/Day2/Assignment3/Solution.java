/**
 * @author PREM
 */
public final class Solution {

	private Solution() {

	}
	/**
	 * Stack class.
	 * implements push operation to push the elements
	 * inplements pop operation to pop the elements
	 */
	static class Stack {
		/**
		 * top represents the value at the last.
		 */
		private int top = -1;
		/**
		 * to set size of an array.
		 * to push the elements.
		 */
		private char[] items = new char[100];
		void push(final char x) {
			if (top == 99) {
				System.out.println("Stack full");
			} else {
				items[++top] = x;
			}
		}
		public char pop() {
			if (top == -1) {
				System.out.println("Underflow error");
				return '\0';
			} else {
				char element = items[top];
				top--;
				return element;
			}
		}
		boolean isEmpty() {
			if (top == -1) {
				return true;
			} else {
				return false;
			}
		}
	}
	/**
	 * to check the elements will match or not.
	 * @param character1 first char
	 * @param character2 second char
	 * @return true or false depending upon the matching
	 */
	public  static boolean isMatchingPair(final char character1,
		final char character2) {
		if (character1 == '(' && character2 == ')') {
			return true;
		} else if (character1 == '{' && character2 == '}') {
			return true;
		} else if (character1 == '[' && character2 == ']') {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * main method.
	 * @param str String input
	 * @return yes or no
	 */
	public static String isMatching(final String str) {
		// fill you code Here
		// String[] exp = str.split("");
		char[] exp = str.toCharArray();
		Stack st = new Stack();
		for (int i = 0; i < exp.length; i++) {
			if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[') {
				st.push(exp[i]);
			}
			if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']') {
				if (st.isEmpty()) {
					return "NO";
				} else if (!isMatchingPair(st.pop(), exp[i])) {
					return "NO";
				}
			}
		}
		if (st.isEmpty()) {
			return "YES";
		} else {
			return "NO";
		}
		// return "YES";
	}
}

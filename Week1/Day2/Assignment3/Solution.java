class Solution {
	static class stack {
		private int top = -1;
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
	public static String isMatching(final String str) {
		// fill you code Here
		// String[] exp = str.split("");
		char[] exp = str.toCharArray();
		stack st = new stack();
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

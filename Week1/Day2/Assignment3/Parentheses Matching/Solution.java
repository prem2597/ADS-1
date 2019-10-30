import java.util.*;
	public static String isMatching(String str){
		// fill you code Here
		public static class  stack {
			int top = -1;
			char[] items = new char[100];
			public void push(char x) {
				if(top == 99) {
					System.out.println("Stack full");
				} else {
					items[++top] = x; 
				}
			}
			public char pop() {
				if (top == -1) {
					System.out.println("underflow error");
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
			public static boolean isMatchingPair (char character1, char character2) {
				if(character1 == '(' && character2 == ')') {
					return true;
				} else if (character1 == '{' && character2 == '}') {
					return true;
				} else if (character1 == '[' && character2 == ']') {
					return true;
				} else {
					return false;
				}
				
			}
		}
		return "YES";
	}
}
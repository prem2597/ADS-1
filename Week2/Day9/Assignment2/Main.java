import java.util.Scanner;
class Main {
    public static void main(String[] args) { 
        LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        for (int i = 0; !str.isEmpty(); i++) {
            String key = str.readString();
            str.put(key, i);
        }
        for (String s : st.keys()) {
            System.out.println(s + " " + st.get(s));
        }
    }
}
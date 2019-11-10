import java.util.Scanner;
class Main {
    public static void main(String[] args) { 
        LinearProbingHashST<String, Integer> str = new LinearProbingHashST<String, Integer>();
        // Scanner in = new Scanner(System.in);
        // String str = in.nextLine();
        str.put("Prem", 42);
        str.put("P", 5);
        System.out.println("Before update p value :" +  str.get("P"));
        str.put("P", 542);
        str.display();
        System.out.println("After update p value :" + str.get("P"));
        System.out.println(str.get("Prem"));
    }
}
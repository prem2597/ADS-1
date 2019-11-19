import java.util.*;
/**
 * Main Class.
 * @author PREM
 * referenece Bob Sedgweick.
 */
class Solution {
    private Solution() {
    }
    public static void main(String[] args) {
        BinarySearchST<String, Integer> x = new BinarySearchST<String, Integer>();
        x.put("A",500);
        // System.out.println(x.key);
        // System.out.println("-----");
        System.out.println(x.get("A"));
        // System.out.println("-----");
        x.put("B",1);
        // System.out.println(x.get("B"));
        x.put("C",2);
        x.put("D",3);
        x.put("E",4);
        x.put("F",5);
        x.put("G",6);
        x.put("H",7);
        System.out.println("-----");
        System.out.println(x.get("H"));
        System.out.println("-----");
        x.put("I",8);
        x.put("J",9);
        x.put("K",10);
        x.put("L",11);
        x.put("M",12);
        x.put("Z",10000);
        x.put("Y",1);
        x.put("X",2);
        x.put("W",3);
        x.put("V",4);
        x.put("U",5);
        x.put("T",6);
        x.put("S",7);
        x.put("R",8);
        x.put("Q",9);
        x.put("P",10);
        x.put("O",11);
        x.put("N",12);
        System.out.println(x.get("M"));
        System.out.println(x.get("Y"));
    }
}
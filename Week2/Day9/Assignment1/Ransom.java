import java.io.*;
// import java.security.Key;
import java.util.*;
import java.util.Scanner;


// import jdk.internal.org.objectweb.asm.tree.analysis.Value;

public class Ransom {

    public static boolean canRansom(String[] ransom, String[] magazine) {

        SeparateChainingHashST<String, Integer> r = new SeparateChainingHashST();

        Boolean result;

        for (int i = 0; i < ransom.length; i++) {
            String n = ransom[i];
            if (r.contains(n)) {
                int freq = r.get(n);
                r.put(n, freq += 1);
            } else {
                r.put(n, 1);
            }
        }

        for (int j = 0; j < magazine.length; j++) {
            String m = magazine[j];
            if (r.contains(m)) {
                int freq = r.get(m);
                if (freq == 1) {
                    r.delete(m);
                } else {
                    r.put(m, freq-=1);
                }
            }
        }
        
        if (r.isEmpty()) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }
    
    public static void main(String[] args) {
        String result;
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>();
        String[] magazine = {"String", "Fun", "japan", "sandeep"};
        String[] ransom = {"String", "Fun", "japan", "sandeep"};
        if (canRansom(ransom, magazine)) {
            result = "yes";
        } else {
            result = "No";
        }

        System.out.println(result);

        String[] magazine1 = {"give", "me", "one", "night"};
        String[] ransom1 = {"it", "me", "one", "night"};

        if (canRansom(ransom1, magazine1)) {
            result = "yes";
        } else {
            result = "No";
        }

        System.out.println(result);

    }
}

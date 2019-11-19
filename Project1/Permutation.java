import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
// import java.lang;
import java.util.NoSuchElementException;
// import java.lang.*;
/**
 * permuatation using deck and Randomized queue.
 * @author PREM
 * reference Bob Sedgewick, Stack overFlow, Geek for Geeks, coursera.
 */
public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> q = new RandomizedQueue<String>();
        int outerCount = Integer.parseInt(args[0]);
        int innerCount = 0;
        // system.out.println(outerCount);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (item != null && item.length() > 0) {
                q.enqueue(item);
                innerCount++;
            }
        }
        if (innerCount < outerCount) {
            throw new NoSuchElementException();
        }
        while (outerCount > 0) {
            StdOut.println(q.dequeue());
            outerCount--;
        }
    }
}

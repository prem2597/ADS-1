import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
public class Solution {
    /**
     * @author PREM
     * @param args the command-line arguments
     * refernce Bob Sedgewick.
     * Time : Insertion Nlogn, deletion : klogn.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the heap");
        int n = Integer.parseInt(sc.nextLine());
        MinPQ<Integer> pq = new MinPQ<Integer>(n);
        MaxPQ<Integer> q = new MaxPQ<Integer>(n);
        // while (!StdIn.isEmpty()) {
        //     String item = StdIn.readString();
        //     if (!item.equals("-")) pq.insert(item);
        //     else if (!pq.isEmpty()) StdOut.print(pq.delMin() + " ");
        // }
        System.out.println("Enter the elements into Heap");
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(sc.nextLine());
            pq.insert(m);
            q.insert(m);
        }
        // pq.iterator();
        System.out.println("Elements in the Min Heap : ");
        for (int s : pq) {
            System.out.print(s+" ");
        }
        System.out.println();
        System.out.println("Elements in the Max Heap : ");
        for (int s : q) {
            System.out.print(s+" ");
        }
        System.out.println();
        System.out.println("Enter the kth number of largest elements you require : ");
        int k = Integer.parseInt(sc.nextLine());
        if (k <= n) {
            for (int j = 1; j <= (n - k); j++) {
                pq.delMin();
            }
        } else {
            System.out.println("Enter the correct value.");
        }
        System.out.println("Elements in the Min Heap : ");
        for (int s : pq) {
            System.out.print(s+" ");
        }
        System.out.println();
        int count = 0;
        for (int j = 1; j <= k; j++) {
            int x = q.delMax();
            System.out.println("The elements which are being deleted in maxpq is : "+x);
            for (int s : pq) {
                if (s == x) {
                    count = count + 1;
                }
            }
        }
        if (count == k) {
            System.out.println("It is proved that all the elements are largest");
        }
    }
}
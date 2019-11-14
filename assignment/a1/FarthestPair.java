// import java.util.Arrays;
import java.util.Scanner;
// import java.util.Random;
/**
 * @author PREM
 */
public final class FarthestPair {
    /**
     * default constructor.
     */
    private FarthestPair() {

    }
    /**
     * Main method.
     * @param args arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = scan.nextInt();
        // Random rand = new Random(n);
        // int[] arr = {10, 5, 40, 52, 42, 100, 65};
        int[] arr = new int[n];
        int max;
        int min;
        System.out.println("Enter the elements into the array");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int m = arr.length;
        if (m == 1) {
            max = arr[0];
            min = arr[0];
        }
        if (m == 2) {
            if (arr[0] > arr[1]) {
                max = arr[0];
                min = arr[1];
            }
            if (arr[0] < arr[1]) {
                max = arr[1];
                min = arr[0];
            }
        }
        max = arr[0];
        min = arr[0];
        for (int i = 0; i <= m - 1; i++) {
            if (arr[i] > max) {
                max = arr[i];
                // min = arr[i+1];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        // System.out.println("Sorted Array :");
        // Arrays.sort(arr);
        for (int i = 0; i <= m - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        scan.close();
        System.out.println("Farthest Pair :" + min + " " + max);
    }
}

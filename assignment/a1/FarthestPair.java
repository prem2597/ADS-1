// import java.util.Arrays;
import java.util.Scanner;
// import java.util.Random;
// import java.lang.IndexOutOfBoundsException;
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
     * fathest methods tells the min value and the max value
     * @param arr array
     * @param min minimum value
     * @param max maximum value
     */
    public static void farthest(final int[] arr, int min, int max) {
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
        // max = arr[0];
        // min = arr[0];
        for (int i = 0; i <= m - 1; i++) {
            if (arr[i] > max) {
                max = arr[i];
                // min = arr[i+1];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        // to print the array.
        for (int i = 0; i <= m - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("Farthest Pair :" + min + " " + max);

    }
    /**
     * Main method.
     * @param args arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        // System.out.println("Enter the size of the array");
        // int n = scan.nextInt();
        // if (n < 0) {
        //     throw new IndexOutOfBoundsException("Array index out of bound");
        // }
        // Random rand = new Random(n);
        // int[] arr = {10, 5, 40, 52, 42, 100, 65};
        int n = 10;
        int[] arr = new int[n];
        System.out.println("Enter the elements into the array");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int max = arr[0];
        int min = arr[0];
        farthest(arr, min, max);
        // System.out.println("Sorted Array :");
        // Arrays.sort(arr);
        scan.close();
    }
}

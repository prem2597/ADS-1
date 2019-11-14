import java.util.Arrays;
import java.util.Scanner;
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
        int[] arr = new int[n];
        System.out.println("Enter the elements into the array");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        System.out.println("Sorted Array :");
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        scan.close();
        System.out.println("Farthest Pair :" + arr[0] + " " + arr[n - 1]);
    }
}

import java.util.*;

public class Minpq {

    public static boolean isHeap(int arr[], int i, int n) {
        if (i < (n - 2) / 2) {
            return true;
        }
        if(arr[i] <= arr[2 * i + 1] && arr[i] <= arr[2 * i + 2]
        && isHeap(arr, 2 * i + 1, n) && isHeap(arr, 2 * i + 2, n)) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        int arr[] = {1000, 90, 15, 10, 7, 12, 100, 7, 3};
        int n = arr.length - 1;
        if (isHeap(arr, 0, n)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
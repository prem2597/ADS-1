import java.util.*;
/**
 * @author PREM
 * Time complexity N/2.
 */
public final class Solution {
	/**
	 * constructor.
	 */
	private Solution() {

	}

	/**
	 * check whether is in heap or not.
	 * @param arr array
	 * @param i intial value index
	 * @param n final value index
	 * @return true or false.
	 */
	public static boolean isHeap(final double[] arr,
	final int i, final int n) {
        // if (arr[i] < (n - 2) / 2) {
		// 	if (arr[i] <= arr[2 * i + 1] && arr[i] <= arr[2 * i + 2]
        //     && isHeap(arr, 2 * i + 1, n) && isHeap(arr, 2 * i + 2, n)) {
		// 		return true;
		// 	}
		// 	return true;
        // }
		// return false;
		for (int j = (n / 2 - 1); j >= 0; j--) {
			if (arr[j] > arr[2 * j + 1]) {
				return false;
			}
			if (2 * j + 2 < n) {
				if (arr[j] > arr[2 * j + 2]) {
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * checks whether it is in min heap or not.
	 * @param arr array
	 * @return true or false.
	 */
	public static boolean isMinHeap(final double[] arr) {
		int n = arr.length - 1;
		if (n < 0) {
			return false;
		}
		if (isHeap(arr, 0, n)) {
			return true;
		} else {
			return false;
		}
		// return false;
	}
    // public static void main(String[] args) {
    //     int arr[] = {1000, 90, 15, 10, 7, 12, 100, 7, 3};
    //     int n = arr.length - 1;
    //     if (isHeap(arr, 0, n)) {
    //         System.out.println("yes");
    //     } else {
    //         System.out.println("no");
    //     }
    // }
}

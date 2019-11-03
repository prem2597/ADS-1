/**
 * @author Prem
 */
import java.util.*;
public final class Solution {
	private static int partition(final int[] arr,
	final int low, final int high) {
		int i = low;
        int j = high + 1;
        while (true) {
            while (arr[low] > arr[++i]) {
                if (i == high) {
                    break;
                }
            }
            while (arr[low] < arr[--j]) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(arr, i, j);
        }
        exch(arr, low, j);
        return j;
	}
	// public static void shuffle(int[] arr) {
	// 	Random rand = new Random();
	// 	int n = arr.length;
	// 	for(int i = 0; i < n; i++) {
	// 		int r = i + rand.nextInt(n - i);
	// 		swap(arr,r,i);
	// 		// System.out.println(arr);
	// 	}
	// 	// System.out.println(arr);
	// 	// for (int i = 0; i < n; i++) {
	// 	// 	System.out.print(arr[i] + " ");
	// 	// }
	// 	// System.out.println("--------------");

	// }

	public static int[] randomize(int[] arr) {
        int[] temptwo = new int[arr.length];
        List<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            temp.add(i);
        }
        Collections.shuffle(temp);
        for (int i = 0; i < arr.length; i++) {
            temptwo[i] = arr[temp.get(i)];
        }
        return temptwo;
    }
	public static void exch(final int[] arr, final int i, final int j) {
		int temp;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void quickSort(final int[] arr,
	final int low, final int high) {
		if (high <= low) {
            return;
        }
        int j = partition(arr, low, high);
        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);
	}
	public static int[] quickSort(final int[] arr) {
		// fill you code Here
		int[] temp = randomize(arr);
		quickSort(temp, 0, arr.length - 1);
		return temp;
	}
}

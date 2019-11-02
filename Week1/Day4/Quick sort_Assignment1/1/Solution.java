/**
 * @author Prem
 */
class Solution {
	private static int partition(final int[] arr,
	final int low, final int high) {
		int pivot = arr[high];
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp2 = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp2;

		return i + 1;
	}
	public static int[] quickSort(final int[] arr,
	final int low, final int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
		return arr;
	}
	public static int[] quickSort(final int[] arr) {
		// fill you code Here
		int low = 0;
		int high = arr.length  - 1;
		int[] c;
		c = quickSort(arr, low, high);
		return c;
	}
}

/**
 * @author Prem
 */
class Solution {
	public static String[] mergeSort(final String[] arr) {
		sort(arr);
		return arr;
	}

	public static void sort(final String[] arr) {
		String[] aux = new String[arr.length];
		sort(arr, aux, 0, arr.length - 1);
	}

	private static void sort(final String[] arr,
	final String[] aux, final int low, final int high) {
		if (high <= low) {
			return;
		}
		int mid = (low + high) / 2;
		sort(arr, aux, low, mid);
		sort(arr, aux, mid + 1, high);
		merge(arr, aux, low, mid, high);
	}

	public static void merge(final String[] arr, final String[] aux,
	final int low, final int mid, final int high) {
		for (int i = 0; i < arr.length; i++) {
			aux[i] = arr[i];
		}

		int i = low;
		int j = mid + 1;
		for (int k = low; k <= high; k++) {
			if (i > mid) {
				arr[k] = aux[j++];
			} else if (j > high) {
				arr[k] = aux[i++];
			} else if (aux[i].compareTo(aux[j]) > 0) {
				arr[k] = aux[j++];
			} else {
				arr[k] = aux[i++];
			}
		}
	}
}

/**
 * @author PREM
 */
public final class Solution {
	/**
	 * sort the values using insertion method.
	 * @param arr array
	 * @return array.
	 */
	public int[] sortInsertion(final int[] arr) {
		// fill you code Here
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key  = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		// return null;
		}
		return arr;
	}
	/**
	 * sort the array using selection method.
	 * @param arr array.
	 * @return array
	 */
	public int[] sortSelection(final int[] arr) {
		// fill you code Here
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int temp = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[temp]) {
					temp = j;
				}
			}
			int temp2 = arr[temp];
			arr[temp] = arr[i];
			arr[i] = temp2;
		}
		// return null;
		return arr;
	}
}

import java.util.*;
/**
 * @author PREM
 * Time Complexity:
 * Insertion Logarithmic time.
 * Deletion Logarithmic time.
 * median constant time.
 */
public final class Solution {
	/**
	 * Constructor.
	 */
	private Solution() {

	}

	/**
	 * calculating dynamic median.
	 * @param arr Array
	 * @return array
	 */
	public static double[] dynamicMedian(final double[] arr) {

		double median = 0;

		 int n = arr.length;

		MaxPQ<Double> right = new MaxPQ(n);

		MinPQ<Double> left = new MinPQ(n);

		for (int i = 0; i < n; i++) {
			if (arr[i] <= median) {
				right.insert(arr[i]);
			} else {
				left.insert(arr[i]);
			}

			if (left.size() > right.size() + 1) {
				right.insert(left.min());
				left.delMax();
			}

			if (right.size() > left.size() + 1) {
				left.insert(right.max());
				right.delMax();
			}
			if (left.size() == right.size()) {
				median = (right.max() + left.min()) / 2.0;
			} else if (left.size() > right.size()) {
				median = (double) left.min();
			} else if (left.size() < right.size()) {
				median = (double) right.max();
			}

			arr[i] = median;
		}
		return arr;
	}
}

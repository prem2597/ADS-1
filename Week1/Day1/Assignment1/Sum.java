import java.util.Arrays;
/**
 *
 * @author Prem
 */
public class Sum {
    /**
     * binary search to search the element.
     * @param arr array 
     * @param key search element
     * @return if value is there or not.
     */
    public static int binarySearch(final int[] arr, final int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] > key) {
                high = mid - 1;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                return arr[mid];
            }
        }
        return -1;
    }
    public static int counts(final int[] arr) {
        int key;
        int c;
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                // if ((arr[i] + arr[j]) > 0) {
                //     // System.out.println("First check");
                //     key = (~((arr[i] + arr[j]) - 1));
                //     // System.out.println(key);
                // } else if ((arr[i] + arr[j]) < 0) {
                //     // System.out.println("Second check");
                //     key = Math.abs((arr[i] + arr[j]));
                //     // System.out.println(key);
                // } else {
                //     // System.out.println("third check");
                //     key = 0;
                //     // System.out.println(key);
                // }
                key = (~((arr[i] + arr[j]) - 1));
                c = binarySearch(arr, key);
                if (c == key) {
                    if (arr[i] < arr[j]
                    && arr[j] < ((~((arr[i] + arr[j]) - 1)))) {
                        count = count + 1;
                        System.out.println(arr[i] + "," + arr[j] + "," + key);
                    }
                }
            }
        }
        return count;
    }
    public static void main(final String[] args) {
        // int count = 0;
        int[] arr = {30, -40, -20, -10, 40, 0, 10, 5};
        // int key;
        // int c;
        int count1;
        Arrays.sort(arr);
        // String[] s = Arrays.toString(arr);
        System.out.printf("Modified array : %s \n", Arrays.toString(arr));
        // System.out.println(s);
        count1 = counts(arr);
        System.out.println(count1);
    }
}

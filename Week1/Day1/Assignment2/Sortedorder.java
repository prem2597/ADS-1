import java.util.Arrays;
/**
 * @author PREM
 */
public final class Sortedorder {

    private Sortedorder() {

    }
    /**
     * to merge the arrays.
     * @param arr1 array1
     * @param arr2 array2
     * @return sorted array
     */
    public static int[] mergeArrays(final int[] arr1, final int[] arr2) {
        int[] x = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        for (int k = 0; k < x.length; k++) {
            if (i > arr1.length - 1) {
                x[k] = arr2[j++];
            } else if (j > x.length - 1) {
                x[k] = arr2[i++];
            } else if (arr1[i] < arr2[j]) {
                x[k] = arr1[i++];
            } else {
                x[k] = arr2[j++];
            }
        }
        return x;
    }
    /**
     * Main method.
     * @param args arguments
     */
    public static void main(final String[] args) {
        int[] arr1 = new int[]{-50, -17, -16, -5, -1, 0, 5, 8, 6, 57};
        int[] arr2 = new int[]{-40, -25, -5, -2, 0, 8, 64, 85, 97, 100};
        // Arrays.sort(arr1);
        // Arrays.sort(arr2);
        // String[] s = Arrays.toString(arr);
        // System.out.printf("Modified array 1 : %s \n", Arrays.toString(arr1));
        // System.out.printf("Modified array 2 : %s \n", Arrays.toString(arr2));
        // System.out.println(s);
        int[] arr3 = mergeArrays(arr1, arr2);
        // for (int i = 0; i < (arr1.length + arr2.length) - 1; i++) {
        //     System.out.print(arr3[i] + " ");
        // }
        System.out.printf("Resultant array 3 : %s \n", Arrays.toString(arr3));
    }
}

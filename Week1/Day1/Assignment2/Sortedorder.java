/**
 * @author PREM
 */
import java.util.Arrays;
class Sortedorder {
    public static int[] mergeArrays(final int[] arr1,final int[] arr2) {
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
    public static void main(final String[] args) {
        int[] arr1 = new int[]{-50, -25, -4, -1, 0, 3, 7, 14, 27, 48, 70};
        int[] arr2 = new int[]{-40, -16, -12, -7, 0, 13, 17, 24, 37, 38, 90};
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

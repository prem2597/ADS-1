import java.util.Arrays;
class Sortedorder {
    public static void mergeArrays(final int[] arr1,
        final int[] arr2, final int[] arr3) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            arr3[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            arr3[k++] = arr2[j++];
        }
    }
    public static void main(final String[] args) {
        int[] arr1 = {6, 7, 9, 13, 45, 45, 45, 101, 102};
        int[] arr2 = {5, 6, 8, 10, 13};
        // Arrays.sort(arr1);
        // Arrays.sort(arr2);
        // String[] s = Arrays.toString(arr);
        // System.out.printf("Modified array 1 : %s \n", Arrays.toString(arr1));
        // System.out.printf("Modified array 2 : %s \n", Arrays.toString(arr2));
        // System.out.println(s);
        int[] arr3 = new int[arr1.length + arr2.length];
        mergeArrays(arr1, arr2, arr3);
        // for (int i = 0; i < (arr1.length + arr2.length) - 1; i++) {
        //     System.out.print(arr3[i] + " ");
        // }
        System.out.printf("Resultant array 3 : %s \n", Arrays.toString(arr3));
    }
}

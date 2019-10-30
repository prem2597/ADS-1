import java.util.Arrays;
class Linearithmic {
    public static void main(final String[] args) {
        int count = 0;
        int[] arr = {13, 7, 6, 45, 45, 45, 9, 101, 102};
        Arrays.sort(arr);
        // String[] s = Arrays.toString(arr);
        System.out.printf("Modified array : %s \n", Arrays.toString(arr));
        // System.out.println(s);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                count = count + 1;
            }
        }
        System.out.println(count);
    }
}

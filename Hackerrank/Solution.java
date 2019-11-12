import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public void binary(int[] arr, int i, int n, int k) {
        if (i >= n) {
            System.out.println("-1 -1 0");
            return;
        }
        int mid = i + (i + n)/2;
        if ((arr[mid] == k) && (arr[mid-1] != k)) {
            int begin = mid;
            int count = 0;
            while (arr[mid] == k) {
                count = count + 1;
                mid = mid + 1;
            }
            System.out.println(begin+" "+(mid-1)+" "+count);
            return;
        } else if ((arr[mid] == arr[mid - 1]) || (k < arr[mid])) {
            binary(arr,i,mid,k);
        } else {
            binary(arr, mid+1, n, k);
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[n];
        for (int i=0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int k = scan.nextInt();
        binary(arr,0,n-1,k);
        return;
        
    }
}
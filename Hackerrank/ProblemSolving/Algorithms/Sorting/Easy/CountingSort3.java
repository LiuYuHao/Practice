import java.io.*;
import java.util.*;
/*
Task: the last step of counting sort adding the frequency of previous index for knowing the position
*/
public class CountingSort3 {
    public static void CountingSort(int[] arr) {
        int[] result = new int[100];
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i];
            result[index] += 1;
        }
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i] + result[i - 1];
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc  = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
            String string = sc.next();
        }
        CountingSort(arr);
    }
}

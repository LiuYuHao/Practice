import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: use first element as pivot and use quicksort knowledge print the first iteration
Input: a int arr
Output: a int arr
*/
public class QuickSort1 {

    // Complete the quickSort function below.
    static int[] quickSort(int[] arr) {
        int x = arr[0];
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < x) {
                left.add(arr[i]);
            }
            else {
                right.add(arr[i]);
            }
        }
        int position = 0;
        for (int i = 0; i < left.size(); i++) {
            arr[position] = left.get(i);
            position++;
        }
        arr[position] = x;
        position++;
        for (int i = 0; i < right.size(); i++) {
            arr[position] = right.get(i);
            position++;
        }
        return arr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = quickSort(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

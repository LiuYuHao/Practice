import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find the mini delete from the array to make all element in the array are equal
Input: a int array
Output: a int represent amount of deletions
*/
public class Solution {

    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!hm.containsKey(arr[i])) {
                hm.put(arr[i], 1);
            }
            else{
                hm.put(arr[i], hm.get(arr[i]) + 1);
            }
        }
        int max_frequency = hm.get(arr[0]);
        int max_key = arr[0];
        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            if (e.getValue() > max_frequency) {
                max_frequency = e.getValue();
                max_key = e.getKey();
            }
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            if (e.getKey() != max_key) {
                count += e.getValue();
            }
        }
        return count;
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

        int result = equalizeArray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

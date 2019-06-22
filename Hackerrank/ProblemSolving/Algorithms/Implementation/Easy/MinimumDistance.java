import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find the min difference in index where two element are the same in a array
Input: int array
Output: a int for min difference in index
*/
public class Solution {

    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int min_difference = a.length;
        for (int i = 0; i < a.length; i++) {
            if (hm.containsKey(a[i])) {
                int difference = i - hm.get(a[i]);
                if (difference < min_difference) {
                    min_difference = difference;
                }
            }
            else {
                hm.put(a[i], i);
            }
        }
        if (min_difference == a.length) {
            return -1;
        }
        return min_difference;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

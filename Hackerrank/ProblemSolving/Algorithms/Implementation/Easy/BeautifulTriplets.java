import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find the amount of triplets that is (i, j, k) where j - i = k - j = d
Input: a int d and one int arrary
Output: a int for amount of triplets that is beautiful
*/
public class Solution {

    // Complete the beautifulTriplets function below.
    static int beautifulTriplets(int d, int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!hm.containsKey(arr[i])) {
                hm.put(arr[i], 1);
            }
            else {
                hm.put(arr[i], hm.get(arr[i]) + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(arr[i] + d) && hm.containsKey(arr[i] + d + d)) {
                count += (hm.get(arr[i] + d) * hm.get(arr[i] + d + d));
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = beautifulTriplets(d, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

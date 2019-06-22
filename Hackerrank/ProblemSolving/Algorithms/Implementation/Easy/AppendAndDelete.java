import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: two operations, add and delete the last character, check if make s to t exactly k times
Input: two strings and one int k;
Output: a string whether yes or no
*/
public class Solution {

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        if (k > s.length() + t.length()) {
            return "Yes";
        }
        if (s.equals(t)) {
            if (k % 2 == 0) {
                return "Yes";
            }
            return "No";
        }
        String s_sub = "";
        String t_sub = "";
        for (int i = 0; i < s.length() && i < t.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                s_sub += s.charAt(i);
                t_sub += t.charAt(i);
            }
            else {
                break;
            }
        }
        //System.out.println(s_sub);
        //System.out.println(t_sub);
        int amount_deletes = (s.length() - s_sub.length()) + (t.length() - s_sub.length());
        //System.out.println(amount_deletes);
        if (amount_deletes == k) {
            return "Yes";
        }
        if (amount_deletes > k) {
            return "No";
        }
        // when k > amount_deletes
        int remaining = k - amount_deletes;
        if (remaining % 2 == 0) {
            return "Yes";
        }
        // int difference_size = Math.abs(t.length() - s.length());
        // if (difference_size > remaining) {
        //     return "No";
        // }
        // if (difference_size == remaining) {
        //     return "Yes";
        // }
        // int left = remaining - difference_size;
        // if (left % 2 == 0) {
        //     return "Yes";
        // }
        return "No";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

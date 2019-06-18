import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: determine the string is funny or not based on the abso difference of
      adjacent index of ascii of string and the reverse string.
Input: a string s
Output: a string Funny or not Funny

*/
public class Solution {

    // Complete the funnyString function below.
    static String funnyString(String s) {
        int[] asc = new int[s.length()];
        int[] re_asc = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            asc[i] = (int) s.charAt(i);
            re_asc[i] = (int) s.charAt(s.length() - 1 - i);
        }
        int[] asc_difference = new int[asc.length - 1];
        int[] re_asc_difference = new int[re_asc.length - 1];
        for (int i = 0; i < asc_difference.length; i++) {
            asc_difference[i] = Math.abs(asc[i] - asc[i + 1]);
            re_asc_difference[i] = Math.abs(re_asc[i] - re_asc[i + 1]);
        }
        for (int i = 0; i < asc_difference.length; i++) {
            if (asc_difference[i] != re_asc_difference[i]) {
                return "Not Funny";
            }
        }
        return "Funny";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = funnyString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

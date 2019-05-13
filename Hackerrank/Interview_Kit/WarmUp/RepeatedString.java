import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find amount of a in a string based on the Integer n which if n > string size, the string will repeated.
      e.g abc n = 10, abcabcabca 4 total of a
Input: A string s and a long Integer n
Output: a int for indicate amount of a in a repeated string
*/
public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hm.merge(s.charAt(i), 1, Integer::sum);
        }
        if (!hm.containsKey('a')) {
            return 0;
        }
        long x = (long)n/s.length();
        long result = hm.get('a') * x;
        long r = n % s.length();
        for (int i = 0; i < r; i++) {
            if (s.charAt(i) == 'a') {
                result++;
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

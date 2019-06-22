import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find the amount of digit in a number where number %  digit == 0
Input: a int n
Output: a int amount of digits matched the objective
*/
public class Solution {

    // Complete the findDigits function below.
    static int findDigits(int n) {
        int count = 0;
        String number = Integer.toString(n);
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != '0') {
                int digit = Character.getNumericValue(number.charAt(i));
                if (n % digit == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = findDigits(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

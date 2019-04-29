import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: Hiking - below sea level and back to sea level = pass one valleys, a string count U and D represent up and down
Input: A string contained U and D
Output a int represent how many valleys passed
*/
public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int count = 0;
        int sea = 0;
        boolean start = false;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'U') {
                sea += 1;
            }
            if (s.charAt(i) == 'D') {
                sea -= 1;
            }
            if (sea < 0) {
                start = true;
            }
            if (start == true && sea >= 0) {
                start = false;
                count++;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

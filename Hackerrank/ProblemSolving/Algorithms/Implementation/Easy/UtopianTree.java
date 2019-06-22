import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: a tree grow 2 cycle in a year, spring * 2 and summer + 1 begin with at spring and 1
Input: a int n for amount of cycles
Output: a int for the height
*/
public class uTopianTree {

    // Complete the utopianTree function below.
    static int utopianTree(int n) {
        int start = 1;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                start = start + 1;
            }
            else {
                start = start * 2;
            }
        }
        return start;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = utopianTree(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

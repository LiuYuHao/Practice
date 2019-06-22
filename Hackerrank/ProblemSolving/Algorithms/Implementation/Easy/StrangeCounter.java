import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: the counter is begin at 3 and decrease by 1 until 1 and start again with the previous amount of decreasing x 3 (second round is 6)
Input: a long t
Output: a long t where the number that will corresponding to the pattern index t
*/
public class Solution {

    // Complete the strangeCounter function below.
    static long strangeCounter(long t) {
    int i = 1;
    int rate = 3;
    while (i + rate <= t) {
        i = i + rate;
        rate = rate * 2;
    }
    return rate - t + i;
    }
    // O(1) solution
    // static long strangeCounter(long t) {
    //     long x = (t + 2) / 3;
    //     System.out.println(x);
    //     long b = Long.highestOneBit(x);
    //     System.out.println(b);
    //     long tb = 3 * b;
    //     return tb - (t - (tb - 2));
    // }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long t = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = strangeCounter(t);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

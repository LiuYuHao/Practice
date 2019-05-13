import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: Find amount of way to get the top stair, where you can jump one, two, three
Input: a int n for amount of stair
Output a int for amount of different way
*/
public class DavisStairCase {

    // Complete the stepPerms function below.
    static int stepPerms(int n) {
      // DP solution
//    if (n < 1) return 0;
//    if (n == 1) return 1;
//    if (n == 2) return 2;
//    if (n == 3) return 4;
//
//    int[] ways = new int[] {1,2,4};
//
//    for (int i = 4; i < n; i++) {
//      int idx = (i - 1) % 3;
//      ways[idx] = ways[0] + ways[1] + ways[2];
//    }
//    return (int) ((ways[0] + ways[1] + ways[2]) % 10000000007l);
        // brute force solution, time didn't passed, reduce with DP.
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return stepPerms(n - 1) + stepPerms(n - 2) + stepPerms(n - 3);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int res = stepPerms(n);

            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

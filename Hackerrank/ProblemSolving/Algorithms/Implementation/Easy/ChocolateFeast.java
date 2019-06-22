import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find amount of chocolates that he can eat with intialy money and cost of c per chocolate, also exchange m wrapper to a new choclate
Input: three Integers n for total money, c cost per chocolate, m amount of wrapper to exchange a new chocolate
Output: a int for amount of chocolate he ate in total
*/
public class Solution {

    // Complete the chocolateFeast function below.
    static int chocolateFeast(int n, int c, int m) {
        int amount_chocolate = n / c;
        int count = 0;
        count += amount_chocolate;
        while(amount_chocolate >= m) {
            int changes = amount_chocolate/m;
            count += changes;
            amount_chocolate = amount_chocolate - (m * changes);
            amount_chocolate += changes;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] ncm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(ncm[0]);

            int c = Integer.parseInt(ncm[1]);

            int m = Integer.parseInt(ncm[2]);

            int result = chocolateFeast(n, c, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

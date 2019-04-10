import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
Task: Complete the arrayManipulation which it will add k amount from the range a to b
input: n q => n = size, q = cases of queries
       a b k => a b the index range, k the amount to add .
output: the highest value in the array
*/
// Better solution
/* Using Difference Array approach
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int queries = scanner.nextInt();
        long[] result = new long[n];
        for (int i = 0; i < queries; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            long k = scanner.nextLong();
            result[a - 1] = result[a - 1] + k;
            if (b < n) {
                result[b] = result[b] - k;
            }
        }
        long sum = 0;
        long max = 0;
        for (long i : result) {
            sum += i;
            if (sum > max) {
                max = sum;
            }
        }
        System.out.println(max);
        scanner.close();
    }
*/
public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    // brute force solution, passed all cases which not due to time complexity
    static long arrayManipulation(int n, int[][] queries) {
        long[] result = new long[n];
        for (int i = 0; i < n; i ++) {
            result[i] = 0;
        }
        for (int i = 0; i < queries.length; i ++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int add_amount = queries[i][2];
            for (int j = start - 1; j < end; j ++ ) {
                result[j] = result[j] + add_amount;
            }
        }
        long max =result[0];
        for (int i = 1; i < n; i++) {
            if (result[i] > max) {
                max = result[i];
            }
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: try to make all element in a array to even number, if you add one to a number, must add one to the front of the number or back of that number
Input: a int array b
Output: a String either no or the number of addtion we make
*/
public class FairRations {

    // Complete the fairRations function below.
    static String fairRations(int[] b) {
        int count = 0;
        if (b[0] % 2 == 1) {
            count += 2;
            b[0] += 1;
            b[1] += 1;
        }
        for (int i = 1; i < b.length - 1; i++) {
            if (b[i] % 2 == 1) {
                count += 2;
                b[i] = b[i] + 1;
                if (b[i - 1] % 2 == 1) {
                    b[i - 1] += 1;
                }
                else {
                    b[i + 1] += 1;
                }
            }
        }
        if (b[b.length - 1] % 2 == 1) {
            count += 2;
            b[b.length - 1] += 1;
            b[b.length - 2] += 1;
        }
        for (int i = 0; i < b.length; i++) {
            if (b[i] % 2 == 1) {
                return "NO";
            }
        }
        return Integer.toString(count);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] B = new int[N];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < N; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        String result = fairRations(B);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

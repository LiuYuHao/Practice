import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: start from 0, there are two possible adding rates. need to find all the possible next numbers given the int n
Input: three Integers n the index we need to predict, a and b are the different rates
Output: a int array where shows all the possible numbers
*/
public class ManasaAndStones {

    // Complete the stones function below.
    static int[] stones(int n, int a, int b) {
        int x = (n - 1) * a;
        HashSet<Integer> hs = new HashSet<>();
        hs.add(x);
        for (int i = 0; i < n - 1; i++) {
            x = x - a;
            x = x + b;
            hs.add(x);
        }
        int[] result = new int[hs.size()];
        int i = 0;
        for (int c : hs) {
            result[i++] = c;
        }
        Arrays.sort(result);
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int a = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int b = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = stones(n, a, b);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

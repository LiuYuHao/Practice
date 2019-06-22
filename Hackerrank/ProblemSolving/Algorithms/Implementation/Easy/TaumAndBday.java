import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find the min cost to buy b and w item with corresponding bc price and wc price, there is z price which can turn b to w or w to b
Input: 5 INTEGERs for amount of b, w and price of b and w and transfer z
Output: return a long for min price to buy 
*/
class Result {

    /*
     * Complete the 'taumBday' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER b
     *  2. INTEGER w
     *  3. INTEGER bc
     *  4. INTEGER wc
     *  5. INTEGER z
     */

    public static long taumBday(int b, int w, int bc, int wc, int z) {
        long b1 = (long) b;
        long w1 = (long) w;
        long bc1 = (long) bc;
        long wc1 = (long) wc;
        long z1 = (long) z;
    // Write your code here
        if (bc1 + z1 < wc1) {
            long answer = b1 * bc1 + ((bc1 + z1) * w1);
            return answer;
        }
        if (wc1 + z1 < bc1) {
            long answer = w1 * wc1 + ((wc1 + z1) * b1);
            return answer;
        }
        long answer = (w1 * wc1) + (b1 * bc1);
        return answer;
    }

}

public class TaumAndBday {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int b = Integer.parseInt(firstMultipleInput[0]);

            int w = Integer.parseInt(firstMultipleInput[1]);

            String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int bc = Integer.parseInt(secondMultipleInput[0]);

            int wc = Integer.parseInt(secondMultipleInput[1]);

            int z = Integer.parseInt(secondMultipleInput[2]);

            long result = Result.taumBday(b, w, bc, wc, z);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}

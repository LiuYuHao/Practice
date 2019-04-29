import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: Find the max subset of a array where any two element add together will not be divisible by int k
Input: a int k for target, and one Integer array
Output: a int for represents size of max subset that meet the condition
*/
public class NonDivisibleSubset {

    // Complete the nonDivisibleSubset function below.
    static int nonDivisibleSubset(int k, int[] S) {
        int max = 0;
        int[] s_module = new int[S.length];
        for (int i = 0; i < S.length; i++) {
            s_module[i] = S[i] % k;
        }
        // for (int x: s_module) {
        //     System.out.println(x);
        // }
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i = 0; i < s_module.length; i++) {
            tm.merge(s_module[i], 1, Integer::sum);
        }
        int[] frequencies = new int[k];
        for (Map.Entry<Integer,Integer> e: tm.entrySet()) {
            //System.out.println(e.getKey() + " " + e.getValue());
            frequencies[e.getKey()] = e.getValue();
        }
        if (k % 2 != 0) {
            for (int i = 1; i <= frequencies.length/2; i++) {
                //System.out.println(i + " " + (frequencies.length - i));
                if (frequencies[i] > frequencies[frequencies.length - i]) {
                    max += frequencies[i];
                }
                else {
                    max += frequencies[frequencies.length - i];
                }
            }
        }
        else {
            for (int i = 1; i < frequencies.length/2; i++) {
                //System.out.println(i + " " + (frequencies.length - i));
                if (frequencies[i] > frequencies[frequencies.length - i]) {
                    max += frequencies[i];
                }
                else {
                    max += frequencies[frequencies.length - i];
                }
            }
            if (frequencies[frequencies.length/2] != 0) {
                max += 1;
            }
        }
        if (frequencies[0] != 0) {
            max += 1;
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] S = new int[n];

        String[] SItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int SItem = Integer.parseInt(SItems[i]);
            S[i] = SItem;
        }

        int result = nonDivisibleSubset(k, S);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
/*
Task: find the superdigit of a number, superDigit = sum of all the single number until only one number left;
      e.g : 123123 => 12 = > 3.
Input: a string n for number, k = repeat amount therefore, 123 3 => 123123123
Output a int for superDigit
*/
    // Complete the superDigit function below.
    static int superDigit(String n, int k) {
        long sum = 0;
        for (int i = 0; i < n.length(); i++) {
            sum += Long.parseLong(n.substring(i, i +1));
        }
        sum = sum * k;
        if (n.length() == 1) {
            return Integer.parseInt(n);
        }
        return superDigit(Long.toString(sum),1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

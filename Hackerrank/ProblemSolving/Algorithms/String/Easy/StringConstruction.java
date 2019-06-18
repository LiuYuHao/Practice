import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find a the mini cost to construct the new string, add one character = 1 cost, if exist in the substring of new string = no cost
Input: a string s
Output: a int for cost
*/
public class StringConstruction {

    // Complete the stringConstruction function below.
    static int stringConstruction(String s) {
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            hs.add(s.charAt(i));
        }
        return hs.size();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = stringConstruction(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

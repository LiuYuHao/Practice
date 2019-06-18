import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find if the string s contains "hackerank" or not, the position doesn't matter as long as they are continuous mean
      position of a must bigger than position of h
Input: string s
output: a string yes or not to represent existance of hackerank
*/
public class HackerrankInString {

    // Complete the hackerrankInString function below.
    static String hackerrankInString(String s) {
        String answer = "hackerrank";
        int j = 0;
        if (s.length() < answer.length()) {
            return "NO";
        }
        for (int i = 0; i < s.length(); i++) {
            if (j < answer.length() && s.charAt(i) == answer.charAt(j)) {
                j++;
            }
            if (j == answer.length()) {
                return "YES";
            }
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = hackerrankInString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

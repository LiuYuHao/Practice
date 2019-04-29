import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: Encrypt the string by square root of the size and that is row and column where sqrt(size) <= row <= column. Then based on that
      rewritten the s into 3 x 4 and print vertically instead of horizontal
Input: a string s
Output: a string output represent message after 
*/
public class Encryption {

    // Complete the encryption function below.
    static String encryption(String s) {
        int row = (int)Math.sqrt(s.length());
        int column = row + 1;
        if (row * row == s.length()) {
            column = row;
        }
        String[] result = new String[column];
        for (int i = 0; i < column; i++) {
            String sentence = "";
            for (int j = i; j < s.length(); j+=column) {
                //System.out.println(j);
                sentence += s.charAt(j);
            }
            result[i] = sentence;
        }
        String answer = "";
        for (String x: result) {
            answer = answer + x + " ";
        }
        return answer;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

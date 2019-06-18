import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find the amount of change from input and original of repeat "SOS";
Input: a string s
Output: a output int to represent amount of changes
*/
public class MarsExploration {

    // Complete the marsExploration function below.
    static int marsExploration(String s) {
        int amount_of_sos = s.length() / 3;
        String orginal = "";
        for (int i = 0; i < amount_of_sos; i++) {
            orginal += "SOS";
        }
        int result = 0;
        for (int i = 0 ; i < s.length(); i++) {
            if (s.charAt(i) != orginal.charAt(i)) {
                result++;
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int result = marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

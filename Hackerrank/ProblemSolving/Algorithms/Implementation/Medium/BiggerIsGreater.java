import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: based on the lexicographical order, find the next greater word than original, and it must be the smallest word among all the bigger words
Input: A string W;
Output: A String shows the next smallest greater word, no answer if it is impossible (reverse order => already the biggest word)
*/
public class BiggerIsGreater {

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        int target = -1;
        for (int i = w.length() - 1; i > 0; i--) {
            if (w.charAt(i - 1) < w.charAt(i)) {
                target = i - 1;
                break;
            }
        }
        if (target == -1) {
            return "no answer";
        }
        int start = w.length() - 1;
        while (w.charAt(start) <= w.charAt(target)) {
            start--;
        }
        System.out.println(target);
        System.out.println(start);
        String w2 = w.substring(0, target) + w.charAt(start) + w.substring(target + 1, start) + w.charAt(target) + w.substring(start + 1, w.length());
        //System.out.println(w2);
        String reverse = "";
        for (int i = w2.length() - 1; i > target; i--) {
            reverse += w2.charAt(i);
        }
        String result = w2.substring(0, target) + w2.charAt(target) + reverse;
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

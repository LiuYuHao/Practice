import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: give a string array, "_" mean empty, we need to swap the element through the empty slot to make all element is adjecent to
      the one that is same ot it. a[i] = a[i - 1] or a[i + 1], find if it is possible or not to turn into that kind of string
Input: a string b
Output: a String return yes or not if it is match to condition or not.
*/
public class HappyLadybugs {

    // Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {
        if (b.length() == 1) {
            if (b.equals("_")) {
                return "YES";
            }
            else {
                return "NO";
            }
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < b.length(); i++) {
            hm.merge(b.charAt(i), 1, Integer::sum);
        }
        if (!hm.containsKey('_')) {
            if (b.charAt(0) != b.charAt(1)) {
                return "NO";
            }
            for (int i = 1; i < b.length() - 1; i++) {
                if (b.charAt(i) != b.charAt(i + 1) && b.charAt(i) != b.charAt(i - 1)) {
                    return "NO";
                }
            }
            if (b.charAt(b.length() - 1) != b.charAt(b.length() - 2)) {
                return "NO";
            }
            return "YES";
        }
        for (Map.Entry<Character, Integer> e : hm.entrySet()) {
            if (e.getValue() == 1 && e.getKey() != '_') {
                return "NO";
            }
        }
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String b = scanner.nextLine();

            String result = happyLadybugs(b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: check if a strings can be rearrange into a palindrome.
Input: a string s
Output: a String YES or NO
*/
public class GameOfThrones {

    // Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hm.containsKey(s.charAt(i))) {
                hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
            }
            else {
                hm.put(s.charAt(i), 1);
            }
        }
        int middle = 1;
        if (s.length() % 2 == 0) {
            middle = 0;
        }
        int count_odd = 0;
        for (Map.Entry<Character, Integer> e : hm.entrySet()) {
            if (e.getValue() % 2 != 0) {
                count_odd++;
            }
            if (count_odd > middle) {
                return "NO";
            }
        }
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

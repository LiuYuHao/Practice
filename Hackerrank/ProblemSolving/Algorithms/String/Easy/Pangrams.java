import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: check if a string contains every letters of alphabet
Input: a string s
Output: output a string not pangram or pangram based on the check
*/
public class Solution {

    // Complete the pangrams function below.
    static String pangrams(String s) {
        String lowers = "abcdefghijklmnopqrstuvwxyz";
        s = s.toLowerCase();
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < lowers.length(); i++) {
            hs.add(lowers.charAt(i));
        }
              //System.out.println(hs);
        for (int i = 0; i < s.length(); i++) {
            if (hs.contains(s.charAt(i))) {
                //System.out.println(s.charAt(i));
                hs.remove(s.charAt(i));
            }
        }
        if (hs.size() != 0) {
            return "not pangram";
        }
        else {
            return "pangram";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

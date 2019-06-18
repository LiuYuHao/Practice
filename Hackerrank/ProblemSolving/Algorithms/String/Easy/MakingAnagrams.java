import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find amount of characters remove from both strings which make they anagrams
Input: two strings s1 and s2
Output: a int for amount of character need to be removed
*/
public class Solution {

    // Complete the makingAnagrams function below.
    static int makingAnagrams(String s1, String s2) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int common = 0;
        for (int i = 0; i < s1.length(); i++) {
            hm.merge(s1.charAt(i), 1, Integer::sum);
        }
        for (int i = 0; i < s2.length(); i++) {
            if (hm.containsKey(s2.charAt(i))) {
                common++;
                hm.put(s2.charAt(i), hm.get(s2.charAt(i)) -1);
                if (hm.get(s2.charAt(i)) == 0) {
                    hm.remove(s2.charAt(i));
                }
            }
        }
        return (s1.length() - common) + (s2.length() - common);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: split a string s such two substring are equal and find the mini changes required for them to become anagram
Input: a string s
Output: a int for mini change, -1 for impossible to make substrings to anagram
*/
public class Solution {

    // Complete the anagram function below.
    static int anagram(String s) {
        if (s.length() % 2 == 1) {
            return -1;
        }
        String upperhalf = s.substring(0, s.length()/2);
        String lowerhalf = s.substring(s.length()/2, s.length());
        System.out.println(upperhalf + " " + lowerhalf);
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < upperhalf.length(); i++) {
            hm.merge(upperhalf.charAt(i),1,Integer::sum);
        }
        int count = 0;
        for (int i = 0; i < lowerhalf.length(); i++) {
            if (hm.containsKey(lowerhalf.charAt(i))) {
                hm.put(lowerhalf.charAt(i), hm.get(lowerhalf.charAt(i)) - 1);
                if (hm.get(lowerhalf.charAt(i)) == 0) {
                    hm.remove(lowerhalf.charAt(i));
                }
            }
            else {
                count++;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

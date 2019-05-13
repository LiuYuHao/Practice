import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: delete the Character from both string, therefore => they are anagram
Input: two string a, b
Output: a Integer to represent how many times of delettions
*/
public class MakingAnagram {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        HashMap<Character, Integer> hm_a = new HashMap<>();
        HashMap<Character, Integer> hm_b = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            hm_a.merge(a.charAt(i),1,Integer::sum);
        }
        for (int i = 0; i < b.length(); i++) {
            hm_b.merge(b.charAt(i),1,Integer::sum);
        }
        int delete = 0;
        for (Map.Entry<Character, Integer> e : hm_a.entrySet()) {
            if (hm_b.containsKey(e.getKey())) {
                if (e.getValue() >= hm_b.get(e.getKey())) {
                    delete = delete + (e.getValue() - hm_b.get(e.getKey()));
                }
            }
            else {
                delete += e.getValue();
            }
        }
        for (Map.Entry<Character, Integer> e : hm_b.entrySet()) {
            if (hm_a.containsKey(e.getKey())) {
                if (e.getValue() >= hm_a.get(e.getKey())) {
                    delete = delete + (e.getValue() - hm_a.get(e.getKey()));
                }
            }
            else {
                delete += e.getValue();
            }
        }
        return delete;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

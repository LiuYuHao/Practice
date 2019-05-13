import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
// repeated ProblemSolving/Algorithmns/String/Medium
/*
Task: A string is valid if all the character frequencies are equals, it is valid also when you are able to delete one character(frequency) and
      match the conditions
Input: a string s
Ouput: YES for valid and NO for invalid
*/
public class SherlockValidString {

    // Complete the isValid function below.
    static String isValid(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hm.merge(s.charAt(i), 1, Integer::sum);
        }
        int frequency = -1;
        HashMap<Integer, Integer> f_map = new HashMap<>();
        for (Map.Entry<Character, Integer> e : hm.entrySet()) {
            f_map.merge(e.getValue(), 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> e : f_map.entrySet()) {
            if (e.getValue() > frequency) {
                frequency = e.getKey();
            }
        }
        HashMap<Character, Integer> sub_hmA = new HashMap<>();
        HashMap<Character, Integer> sub_hmB = new HashMap<>();
        char c_b = '?';
        char c_a = '?';
        for (Map.Entry<Character, Integer> e : hm.entrySet()) {
            if (e.getValue() != frequency) {
                sub_hmB.put(e.getKey(), e.getValue());
                c_b = e.getKey();
            }
            else {
                sub_hmA.put(e.getKey(), e.getValue());
                c_a = e.getKey();
            }
        }
        //System.out.println(sub_hmA);
        //System.out.println(sub_hmB);
        if (sub_hmB.size() > 1) {
            return "NO";
        }
        else if (sub_hmB.size() == 1) {
            if (sub_hmB.get(c_b) - 1 == sub_hmA.get(c_a)) {
                return "YES";
            }
            else if (sub_hmB.get(c_b) - 1 == 0) {
                return "YES";
            }
            else {
                return "NO";
            }
        }
        else {
            return "YES";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

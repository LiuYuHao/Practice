import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: encrypt the string by shift the position based on the alphabet
Input: string s and a int k for amount of rotation
Output: return a entryted string 
*/
public class CaesarCipher {

    // Complete the caesarCipher function below.
    static String caesarCipher(String s, int k) {
        String characters ="abcdefghijklmnopqrstuvwxyz";
        String upper = characters.toUpperCase();
        HashMap<Character, Integer> hm  = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        for (int i = 0; i < characters.length(); i++) {
            hm.put(characters.charAt(i),i);
            hm2.put(upper.charAt(i),i);
        }
        String result = "";
        boolean check_uppercase = false;
        for (int i = 0; i < s.length(); i++) {
            if (hm.containsKey(s.charAt(i))) {
                int position = hm.get(s.charAt(i));
                if (position + (k % 26) > 25) {
                    position = position + (k % 26) - 26;
                    result += characters.charAt(position);
                }
                else {
                    result += characters.charAt(position + (k % 26));
                }
            }
            else if (hm2.containsKey(s.charAt(i))) {
                int position = hm2.get(s.charAt(i));
                if (position + (k % 26) > 25) {
                    position = position + (k % 26) - 26;
                    result += upper.charAt(position);
                }
                else {
                    result += upper.charAt(position + (k % 26));
                }
            }
            else {
                result += s.charAt(i);
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

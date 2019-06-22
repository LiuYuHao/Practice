import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find the area of highlighted word based on the height of given each characters
Input: a string word and a int h for height of each characters
Output: a int for area of word
*/
public class DesignerPdfViewer {

    // Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < h.length; i++) {
            hm.put(characters.charAt(i), h[i]);
        }
        int max = hm.get(word.charAt(0));
        for (int i = 1; i < word.length(); i++) {
            if (hm.get(word.charAt(i)) > max) {
                max = hm.get(word.charAt(i));
            }
        }
        return max * word.length();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[] h = new int[26];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 26; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        String word = scanner.nextLine();

        int result = designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

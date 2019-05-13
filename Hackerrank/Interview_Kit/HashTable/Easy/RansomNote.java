import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: Harold wants to use words in the magazine to create his ransom note. Therefore, he only can creates the note where the words
      are showing in the magazine
Input: a string array named magazine contained the words of magazine and one string array named note contained the words that he wanted
Output: return Yes if he can make ransomNote, no if he cannot
*/
public class RansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> hm = new HashMap<>();
        HashMap<String, Integer> hm2 = new HashMap<>();
        for (int i = 0; i < magazine.length; i++) {
            hm.merge(magazine[i], 1, Integer::sum);
        }
        for (int i = 0; i < note.length; i++) {
            hm2.merge(note[i], 1, Integer::sum);
        }
        for (Map.Entry<String, Integer> e : hm2.entrySet()) {
            if (!hm.containsKey(e.getKey()) || hm.get(e.getKey()) < e.getValue()) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}

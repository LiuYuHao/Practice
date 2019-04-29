import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find all the pair of substring of a string where they (pair) are anagrams
Input: a string s
Output: a total amount of pair of anagrams substrings
*/
public class SherlockAnagrams {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        ArrayList<String> al = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                //System.out.println(s.substring(i,j));
                al.add(s.substring(i,j));
            }
        }
        ArrayList<HashMap<Character, Integer>> m_al = new ArrayList<>();
        for (int i = 0; i < al.size(); i++) {
            HashMap<Character, Integer> hm = new HashMap<>();
            for (int j = 0; j < al.get(i).length(); j++) {
                hm.merge(al.get(i).charAt(j), 1, Integer::sum);
            }
            m_al.add(hm);
        }
        int count = 0;
        for (int i = 0; i < m_al.size(); i++) {
            for (int j = i + 1; j < m_al.size(); j++) {
                if (m_al.get(i).equals(m_al.get(j))) {
                    count++;
                }
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

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

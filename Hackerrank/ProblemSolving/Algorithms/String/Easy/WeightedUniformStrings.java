import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: each character has their worn weight, uniform string means when the substring is contains the same characters. Therefore, check if the weight in
      the queries matches to one of the sum(weight) of uniform substring of input
Input: a string and a int array for contains queries
Output: a string array contains the answer corresponding to the queries
*/
public class Solution {

    // Complete the weightedUniformStrings function below.
    static String[] weightedUniformStrings(String s, int[] queries) {
        HashSet<Integer> hs = new HashSet<>();
        String characters = "abcdefghijklmnopqrstuvwxyz";
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < characters.length(); i++) {
            hm.put(characters.charAt(i),i);
        }
        int weight = 0;
        for (int i = 0; i < s.length(); i++) {
            weight += hm.get(s.charAt(i)) + 1;
            hs.add(weight);
            if (i + 1 < s.length() && s.charAt(i) != s.charAt(i + 1)) {
                weight = 0;
            }
        }

        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (hs.contains(queries[i])) {
                result[i] = "Yes";
            }
            else {
                result[i] = "No";
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

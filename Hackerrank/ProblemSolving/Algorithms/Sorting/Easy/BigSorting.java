import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: Sort the given unsorted string array with big Integer
Input: a string array (string is contains Integer)
Output: a string array where is sorted
*/
public class BigSorting {

    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {
        Arrays.sort(unsorted, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.length() != b.length()) {
                    return a.length() - b.length();
                }
                for (int i = 0; i < a.length(); i++) {
                    char a1 = a.charAt(i);
                    char b1 = b.charAt(i);
                    if (a1 != b1) {
                        return a1 - b1;
                    }
                }
                return 0;
            }
        });
        return unsorted;
    }

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(reader.readLine());

        String[] unsorted = new String[n];

        for (int i = 0; i < n; i++) {
            String unsortedItem = reader.readLine();
            unsorted[i] = unsortedItem;
        }

        String[] result = bigSorting(unsorted);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
        reader.close();
    }
}

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find the amount of characters that apear in each string in the arrray
Input: a string array
Output: a int represent amount of characters appear in all strings
*/
public class Gemstones {

    // Complete the gemstones function below.
    static int gemstones(String[] arr) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr[0].length(); i++) {
            hm.put(arr[0].charAt(i), 1);
        }
        for (int i = 1; i < arr.length; i++) {
            HashMap<Character, Integer> hm2 = new HashMap<>();
            for (int j = 0; j < arr[i].length(); j++) {
                if (hm.containsKey(arr[i].charAt(j))) {
                    hm2.put(arr[i].charAt(j), 1);
                }
            }
            hm = hm2;
        }
        return hm.size();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String arrItem = scanner.nextLine();
            arr[i] = arrItem;
        }

        int result = gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

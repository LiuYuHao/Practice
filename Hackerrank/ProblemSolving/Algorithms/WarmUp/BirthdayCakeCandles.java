import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find the amount of highest value in a array
Input: a array
output: amount of highest value in the array
*/
public class BirthdayCakeCandles {

    // Complete the birthdayCakeCandles function below.
    static int birthdayCakeCandles(int[] ar) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < ar.length; i++) {
            if (!map.containsKey(ar[i])) {
                map.put(ar[i], 1);
            }
            else {
                map.put(ar[i], map.get(ar[i]) + 1);
            }
        }
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
        }
        return map.get(map.lastKey());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = birthdayCakeCandles(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

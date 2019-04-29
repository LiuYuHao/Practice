import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find the pair in a int array where the difference is equal to target
Input: a target Integer and one int array
Output: a int for amount of pairs
*/
class Pair {
    public int x;
    public int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object c) {
        if (this == c) {
            return true;
        }
        else if (!(c instanceof Pair)) {
            return false;
        }
        else {
            Pair p = (Pair) c;
            return (this.x == p.x || this.x == p.y) && (this.y == p.x || this.y == p.y);
        }
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(this.x) * Integer.hashCode(this.y);
    }
}
public class Pair {

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashMap<Pair, Pair> result = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) {
                int difference = k + arr[i];
                if (hm.containsKey(difference)) {
                    result.put(new Pair(arr[i], difference), new Pair(arr[i], difference));
                }
            }
            else if (arr[i] > k) {
                int difference = arr[i] - k;
                if (hm.containsKey(difference)) {
                    result.put(new Pair(arr[i], difference), new Pair(arr[i], difference));
                }
            }
        }
        //System.out.println(result);
        return result.size();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

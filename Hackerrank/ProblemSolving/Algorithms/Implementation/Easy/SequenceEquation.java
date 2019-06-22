import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: give a array where contains int, find  x= 1 find y such p(p(y)) = x, if x = 1, p(x) = 3, p(3) = 2, return 2. p(p(2)) = > p(3) => 1
Input: a int array
Output: a int array that match from the order 1 to n(size of input array)
*/
public class SequenceEquation {

    // Complete the permutationEquation function below.
    static int[] permutationEquation(int[] p) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < p.length; i++) {
            hm.put(Integer.toString(p[i]), i + 1);
        }
        int[] result = new int[p.length];
        for (int i = 1; i <= p.length; i++) {
            int index = hm.get(Integer.toString(i));
            String str = Integer.toString(index);
            result[i - 1] = hm.get(str);
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        int[] result = permutationEquation(p);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

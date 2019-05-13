import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: 0 = safe, 1 = dangerous, jump 1 or 2 index, print the min jumps to the end. first and last index = 0.
      there always can win the game
Input: a int named contains 0 or 1
Output: return a Integer where shows the min jumps amount
*/
public class JumpingOnTheClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int index = 0;
        int count = 0;
        while(index < c.length) {
            if (index + 2 < c.length && c[index + 2] == 0) {
                index = index + 2;
                count++;
            }
            else if (index + 1 < c.length && c[index + 1] == 0) {
                index = index + 1;
                count++;
            }
            else {
                break;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

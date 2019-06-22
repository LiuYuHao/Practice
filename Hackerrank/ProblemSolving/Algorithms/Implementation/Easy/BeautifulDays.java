import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find the beautifulDays which it is the day where minus it's reverse and divisble given int k
Input: three integers i , j, k => startday, endday and k
Output: a int for amount of beautifulDays in the range
*/
public class Solution {

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        int count = 0;
        for (int start = i; start <= j; start++) {
            String str = Integer.toString(start);
            String reverse = "";
            for (int r = str.length() - 1; r > -1; r--) {
                reverse += str.charAt(r);
            }
            int x = Integer.parseInt(reverse);
            int difference = start - x;
            if (difference % k == 0) {
                count++;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

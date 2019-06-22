import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: passing candy to each prisoner. Print the last one prisoner, in a cycle
Input: three Integers n, m, s => amount of prisoner, amount of candies, the start prisoner
Output: a int for last prisoner position
*/
public class SaveThePrisoner {

    // Complete the saveThePrisoner function below.
    static int saveThePrisoner(int n, int m, int s) {
        int remaining = m % n;
        s = s - 1;
        while(remaining != 0) {
            s++;
            remaining--;
            if (s > n) {
                s = 1;
            }
        }
        if (s == 0) {
            s = n;
        }
        return s;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nms = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nms[0]);

            int m = Integer.parseInt(nms[1]);

            int s = Integer.parseInt(nms[2]);

            int result = saveThePrisoner(n, m, s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

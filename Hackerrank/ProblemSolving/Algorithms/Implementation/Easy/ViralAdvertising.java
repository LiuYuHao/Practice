import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find amount of people that will like the ad based on given day. The pattern is begin with 5, half of them will like it and share to 3
      their friends -> 6 people will get the ad and 3 will like it (half of 6) and continue...
Input: a int n for day
Output: a int for amount of people will like it
*/
public class ViralAdvertising {

    // Complete the viralAdvertising function below.
    static int viralAdvertising(int n) {
        int start_people = 5;
        int amount_people_like = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            amount_people_like = start_people/2;
            sum += amount_people_like;
            start_people = amount_people_like * 3;
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

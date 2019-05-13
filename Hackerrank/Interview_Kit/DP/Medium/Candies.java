import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: teacher give students candies, everyone will get one, the student that sit together, the higher score get more.
Input: a int n and one int array, size and score of students
Output: a long variable for min candies that teacher need to buy
*/
public class Candies {

    // Complete the candies function below.
    static long candies(int n, int[] arr) {
        int[] c = new int[arr.length];
        c[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                c[i] = c[i - 1]  + 1;
            }
            else {
                c[i] = 1;
            }
        }
        for (int i = arr.length - 2; i > -1;i--) {
            if (arr[i] > arr[i + 1]) {
                c[i] = c[i + 1] + 1 > c[i] ? c[i + 1] + 1 : c[i];
            }
        }
        long sum = 0;
        for (int x : c) {
            System.out.println(x);
            sum += x;
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

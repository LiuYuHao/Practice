import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: a number is kaprekarnumber (modified version) a number * number and seperate into two number and add together equal to original number
Input: two integers q and p for the range inclusive
Output: system.out.print for the answer, if there has then print it seperate by " " else print (INVALID RANGE)
*/
public class ModifiedKaprekarNumbers {

    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {
        int count = 0;
        for (int i = p; i <= q; i++) {
            long i2 = (long) i;
            long sqr = i2 * i2;
            String s = Long.toString(sqr);
            if (s.length() == 1) {
                if (Long.parseLong(s) == i2) {
                    count++;
                    System.out.print(i2 + " ");
                }
                continue;
            }
            String upper = s.substring(0, s.length()/2);
            String lower = s.substring(s.length()/2);
            long u = Long.parseLong(upper);
            long l = Long.parseLong(lower);
            if ((u + l) == i2) {
                count++;
                System.out.print(i2 + " ");
            }
        }
        if (count == 0) {
            System.out.println("INVALID RANGE");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}

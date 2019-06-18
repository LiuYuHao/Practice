import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find the pattern where the next number is greater 1 than previous number in a string
Input: A string s
Output: System out println for output, yes and the start number or no 
*/
public class Solution {

    // Complete the separateNumbers function below.
    static void separateNumbers(String s) {
        String start = "";
        if (s.charAt(0) == '0' || s.length() == 1) {
            System.out.println("NO");
            return;
        }
        for (int i = 0; i < s.length()/2; i++) {
            String possible_start = start + s.charAt(i);
            //System.out.println(possible_start);
            long x = Long.parseLong(possible_start);
            x = x + 1;
            String possible_next = Long.toString(x);
            start = possible_start;
            if (possible_next.equals(s.substring(i + 1, i + 1 + possible_next.length()))) {
                String starting = start;
                int j = starting.length() - 1;
                while (j < s.length()) {
                    //System.out.println(start);
                    long y = Long.parseLong(starting);
                    y = y + 1;
                    String next = Long.toString(y);
                    //System.out.println(next);
                    if (j == s.length() - 1) {
                        System.out.print("YES ");
                        System.out.println(start);
                        return;
                    }
                    if (j + 1 + next.length() > s.length()) {
                        break;
                    }
                    if (!next.equals(s.substring(j + 1, j + 1 + next.length()))) {
                        break;
                    }
                    j = j + next.length();
                    starting = next;
                }

            }
        }
        System.out.println("NO");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            separateNumbers(s);
        }

        scanner.close();
    }
}

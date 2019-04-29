import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: print starcase based on the input n;
Input: a Integer n;
Output: n-1 space    #
        n-2 space   ##
        .....
        ....
        #############
*/
public class StairCase {

    // Complete the staircase function below.
    static void staircase(int n) {
        int range = n - 1;
        for (int i = 0; i < n; i++) {
            String s = "";
            for (int j = 0; j < n; j++) {
                if (j >= range) {
                    s += "#";
                }
                else {
                    s += " ";
                }
            }
            range--;
            System.out.println(s);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}

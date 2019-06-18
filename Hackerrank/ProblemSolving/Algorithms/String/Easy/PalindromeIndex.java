import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find the index where remove it will make the string become palindrome
Input: a string s.
Output: a int where shows which index to remove to make the string palindrome or -1 for representing it is palindrome or impossible
*/
public class Solution {

    // Complete the palindromeIndex function below.
    static boolean check_palindrome1(String s, int index) {
        for (int i = 0, j = s.length() - 1; i < j;) {
            if (i == index) {
                i++;
            }
            else if (j == index) {
                j--;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            else {
                i++;
                j--;
            }
        }
        return true;
    }
    static int palindromeIndex(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--)  {
            if (s.charAt(i) != s.charAt(j)) {
                if (check_palindrome1(s,i)) {
                    return i;
                }
                if (check_palindrome1(s,j)) {
                    return j;
                }
            }
        }
        return -1;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = palindromeIndex(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

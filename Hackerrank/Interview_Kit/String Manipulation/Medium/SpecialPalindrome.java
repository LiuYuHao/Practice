
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: Special palindrome mean all character are the same or except the middle is different others are the same.
      find how many substring in the string are palindrome
Input: a int n = size of string, a string s
Output: a integer where is shows amonut of Special palindrome as a substring of input s
*/
public class SpecialPalindrome {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        int count  = 0;
        String temp = String.valueOf(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (temp.charAt(temp.length() - 1) == s.charAt(i)) {
                temp += String.valueOf(s.charAt(i));
                //System.out.println(temp);
            }
            else {
                count += (temp.length() * (temp.length() + 1)) / 2;
                for (int j = 0; j < temp.length(); j++) {
                    if (i + 1 + j >= s.length()) {
                        break;
                    }
                    else if (s.charAt(i + 1 + j) != temp.charAt(temp.length() - 1)) {
                        break;
                    }
                    else {
                        count++;
                    }
                }
                temp = String.valueOf(s.charAt(i));
            }
            if (i == s.length() - 1) {
                count += (temp.length() * (temp.length() + 1)) / 2;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

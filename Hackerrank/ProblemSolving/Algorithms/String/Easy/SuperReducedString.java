import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: reduce the string by removing the pairs of adjacents which are the same characters.
Input: a string s
Output: a string if empty return empty string, is not return the reduced string
*/
public class SuperReducedString {

    // Complete the superReducedString function below.
    static String superReducedString(String s) {
        if (s.length() == 1) {
            return s;
        }

        while(s.length() != 0) {
            String temp = "";
            for (int i = 0; i < s.length();) {
                if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                    i = i + 2;
                }
                else {
                    temp += s.charAt(i);
                    i = i + 1;
                }
            }
            if (temp.equals(s)) {
                return temp;
            }
            s = temp;
        }
        return "Empty String";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

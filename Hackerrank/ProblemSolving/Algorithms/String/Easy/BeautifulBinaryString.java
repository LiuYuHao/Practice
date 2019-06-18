import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find amount of change needs to make a string beautiful => no "010";
Input: a String b
Output: a int for amount of change needed
*/
public class BeautifulBinaryString {

    // Complete the beautifulBinaryString function below.
    static int beautifulBinaryString(String b) {
        int count = 0;
        String start = b.substring(0,3);
        for (int i = 3; i < b.length();) {
            System.out.println(start + " " + count);
            if (start.equals("010")) {
                if (i + 3 > b.length()) {
                    break;
                }
                count++;
                start = b.substring(i, i + 3);
                i = i + 3;
            }
            else {
                start = start.substring(1,3);
                start += b.charAt(i);
                i++;
            }
        }
        if (start.equals("010")) {
            count++;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String b = scanner.nextLine();

        int result = beautifulBinaryString(b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: Convert the time to words
      15, 45 => quarter
      passed 30 => min to the next hour. such as 5 45 => quarter to 6
      lessed 30 => pass of current hour. such as 5 15 => quarter pass 5
      if m = 1, unit should be minute
Input: int h => hour, int m => min
Output: a String for represent the h and m in words
*/
public class TheTimeInWords {

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        String[] numbers = new String[]{"one", "two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","quarter","sixteen","seventeen", "eighteen", "nineteen","twenty"};
        if (m == 0) {
            return numbers[h - 1] + " o' clock";
        }
        else {
            String min = "";
            String unit = "minutes";
            String p_t = "past";
            String hour = numbers[h - 1];

            if (m < 30) {
                if (m == 1) {
                    min = numbers[0];
                    unit = "minute";
                    return min + " " + unit + " " + p_t + " " + hour;
                }
                else if (m == 15) {
                    min = numbers[m - 1];
                    return min + " " + p_t + " " + hour;
                }
                else if (m > 20) {
                    min = numbers[19];
                    String min2 = numbers[m - 20 - 1];
                    return min + " " + min2 + " " + unit + " " + p_t + " " + hour;
                }
                else {
                    min = numbers[m - 1];
                    hour = numbers[h - 1];
                    return min + " " + unit + " " + p_t + " " + hour;
                }
            }
            else if (m == 30) {
                return "half " + p_t + " " + hour;
            }
            else if (m > 30) {
                hour = numbers[h];
                p_t = "to";
                if (60 - m > 20) {
                    min = numbers[19];
                    String min2 = numbers[60 - m - 21];
                    return min + " " + min2 + " " + unit + " " + p_t + " " + hour;
                }
                else if (m == 45) {
                    min = numbers[14];
                    return min + " " + p_t + " " + hour;
                }
                else {
                    min = numbers[60 - m - 1];
                    hour = numbers[h];
                    return min + " " + unit + " " + p_t + " " + hour;
                }
            }
        }
        return "";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

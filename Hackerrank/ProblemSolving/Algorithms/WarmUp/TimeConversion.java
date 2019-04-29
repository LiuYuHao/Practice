import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
/*
Task: convert 12-hour to 24-hour
Input: a string of 12 hour
Output: a string of 24 hour
*/
public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        String s_hour = s.substring(0,2);
        String am_pm = s.substring(s.length() -2 ,s.length());
        int hour = Integer.parseInt(s_hour);
        if (am_pm.equals("PM")) {
            if (hour != 12) {
                hour = hour + 12;
            }
            s_hour = Integer.toString(hour);
            s = s.substring(2, s.length() - 2);
            return s_hour + s;

        }
        else if (hour == 12) {
            s_hour = "00";
            s = s.substring(2, s.length() - 2);
            return s_hour + s;
        }
        else {
            s = s.substring(0, s.length() - 2);
            return s;
        }
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}

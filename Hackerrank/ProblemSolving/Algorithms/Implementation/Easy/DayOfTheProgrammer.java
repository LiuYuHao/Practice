import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
/*
Task: 256th day is DayOfProgrammer cuz (2^8), 1918 is transition from Julian to gregorian, therefore the day after January 31 is Feb 14.
      before it was follow julian, after 2018 is gregorian
Input: A int for represent the year
Output: A string format as dd.mm.yyyy indicated the 256th year
*/
public class DayOfProgrammer {

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        String dd = "";
        String mm = "09";
        String yy = Integer.toString(year);
        if (year % 4 == 0 && year % 100 != 0) {
            dd = "12";
        }
        else if (year % 100 == 0 && year % 400 == 0) {
            dd = "12";
        }
        else {
            dd = "13";
        }
        if (year < 1919) {
            if (year % 4 == 0) {
                dd = "12";
            }
            else {
                dd = "13";
            }
        }
        if (year == 1918) {
            dd = "26";
        }
        return dd + "." + mm + "." + yy;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

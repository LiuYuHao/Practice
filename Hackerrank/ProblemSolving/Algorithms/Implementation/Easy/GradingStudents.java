import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
/*
Task: round the grade based on the rule: the difference between grade and next multiple  of 5 less than 3 then round to next multiple  of 5
      if the result of round is less than 40, stay the same.
Input: a array contained scores
Output: a array contined rounded scores
*/
public class gradingStudents {

    /*
     * Complete the gradingStudents function below.
     */
    static int[] gradingStudents(int[] grades) {
        /*
         * Write your code here.
         */
        int[] result = new int[grades.length];
        for (int i = 0; i < grades.length; i++) {
            int grade = 0;
            if (grades[i] % 5 == 3) {
                grade = grades[i] + 2;
            }
            else if (grades[i] % 5 == 4) {
                grade = grades[i] + 1;
            }
            else {
                grade = grades[i];
            }
            if (grade < 40) {
                result[i] = grades[i];
            }
            else {
                result[i] = grade;
            }
        }
        return result;

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scan.nextLine().trim());

        int[] grades = new int[n];

        for (int gradesItr = 0; gradesItr < n; gradesItr++) {
            int gradesItem = Integer.parseInt(scan.nextLine().trim());
            grades[gradesItr] = gradesItem;
        }

        int[] result = gradingStudents(grades);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bw.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();

        bw.close();
    }
}

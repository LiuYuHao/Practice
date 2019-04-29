import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
/*
Task: fliping the page of book, count how many flip u need to get the target page, first page always alone in starting page, then 2 3, ...
      if total 5 pages, the last page contained 4 5, if 6 pages, the last page contained 6 only
Input: a Integer n for total amount of pages in the book, p = targe
Output: a int for how many filping
*/
public class DrawingBook {

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        /*
         * Write your code here.
         */
        if (p == 1 || p == n) {
            return 0;
        }
        int front = (int)p/2;
        int back;
        if (n % 2 == 0) {
            back = (n + 1 - p)/2;
        }
        else {
            back = (n - p)/2;
        }
        return Math.min(front, back);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

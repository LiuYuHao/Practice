import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: every chapter has amount of question, every page cotains max questions(except the last page), find the amount of pages where there has
      page number question it. Example page 1 has question 1 of any chapter... or Chapter 5 contains question 5 of any chapter
Input: two inters n and k, for amount of chapter and amount of questino on each page. A int array for amount of question of each chapter(index)
Output: a int for amount of pages where contained the question corresponding to his page number.
*/
public class LisaWorkBook {

    // Complete the workbook function below.
    static int workbook(int n, int k, int[] arr) {
        int count = 0;
        int page = 1;
        int start = 1;
        for (int i = 1; i <= n; page++) {
            int end = start + k - 1;
            int amount = arr[i - 1];
            if (end < amount) {
                if (page >= start && page <= end) {
                    count++;
                }
                start = end + 1;
            }
            else {
                end = amount;
                if (page >= start && page <= end) {
                    count++;
                }
                i++;
                start = 1;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = workbook(n, k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find the total area of a 3d matrix;
Input: a 2d array, where row and column is x and y, the element inside of each position = the height(z);
Ouput: return the total surfaceArea
*/
public class ThreeDSurfaceArea {

    // Complete the surfaceArea function below.
    static int surfaceArea(int[][] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                sum += (A[i][j] * 4) + 2;
                if (j - 1  > -1) {
                    sum -= Math.min(A[i][j-1], A[i][j]);
                }
                if (j + 1 < A[i].length) {
                    sum -= Math.min(A[i][j+1], A[i][j]);
                }
                if (i + 1 < A.length) {
                    sum -= Math.min(A[i + 1][j], A[i][j]);
                }
                if (i - 1 > - 1) {
                    sum -= Math.min(A[i - 1][j], A[i][j]);
                }
            }
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] HW = scanner.nextLine().split(" ");

        int H = Integer.parseInt(HW[0]);

        int W = Integer.parseInt(HW[1]);

        int[][] A = new int[H][W];

        for (int i = 0; i < H; i++) {
            String[] ARowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < W; j++) {
                int AItem = Integer.parseInt(ARowItems[j]);
                A[i][j] = AItem;
            }
        }

        int result = surfaceArea(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

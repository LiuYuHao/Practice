import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
//REDO --- The algorthmn that I found out is not working
public class ConnectedCells {
    // Completed, no internet for now, check later
    // Complete the connectedCell function below.
    static int connectedCell(int[][] matrix) {
        int max = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    if (j - 1 > -1 && matrix[i][j - 1] != 0) {
                        matrix[i][j] = matrix[i][j - 1];
                    }
                    else {
                        if (i != 0) {
                            int above = matrix[i - 1][j];
                            if (j - 1 > - 1) {
                                above = Math.max(above, matrix[i - 1][j - 1]);
                            }
                            if (j + 1 < matrix[i - 1].length) {
                              above = Math.max(above, matrix[i - 1][j + 1]);
                            }
                            matrix[i][j] += above;

                        }
                        for (int k = j + 1; k < matrix[i].length; k++) {
                            if (matrix[i][k] == 1) {
                                matrix[i][j] += 1;
                            }
                            else {
                                break;
                            }
                        }
                        if (matrix[i][j] > max) {
                            max = matrix[i][j];
                        }
                    }
                }
            }
        }
        for (int[] x : matrix) {
          for (int y : x) {
            System.out.print(y + " ");
          }
          System.out.println(" ");
        }
        System.out.println(max);
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] matrixRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int matrixItem = Integer.parseInt(matrixRowItems[j]);
                matrix[i][j] = matrixItem;
            }
        }

        int result = connectedCell(matrix);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}

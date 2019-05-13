import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
// Repeated Challenge - In Java/DataStructure/easy
/*
Task: find the max hourglass in 6x6;
input: a matrix 6x6
output: the maximum hourglass inside of the matrix
*/
public class TwoDArray {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        scanner.close();
        // solve the first hourglass as our base comparetor
        int result = arr[0][0] + arr[0][1] + arr[0][2] + arr[1][1] + arr[2][0] + arr[2][1] + arr[2][2];
        // the sum
        int sum = 0;
        // loop the matrix, ignore the last two row and two collumn since they are impossible to have a hourglass
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //  sum of hourglass
                sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j]+arr[i+2][j+1] + arr[i+2][j+2];
                // comare to the result
                if (sum > result) {
                  // assign to result if sum is bigger
                    result = sum;
                }
            }
        }
        System.out.println(result);
    }
}

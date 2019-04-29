import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: giving a 3x3 matrix => fix it to magic squre by use less count (the abs difference between the original number and change)
Input: a array 3x3
Output: output a int where represent the min count
*/
public class MagicSqure {

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        int[][] fixed_faces = {
            {2,7,6,9,5,1,4,3,8},
            {6,7,2,1,5,9,8,3,4},
            {4,9,2,3,5,7,8,1,6},
            {2,9,4,7,5,3,6,1,8},
            {8,3,4,1,5,9,6,7,2},
            {4,3,8,9,5,1,2,7,6},
            {6,1,8,7,5,3,2,9,4},
            {8,1,6,3,5,7,4,9,2},
        };
        ArrayList<Integer> al = new ArrayList<>();
        int[] result = new int[8];
        for (int i = 0; i < 3; i++) {
            al.add(s[i][0]);
            al.add(s[i][1]);
            al.add(s[i][2]);
        }
        // for (Integer x: al) {
        //     System.out.println(x);
        // }
        for (int j = 0; j < al.size(); j++) {
            for (int i = 0; i < 8; i++) {
                result[i] = result[i] + Math.abs(al.get(j) - fixed_faces[i][j]);
            }
        }
        Arrays.sort(result);
        return result[0];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

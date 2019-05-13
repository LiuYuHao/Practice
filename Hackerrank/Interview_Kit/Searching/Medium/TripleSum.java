import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find all the triple where (a,b,c ) => b >= a and c >= a
Input: three int arrays a b c where contained the element of corresponding postion
Output: a long for representing amount of triple
*/
public class TripleSum {

    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
        long total = 0;
        long a_count = 0;
        long c_count = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        for (int i = 0, j = 0, k = 0; i < b.length; i++) {
            if (i != 0 && b[i] == b[i - 1]) {
                continue;
            }
            for (; j < a.length; j++) {
                if (j != 0 && a[j] == a[j - 1]) {
                    continue;
                }
                if (a[j] <= b[i]) {
                    a_count++;
                }
                else {
                    break;
                }
            }
            for (; k < c.length; k++) {
                if (k != 0 && c[k] == c[k - 1]) {
                    continue;
                }
                if (c[k] <= b[i]) {
                    c_count++;
                }
                else {
                    break;
                }
            }
            total += a_count * c_count;
        }
        return total;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

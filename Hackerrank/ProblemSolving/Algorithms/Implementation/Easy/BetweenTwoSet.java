import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
/*
Task: Find the total amount of Integer that is able % for all element in a and all element in b can % them.
Input: two array, a and b;
Output: total count of number fit to conditions
*/
public class BetweenTwoSet {

    /*
     * Complete the getTotalX function below.
     */
    static int getTotalX(int[] a, int[] b) {
        /*
         * Write your code here.
         */
        Arrays.sort(a);
        Arrays.sort(b);
        int start = a[a.length - 1];
        int end = b[0];
        ArrayList<Integer> a_applied = new ArrayList<>();
        ArrayList<Integer> b_applied = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            boolean check = true;
            for (int j = 0; j < a.length; j++) {
                if (i % a[j] != 0) {
                    check = false;
                    break;
                }
            }
            if (check == true) {
                a_applied.add(i);
            }
        }
        for (int i = 0; i < a_applied.size(); i++) {
            boolean check = true;
            for (int j = 0; j < b.length; j++) {
                if (b[j] % a_applied.get(i) != 0) {
                    check = false;
                    break;
                }
            }
            if (check == true) {
                b_applied.add(a_applied.get(i));
            }
        }
        return b_applied.size();

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scan.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[] a = new int[n];

        String[] aItems = scan.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }

        int[] b = new int[m];

        String[] bItems = scan.nextLine().split(" ");

        for (int bItr = 0; bItr < m; bItr++) {
            int bItem = Integer.parseInt(bItems[bItr].trim());
            b[bItr] = bItem;
        }

        int total = getTotalX(a, b);

        bw.write(String.valueOf(total));
        bw.newLine();

        bw.close();
    }
}

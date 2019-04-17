import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class GameOfTwoStacks {

    /*
     * Complete the twoStacks function below.
     */
    static int twoStacks(int x, int[] a, int[] b) {
        /*
         * Write your code here.
         */
         /* A Passed Solution From Other Person.
static int twoStacks(int x, int[] a, int[] b) {
    int ai = 0;
    int bi = 0;
    int count = 0;
    int sum = 0;
    // move bi to the position where if only take elements from B, last element it can take
    while (bi < b.length && sum + b[bi] <= x) {
        sum += b[bi];
        bi++;
    }
    bi--; // loop exits only when bi reaches end or sum > x; in both case bi should decrease
    count = bi + 1;
    while (ai < a.length && bi < b.length) {
        sum += a[ai];
        if (sum > x) {
            while (bi >= 0) {
                sum -= b[bi];
                bi--;
                if (sum <= x) break;
            }
            // if even no elements taken from B, but still sum greater than x, then a[ai] should not be chosen
            // and loop terminates
            if (sum > x && bi < 0) {
                ai--;
                break;
            }
        }
        count = Math.max(ai + bi + 2, count);
        ai++;
    }

    return count;
}
         */
         /* After read and understand the algorthmn behind the top soltuion,
            I improved it by remove unnecessary code, such as + 2 and count = bi + 1
            int a_index = 0;
            int b_index = 0;
            int count = 0;
            int sum = 0;
            for (b_index = 0; b_index < b.length; b_index++) {
                sum += b[b_index];
                if (sum > x) {
                    sum -= b[b_index];
                    break;
                }
                count++;
            }
            b_index--;
            while(a_index < a.length) {
                sum += a[a_index];
                if (sum > x) {
                    while (b_index >= 0) {
                        sum -= b[b_index];
                        b_index--;
                        if (sum <= x) {
                            break;
                        }
                    }
                    if (sum > x && b_index < 0) {
                        break;
                    }
                }
                a_index++;
                count = Math.max(a_index +b_index + 1, count);
            }
        return count;
    }
         */
         // Brute force solution failed on Time cases
        ArrayList<Integer> al = new ArrayList<>();
        int sum = 0;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum > x) {
                break;
            }
            else {
                count++;
            }
        }
        al.add(count);
        sum = 0;
        count = 0;
        for (int i = 0; i < b.length; i++) {
            sum += b[i];
            if (sum > x) {
                break;
            }
            else {
                count++;
            }
        }
        al.add(count);
        sum = 0;
        count = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum > x) {
                break;
            }
            int sum_copy = sum;
            count = i + 1;
            for (int j = 0; j <b.length; j++) {
                sum_copy += b[j];
                if (sum_copy > x) {
                    break;
                }
                else {
                    count++;
                }
            }
            al.add(count);
        }
        return Collections.max(al);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            String[] nmx = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmx[0].trim());

            int m = Integer.parseInt(nmx[1].trim());

            int x = Integer.parseInt(nmx[2].trim());

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");

            for (int aItr = 0; aItr < n; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr].trim());
                a[aItr] = aItem;
            }

            int[] b = new int[m];

            String[] bItems = scanner.nextLine().split(" ");

            for (int bItr = 0; bItr < m; bItr++) {
                int bItem = Integer.parseInt(bItems[bItr].trim());
                b[bItr] = bItem;
            }

            int result = twoStacks(x, a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: there is a line, where people hold the number. It is possible for people to swap with the person in front of them.
      Max swap = 2. Find the min swaps for a chaos line back to original
Input: a int q contained the final version after swaps
Output: print a min swaps amount to get back to sorted line
*/
public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int count = 0;
        for (int i = 0; i < q.length; i++) {
            if (q[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < q.length; i++) {
            hm.put(q[i], i);
        }
        //System.out.println(hm);
        for (int i = q.length; i >= 1; i--) {
            int curr = hm.get(i);
            int move = -1;
            if (curr + 1 != i) {
                int difference = Math.abs(i - (curr + 1));
                move = q[curr + difference];
                for (int j = curr; j < curr + difference; j++) {
                    hm.remove(q[j]);
                    hm.remove(q[j+1]);
                    int temp = q[j];
                    q[j] = q[j + 1];
                    q[j + 1] = temp;
                    hm.put(q[j], j);
                    hm.put(q[j+1], j+1);

                }
                count += difference;
            }
        }
        System.out.println(count);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}

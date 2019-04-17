import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
/*
Task: Find the equal size of stacks(3), stack fulled with the Integer which represent the heigh, keep removing until they all had max equal height 
*/
public class EqualStack {

    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        /*
         * Write your code here.
         */
        Stack<Integer> q1 = new Stack<>();
        Stack<Integer> q2 = new Stack<>();
        Stack<Integer> q3 = new Stack<>();
        int sum_q1 = 0;
        int sum_q2 = 0;
        int sum_q3 = 0;
        for (int i = h1.length - 1; i >= 0; i--) {
            sum_q1 += h1[i];
            q1.push(sum_q1);
        }
        for (int i = h2.length - 1; i >= 0; i--) {
            sum_q2 += h2[i];
            q2.push(sum_q2);
        }
        for (int i = h3.length - 1; i >= 0; i--) {
            sum_q3 += h3[i];
            q3.push(sum_q3);
        }
        while (!q1.empty() && !q2.empty() && !q3.empty()) {
            int top_q1 = q1.peek();
            int top_q2 = q2.peek();
            int top_q3 = q3.peek();
            if (top_q1 == top_q2 && top_q1 == top_q3) {
                return top_q1;
            }
            else if (top_q1 < top_q2 && top_q1 < top_q3) {
                q2.pop();
                q3.pop();
            }
            else if (top_q2 < top_q1 && top_q2 < top_q3) {
                q1.pop();
                q3.pop();
            }
            else if (top_q3 < top_q1 && top_q3 < top_q2) {
                q1.pop();
                q2.pop();
            }
            else if (top_q1 < top_q2 && top_q1 == top_q3) {
                q2.pop();
            }
            else if (top_q2 < top_q3 && top_q2 == top_q1) {
                q3.pop();
            }
            else if (top_q3 < top_q1 && top_q3 == top_q2) {
                q1.pop();
            }
        }
        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

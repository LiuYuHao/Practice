import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class JesseAndCookies {

    /*
     * Complete the cookies function below.
     */
    static int cookies(int k, int[] A) {
        /*
         * Write your code here.
         */
         if (k == 0) {
             return 0;
         }
         if (A.length == 0) {
             return -1;
         }
         Queue<Integer> pq = new PriorityQueue<>();
         int count = 0;
         for (int i = 0; i < A.length; i++) {
             pq.add(A[i]);
         }
         while (pq.size() != 1) {
             int data1 = pq.poll();
             if (data1 >= k) {
                 return count;
             }
             int data2 = pq.poll();
             int data3 = data1 + 2 * data2;
             count++;
             pq.add(data3);
             int check = pq.peek();
         }
         if (pq.peek() >= k) {
             return count;
         }
         return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");

        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            A[AItr] = AItem;
        }

        int result = cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

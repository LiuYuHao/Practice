import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find all Maximum of minimum of all the size of subarray.
      E.g: 1 1 7 4 3 => 7 for size of one.
           (1,1) (1,7) (7,4) (4,3) => min of each subarray is 1,1,4,3 => max of them is 4.
           So On ....
Input: a long array
Output: a long array contained the result of each size subarray
*/
public class Solution {

    // Complete the riddle function below.
    static long[] riddle(long[] arr) {
        // complete this function
        // three times cases cannot passed
        long[] result = new long[arr.length];
        Queue<Long> q = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            q.add(arr[i]);
        }
        int win_size = 0;
        long smallest = q.poll();
        long biggest = smallest;
        int count = 1;
        long last = 0;
        while(q.size() != 0) {
            //System.out.println(q);
            long x = q.poll();
            if (count == arr.length - win_size) {
                //System.out.println(count);
                result[win_size] = biggest;
                win_size++;
                smallest = x;
                biggest = x;
                count = 1;
                last = x;
                //System.out.println(x);
                //System.out.println(q.size());
            }
            //System.out.println(smallest);
            else {
                if (x < smallest) {
                    q.add(x);
                }
                else {
                    q.add(smallest);
                }
                smallest = x;
                if (x > biggest) {
                    biggest = x;
                }
                count++;
            }
        }
        result[arr.length - 1] = last;
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] arr = new long[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr[i] = arrItem;
        }

        long[] res = riddle(arr);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

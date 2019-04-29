import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find the max sum and min of four of a 5-size array
Input: a array
Output: min max
*/
public class Mini_Max_Sum {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr[0]);
        pq.add(arr[1]);
        pq.add(arr[2]);
        pq.add(arr[3]);
        pq.add(arr[4]);
        long min = 0;
        long max = 0;
        while (pq.size() != 0) {
            long data = (long)pq.poll();
            if (pq.size() == 4) {
                min += data;
            }
            else if (pq.size() == 0){
                max += data;
            }
            else {
                min += data;
                max += data;
            }
        }
        System.out.println(min + " " + max);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}

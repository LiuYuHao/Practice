import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find the lower amount of swap to make an int array sorted
Input: a int arr
Output: a int to indicate the min swaps
*/
public class MinSwap2 {
    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
      // after recognize the value in of arr is equal to the index + 1;
      // the final sorted arr: value = index + 1;
      int count = 0;
      int index = 0;
      for (int i = 0; i < arr.length - 1; i++) {
          if (arr[i] != i + 1) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] == i + 1) {
                        index = j;
                        break;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                count++;
            }
        }
        return count;
        // Brute force solution - cannot pass time cases
        // ArrayList<Integer> al = new ArrayList<Integer>();
        // HashMap<Integer, Integer> hm = new HashMap<>();
        // int[] result = new int[arr.length];
        // int count = 0;
        // for (int i = 0; i < arr.length; i++) {
        //     al.add(arr[i]);
        //     hm.put(arr[i], i);
        // }
        // for (int i = 0; i < al.size() - 1; i++) {
        //     int lowest = Collections.min(al.subList(i + 1, al.size()));
        //     if (al.get(i) > lowest) {
        //         int index = hm.get(lowest);
        //         int temp = al.get(i);
        //         al.set(i, lowest);
        //         al.set(index, temp);
        //         hm.remove(temp);
        //         hm.put(temp, index);
        //         count++;
        //     }
        // }
        // //System.out.println(al);
        // return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find the smallest difference between two pair of number in the array
Input: a int[] arr
Output:  a int array which contains the pair number in asc order
*/
class Pair{
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class ClosetNumber {
    // Complete the closestNumbers function below.
    static int[] closestNumbers(int[] arr) {
        HashMap<Integer, ArrayList<Pair>> hm = new HashMap<>();
        Arrays.sort(arr);
        int smallest_difference = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            int difference = arr[i] - arr[i - 1];
            if (difference < smallest_difference) {
                smallest_difference = difference;
            }
            if (!hm.containsKey(difference)) {
                ArrayList<Pair> al = new ArrayList<>();
                al.add(new Pair(arr[i], arr[i - 1]));
                hm.put(difference, al);
            }
            else {
                hm.get(difference).add(new Pair(arr[i], arr[i - 1]));
            }
        }
        int size = hm.get(smallest_difference).size();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(hm.get(smallest_difference).get(i).y);
            result.add(hm.get(smallest_difference).get(i).x);

        }
        int[] ar = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ar[i] = result.get(i);
        }
        return ar;
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

        int[] result = closestNumbers(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

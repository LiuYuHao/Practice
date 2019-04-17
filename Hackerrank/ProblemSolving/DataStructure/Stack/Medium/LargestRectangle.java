import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: there is a int array, inside of it represent the height and index = width, find the max area of a rectangle
      view as index = width, the each of value in the index = height, therefore it will be a image of bar graph
      find the max area in the bar graph of a rectangle
*/
public class LargestRectangle {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
      /* brute force solution
        Stack<Integer> stack = new Stack<>();
        for (int x = h.length - 1; x >= 0; x--) {
            stack.push(h[x]);
        }
        long area = 0;
        for (int i = 0; i < h.length; i++) {
            Stack<Integer> stack_copy = (Stack<Integer>) stack.clone();
            long width = 0;
            long length = stack_copy.peek();
            long area_copy = 0;
            while(!stack_copy.isEmpty()) {
                int data = stack_copy.pop();
                if (data < length) {
                    length = data;
                }
                width++;
                area_copy = length * width;
                if (area_copy > area) {
                    area = area_copy;
                }
            }
            int data = stack.pop();
        }
        return area;
        */
        // This solved the time cases, i think it is because I didn't use stack, Since I use stack.clone(),
        //  therefore, it still 0(n^2) but shorter than bruteforce solution
        long area = 0;
        for (int i = 0; i < h.length; i++) {
            long width = 1;
            long area_copy = 0;
            int left = i;
            int right = i;
            while (left != 0) {
                if (h[left - 1] >= h[i]) {
                    width++;
                    left--;
                }
                else {
                    break;
                }
            }
            while(right != h.length - 1) {
                if (h[right + 1] >= h[i]) {
                    width++;
                    right++;
                }
                else {
                    break;
                }
            }
            area_copy = width * h[i];
            area = Math.max(area_copy, area);
        }
        return area;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

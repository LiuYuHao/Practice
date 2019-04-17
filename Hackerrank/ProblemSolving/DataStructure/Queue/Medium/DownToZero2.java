import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
/*
Task: Give a number, two operation, decrease by one or find the a and b such that a x b = number, resert number to max(a,b);
      Goal: shortest count to make the number to zero;
*/
public class DownToZero2 {

    /*
     * Complete the downToZero function below.
     */
    static class Box {
        int n;
        int count;
        public Box(int n, int count) {
            this.n = n;
            this.count = count;
        }
    }
    static int downToZero(int n) {
        /*
         * Write your code here.
         */
         // Brute force solution, when number get big, it has running time error
         Map<Integer, Integer> map = new HashMap<>();
         for (int i = 0; i <= n; i++) {
          map.put(i, i);
        }
        for (int i = 4; i <= n; i++) {
          if (map.get(i) == i) {
          map.put(i, map.get(i - 1) + 1);
        }
        for (int j = 2; j <= i; j++) {
          if (i % j == 0) {
            int number = Math.max(j, i/j);
            int count = Math.min(map.get(number) + 1, map.get(i));
            map.put(i, count);
          }
        }
      }
      //map.forEach((k,v) -> System.out.println(k + " " + v));
      return map.get(n);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(scanner.nextLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            int result = downToZero(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}

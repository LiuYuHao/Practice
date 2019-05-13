
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task:A group of people want to buy all the flowers, the price of flower is increasing by each flower the same person purchased before.
     Example, a person buy a flower and buy another one = (1 + 1) *(flower price)
Input: a int k = amount of people, c = a int array for price of flowers
Output: a int for indicate the minimumCost
*/
public class GreedyFlorist {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        int equal_amount = c.length / k;
        int equal_amount_tem = 0;
        int extra = c.length % k;
        Arrays.sort(c);
        int flowers = equal_amount * k;
        int total_price = 0;
        int i = c.length - 1;
        for (; i > c.length - 1 - flowers;) {
            for (int j = 0; j < k; j++,i--) {
                total_price += (equal_amount_tem + 1) * c[i];
            }
            equal_amount_tem++;
        }
        for (int j = i; j > i - extra; j--) {
            total_price += (equal_amount + 1) * c[j];
        }
        return total_price;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        bufferedWriter.write(String.valueOf(minimumCost));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

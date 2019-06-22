
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find how many game you can buy during sale, start at p price and reduce each time by d and bottom line is m.
Input: four Integers p starting price, d decrase amount, m the mini price, s the money
Output: a int for amount of games you bought with the s
*/
public class Solution {

    // Complete the howManyGames function below.
    static int howManyGames(int p, int d, int m, int s) {
        // Return the number of games you can buy
        int cost = 0;
        int count = 0;
        while (cost + p <= s) {
            cost += p;
            //System.out.println(p);
            count++;
            if (p - d > m) {
                p = p - d;
            }
            else {
                p = m;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] pdms = scanner.nextLine().split(" ");

        int p = Integer.parseInt(pdms[0]);

        int d = Integer.parseInt(pdms[1]);

        int m = Integer.parseInt(pdms[2]);

        int s = Integer.parseInt(pdms[3]);

        int answer = howManyGames(p, d, m, s);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

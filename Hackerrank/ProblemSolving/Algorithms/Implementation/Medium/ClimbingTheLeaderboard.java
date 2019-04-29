import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: climb to leaderbroad, after each game score of alice is updated, need to find the rank based on each updated rank
Input: a int array named scores for scores in leaderbroad, a int array score of alice represent each updated score after each game
Output: return a int array for represent each rank in the leaderbroad after each game
*/
public class ClimbingTheLeaderboard {

    // Complete the climbingLeaderboard function below.

    static int[] climbingLeaderboard(int[] scores, int[] alice) {
    /* I think this this most shortest bruteforce solution
        TreeSet<Integer> ts = new TreeSet<>();
        int[] result = new int[alice.length];
        for (int i = 0; i <scores.length; i++) {
            ts.add(scores[i]);
        }
        for (int i = 0; i <alice.length; i++) {
            ts.add(alice[i]);
            result[i] = ts.tailSet(alice[i]).size();
        }
        return result;
    */
    LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
    int[] result = new int[alice.length];
    for (int i = scores.length - 1; i >= 0; i--) {
      lhs.add(scores[i]);
    }
    ArrayList<Integer> al = new ArrayList<>();
    al.addAll(lhs);
    int count = al.size();
    for (int i = 0, j = 0; i < alice.length; i++){
      for (; j < al.size(); j++) {
          if (al.get(j) > alice[i]) break;
          count--;
        }
        result[i] = count + 1;
      }
      return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

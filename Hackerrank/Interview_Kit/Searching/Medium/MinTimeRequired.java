import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: give a long array for represent the amount of each machines' ratios to produce one item, find min days to get the target amount of items
Input: a long array machines and the long goal
Output: a long for represent the days
*/
public class MinTimeRequired {

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {
      // use binary search, nlongn time complexity
      Arrays.sort(machines);
      long longest_days = (machines[machines.length - 1] * goal) / machines.length;
      long shortest_days = (machines[0] * goal) / machines.length;
      while (shortest_days < longest_days) {
        long middle_day = (longest_days + shortest_days) /2;
        long days = 0;
        for (long x: machines) {
          days += (long) middle_day / x;
        }
        if (days >= goal) {
          longest_days = middle_day;
        }
        else {
          shortest_days = middle_day + 1;
        }
      }
      return shortest_days;
      // brute force solution
        // HashMap<Long, Long> hm = new HashMap<>();
        // for (int i = 0; i < machines.length; i++) {
        //     hm.merge(machines[i], (long)1 , Long::sum);
        // }
        // long days = 0;
        // long items = 0;
        // while (items != goal) {
        //     days++;
        //     for (Map.Entry<Long, Long> e : hm.entrySet()) {
        //         if (days % e.getKey() == 0) {
        //             items += e.getValue();
        //         }
        //     }
        // }
        // return days;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

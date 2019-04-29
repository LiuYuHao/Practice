import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: every container only contained one type of ball, do the swap operation between two containers.
Input: a 2d matrix to represent a table which shows the ball's locations initially.
Output:  a string, possible for after some swap operations it matches the condition, otherwise return impossible
*/
public class OrganizingBallContainers {

    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {
        int[] container_capcities = new int[container.length];
        int[] types = new int[container.length];
        for (int i = 0; i < container.length; i++) {
            int sum = 0;
            for (int j = 0; j < container.length; j++) {
                sum += container[i][j];
                types[j] += container[i][j];
            }
            container_capcities[i] = sum;
        }
        // for (int x : container_capcities) {
        //     System.out.println(x);
        // }
        // for (int x : types) {
        //     System.out.println(x);
        // }
        Arrays.sort(container_capcities);
        Arrays.sort(types);
        for (int i = 0; i < container.length; i++) {
            if (container_capcities[i] != types[i]) {
                return "Impossible";
            }
        }
        return "Possible";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

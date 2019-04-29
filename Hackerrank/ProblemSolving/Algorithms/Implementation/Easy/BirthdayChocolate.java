import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
/*
Task: count the total amount of m continuous subset which sum equals d;
Input: a list contained Integers, d for condition for sum, m for size of subset
Output: a Integer represent total count of subset fit to the conditions
*/
public class BirthdayChocolate {

    // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {
        if (s.size() < m) {
            return 0;
        }
        int sum = 0;
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        int index = 0;
        while(index < s.size()) {
            if (q.size() < m) {
                q.add(s.get(index));
                sum += s.get(index);
            }
            if (q.size() == m) {
                if (sum == d) {
                    count++;
                }
                int data = q.poll();
                sum -= data;
            }
            index++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

        int result = birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

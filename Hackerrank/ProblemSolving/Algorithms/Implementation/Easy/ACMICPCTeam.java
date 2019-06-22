import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: given a matrix, find the amount of combined rows (2) that contains higheest amount of 1 at each columns
Input: a string array represent each row and string as column
Output: a size 2 array, highest amount of 1 and how many row combinations contains it.
*/
class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return "(" + x + " " + y + ")";
    }
}
public class Solution {

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
        ArrayList<Pair> al = new ArrayList<>();
        for (int i = 0; i < topic.length; i++) {
            for (int j = i + 1; j < topic.length; j++) {
                al.add(new Pair(i, j));
            }
        }
        //System.out.println(al);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < al.size(); i++) {
            int count = 0;
            for (int j = 0; j < topic[0].length(); j++) {
                if (topic[al.get(i).x].charAt(j) == '1' ||  topic[al.get(i).y].charAt(j) == '1') {
                    count++;
                }
            }
            if (!hm.containsKey(count)) {
                hm.put(count, 1);
            }
            else {
                hm.put(count, hm.get(count) + 1);
            }
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            if (e.getKey() > max) {
                max = e.getKey();
            }
        }
        int[] result = new int[2];
        result[0] = max;
        result[1] = hm.get(max);
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

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

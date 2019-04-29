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
Task: the highest size of subset where the difference between element inside are 1 (|1|);
Input: a list where contained Integer
Output: A Integer represent the size of max subset
*/
class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i = 0; i < a.size(); i++) {
            if (!tm.containsKey(a.get(i))) {
                tm.put(a.get(i), 1);
            }
            else {
                tm.merge(a.get(i), 1, Integer::sum);
            }
        }
        int pre = 0;
        int pre_count = 0;
        int max_size = 0;
        for (Map.Entry<Integer, Integer> e: tm.entrySet()) {
            if (e.getKey() == pre + 1) {
                int sum = pre_count + e.getValue();
                if (sum > max_size) {
                    max_size = sum;
                }
            }
            else {
                if (e.getValue() > max_size) {
                    max_size = e.getValue();
                }
            }
            pre = e.getKey();
            pre_count = e.getValue();
        }
        return max_size;
    }
}

public class PickingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

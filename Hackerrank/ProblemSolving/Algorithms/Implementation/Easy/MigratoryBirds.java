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
Task: find the highest repetition in the array => if same => choose lower value
Input: A list arr
Output:  output a Integer which represented the lower value in amoung of highest repetition
*/
public class MigratoryBirds {
  // for playing
    // static class Birds implements Comparable<Birds> {
    //     public int id;
    //     public int frequency;
    //     public Birds(int id) {
    //         this.id = id;
    //         int frequency = 1;
    //     }
    //     @Override
    //     public int compareTo(Birds b) {
    //         if (this.frequency == b.frequency) {
    //             return this.id - b.id;
    //         }
    //         else {
    //             return this.frequency - b.frequency;
    //         }
    //     }
    //     @Override
    //     public boolean equals(Object o) {
    //         if (this == o) {
    //             return true;
    //         }
    //         Birds b = (Birds) o;
    //         if (this.frequency != b.frequency || this.frequency == b.frequency) {
    //             return true;
    //         }
    //         if (!(o instanceof Birds)) {
    //             return false;
    //         }
    //
    //         return this.id == b.id;
    //     }
    // }
    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (Integer x: arr) {
            if (!hm.containsKey(x)) {
                hm.put(x, 1);
            }
            else {
                hm.merge(x, 1, Integer::sum);
            }
        }
        int max = 0;
        int id = 0;
        for(Map.Entry<Integer,Integer> e: hm.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                id = e.getKey();
            }
            else if (e.getValue() == max) {
                if (e.getKey() < id) {
                    id = e.getKey();
                }
            }
        }
        return id;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

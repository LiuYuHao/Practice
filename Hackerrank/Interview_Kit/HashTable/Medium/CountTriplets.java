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
Task: count amount of triplets under the conditions as i < j < k, they are index of array, and under a ratios such as 2 the triplets cane be (1,2,4);
Input: a list with Integer and one r for the ratios
Output: a long represents amount of triplets under the conditions 
*/
public class countTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        HashMap<Long, Long> hm = new HashMap<>();
        HashMap<Long, Long> hm2 = new HashMap<>();
        long count = 0;
        //System.out.println(hm);
        for (int i = 0; i < arr.size(); i++) {
            if (hm2.containsKey(arr.get(i))) {
                count += hm2.get(arr.get(i));
            }
            if (hm.containsKey(arr.get(i))) {
                hm2.merge(arr.get(i) * r, hm.get(arr.get(i)), Long::sum);
            }
            hm.merge(arr.get(i) * r, (long)1 , Long::sum);
            //System.out.println(hm);
            //System.out.println(hm2);
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

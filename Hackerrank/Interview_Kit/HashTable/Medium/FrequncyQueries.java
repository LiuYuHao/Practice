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
Task: three operations 1 x - add x, 2 x - delete one occurence of x, 3 x- print 1 for if there is a number had x frequency else print 0
Input: a 2d list of Integer named queries, where 0 = operation and 1 equals data
Ouput: a list where contained the answer of each of third operations
*/
public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        // Brute force solution
        static List<Integer> freqQuery(List<List<Integer>> queries) {
            List<Integer> result = new ArrayList<>();
            HashMap<Integer, Integer> fre_hm = new HashMap<>();
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (List<Integer> l  : queries) {
                if (l.get(0) == 1) {
                    if (!hm.containsKey(l.get(1))) {
                        hm.put(l.get(1),1);
                        fre_hm.merge(1,1,Integer::sum);
                    }
                    else{
                        fre_hm.put(hm.get(l.get(1)), fre_hm.get(hm.get(l.get(1))) - 1);
                        hm.merge(l.get(1), 1, Integer::sum);
                        fre_hm.merge(hm.get(l.get(1)),1,Integer::sum);
                    }
                }
                else if (l.get(0) == 2) {
                    if (hm.containsKey(l.get(1)) && hm.get(l.get(1)) > 0) {
                        fre_hm.put(hm.get(l.get(1)), fre_hm.get(hm.get(l.get(1))) - 1);
                        hm.put(l.get(1), hm.get(l.get(1)) - 1);
                        fre_hm.merge(hm.get(l.get(1)),1,Integer::sum);
                    }
                }
                else {
                    if (fre_hm.containsKey(l.get(1)) && fre_hm.get(l.get(1)) != 0) {
                        result.add(1);
                    }
                    else {
                        result.add(0);
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
            ans.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

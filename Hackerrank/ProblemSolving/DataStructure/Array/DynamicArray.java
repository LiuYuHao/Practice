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
Task: there are two type of queries, we need to follow the rule to insert value and get the value
notation: There is a last_answer = 0; N = number of sequence
input: 1 x y => query 1 find the ((x xor last_answer) % n)th sequence, add y to it
       2 x y => same format for sequence, but it find value of index where equals y % size of seq and assigns to last_answer
*/
public class dynamicArray {

    // Complete the dynamicArray function below.
    static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        int last_answer = 0;
        List<Integer> result = new ArrayList<Integer>();
        List<List<Integer> >seqList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> seq = new ArrayList<>();
            seqList.add(seq);
        }
        for(List<Integer> l: queries) {
            int seq_number = (l.get(1) ^ last_answer) % n;
            if (l.get(0) == 1) {
                seqList.get(seq_number).add(l.get(2));
            }
            else {
                int index = l.get(2) % seqList.get(seq_number).size();
                last_answer = seqList.get(seq_number).get(index);
                result.add(last_answer);
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nq = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nq[0]);

        int q = Integer.parseInt(nq[1]);

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

        List<Integer> result = dynamicArray(n, queries);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

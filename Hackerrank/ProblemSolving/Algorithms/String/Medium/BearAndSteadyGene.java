import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find the smallest substring which we can replace to make the string steady,
     this means, each frequenceis of character = n/4 n is size of string.
Input: a string, where the size is divsible by 4
Output: a int which is size of smallest substring replacement

*/
public class Solution {
    // Complete the steadyGene function below.
    static int steadyGene(String gene) {
         int amount = gene.length() / 4;
         int index_start = gene.length() - 1;
         HashMap<Character, Integer> hm = new HashMap<>();
         ArrayList<Integer> al = new ArrayList<>();
         for (int i = 0; i < gene.length(); i++) {
             //System.out.println(i);
             if (!hm.containsKey(gene.charAt(i))) {
                 hm.put(gene.charAt(i), 1);
             }
             else {
                 if (hm.get(gene.charAt(i)) < amount) {
                     hm.put(gene.charAt(i), hm.get(gene.charAt(i)) + 1);
                 }
                 else {
                     index_start = i - 1;
                     break;
                 }
             }
             //System.out.println(hm);
         }
        //System.out.println(index_start);
        for (int i = gene.length() - 1; i >= 0;) {
             if (!hm.containsKey(gene.charAt(i))) {
                 hm.put(gene.charAt(i), 1);
                 i--;
             }
             else {
                 if (hm.get(gene.charAt(i)) < amount) {
                     hm.put(gene.charAt(i), hm.get(gene.charAt(i)) + 1);
                     i--;
                 }
                 else {
                    //System.out.println(i + " " + index_start + " " + (i - index_start));
                    al.add(i - index_start);
                    while (hm.get(gene.charAt(i)) == amount && index_start > -1) {
                        hm.put(gene.charAt(index_start), hm.get(gene.charAt(index_start)) - 1);
                        if (hm.get(gene.charAt(index_start)) == 0) {
                            hm.remove(gene.charAt(index_start));
                        }
                        index_start--;
                    }
                    if (index_start < 0) {
                        break;
                    }
                 }
             }
        }
        //System.out.println(al);
        return Collections.min(al);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String gene = scanner.nextLine();

        int result = steadyGene(gene);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

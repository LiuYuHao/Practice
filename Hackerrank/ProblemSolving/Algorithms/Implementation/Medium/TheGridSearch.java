import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: Two 2d matrix, is the p inside of G ?
Input: two matrix G and P.
Output: return YES if p inside of G, return NO is p is not inside of G;
Input:
Output:
*/
public class TheGridSearch {

    // Complete the gridSearch function below.
    static String gridSearch(String[] G, String[] P) {
        HashMap<String, String> hm = new LinkedHashMap<>();
        hm.put(P[0],P[0]);
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        for (int j = 0; j < G.length - P.length + 1; j++) {
            for (int i = 0; i < G[j].length() - P[0].length() + 1; i++) {
                String sub = G[j].substring(i, i + P[0].length());
                //System.out.println(sub);
                //System.out.println(i + " " + (i + P[0].length()));
                if (hm.containsKey(sub)) {
                    //System.out.println(j + " " + i);
                    x.add(j);
                    y.add(i);
                }
            }
        }
        if (x.size() == 0) {
            return "NO";
        }
        for (int j = 0; j < x.size(); j++) {
            boolean check = true;
            //System.out.println(e.getKey() + " " + e.getValue());
            for(int i = 1; i < P.length; i++) {
                if (!(G[x.get(j) + i].substring(y.get(j), y.get(j) + P[0].length()).equals(P[i]))) {
                    check = false;
                }
            }
            if (check == true) {
                return "YES";
            }
        }
        // for (Map.Entry<String, HashMap<Integer,Integer>> e : hm.entrySet()) {
        //     System.out.println(e.getValue());
        //     if (e.getValue().size() == 0) {
        //         return "NO";
        //     }
        //     //al.add(e.getValue());
        // }


        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            String result = gridSearch(G, P);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

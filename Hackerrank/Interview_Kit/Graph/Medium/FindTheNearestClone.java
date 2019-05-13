import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: Find the nearest node where had the same color as target. Given the color find the cloest two node where they are the same.
Input: int graphNodes = amount of node, a int array graphfrom and a int array graphTo => the edge from v1 to v2, a long [] ids for indicate the color of each node
       int val => the color id that we need to find the pair
Output: return shorestpath (value of each edge = 1), if not pair return -1;
*/
// brute force solution
// class Data {
//     public int data;
//     public int distance;
//     public Data(int data) {
//         this.data = data;
//         this.distance = 0;
//     }
//     public Data(int data, int distance) {
//         this.data = data;
//         this.distance = distance;
//     }
// }
public class Solution {

    // Complete the findShortest function below.

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] to <name>To[i].
     *
     */
    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        // solve here
        // Brute Force solution
        // ArrayList<Integer> al = new ArrayList<>();
        // int[][] matrix = new int [graphNodes + 1][graphNodes + 1];
        // for (int i = 0; i < graphTo.length; i++) {
        //     matrix[graphFrom[i]][graphTo[i]] = 1;
        // }
        // for (int i = 1; i <= graphNodes; i++) {
        //     if (ids[i - 1]  == (long) val) {
        //         Queue<Data> q = new LinkedList<>();
        //         int[] check = new int[graphNodes + 1];
        //         for (int j = 1; j <= graphNodes; j++) {
        //             if(matrix[i][j] == 1 || matrix[j][i] == 1) {
        //                 q.add(new Data(j, 1));
        //             }
        //         }
        //         check[i] = 1;
        //         while (q.size() != 0) {
        //             Data d = q.poll();
        //             if (ids[d.data - 1] == (long)val && check[d.data] == 0) {
        //                 al.add(d.distance);
        //                 break;
        //             }
        //             else if (check[d.data] == 0) {
        //                 check[d.data] = 1;
        //                 for (int j = 1; j <= graphNodes; j++) {
        //                     if(matrix[d.data][j] == 1 || matrix[j][d.data] == 1) {
        //                     q.add(new Data(j, d.distance + 1));
        //                     }
        //                 }
        //             }
        //         }
        //     }
        // }
        // if (al.size() == 0) {
        //     return -1;
        // }
        // else {
        //     return Collections.min(al);
        // }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] graphNodesEdges = scanner.nextLine().split(" ");
        int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
        int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

        int[] graphFrom = new int[graphEdges];
        int[] graphTo = new int[graphEdges];

        for (int i = 0; i < graphEdges; i++) {
            String[] graphFromTo = scanner.nextLine().split(" ");
            graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
            graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
        }

        long[] ids = new long[graphNodes];

        String[] idsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < graphNodes; i++) {
            long idsItem = Long.parseLong(idsItems[i]);
            ids[i] = idsItem;
        }

        int val = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int ans = findShortest(graphNodes, graphFrom, graphTo, ids, val);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

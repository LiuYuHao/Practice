import java.io.*;
import java.util.*;
/*
Task: find all the shortest path to each node of given start node, if cannot reach = -1;
Input: int q = number of cases
       int m, n = number of nodes and edges
       int v1, v2 = the connection (edges) of v1 and v2
       .....
       .... edges times
       int x = start node
       round 2
Output: a System print of the shortest path to node in ascending order of index of node.
*/
class Node{
    public int x;
    public int distance;
    public Node(int x) {
        this.x = x;
        this.distance = 0;
    }
    public Node(int x, int distance) {
        this.x = x;
        this.distance = distance;
    }
    @Override
    public String toString() {
        return Integer.toString(this.x) + " " + Integer.toString(this.distance);
    }
}
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int queries = sc.nextInt();
        for (int i = 0; i < queries; i++) {
            int number_node = sc.nextInt();
            int number_edge = sc.nextInt();
            int[][] matrix =new int[number_node + 1][number_node + 1];
            int[] check = new int[number_node + 1];
            for (int j = 0; j < number_edge; j++) {
                int node1 = sc.nextInt();
                int node2 = sc.nextInt();
                matrix[node1][node2] = 1;
            }
            int start_node = sc.nextInt();
            Queue<Node> q = new LinkedList<>();
            q.add(new Node(start_node));
            ArrayList<Node> al = new ArrayList<>();
            while(q.size() != 0) {
                Node data = q.poll();
                if (check[data.x] == 0) {
                    check[data.x] = 1;
                    al.add(data);
                    for (int k = 1; k < number_node + 1; k++) {
                        if (matrix[data.x][k] == 1 || matrix[k][data.x] == 1) {
                            q.add(new Node(k, data.distance + 6));
                        }
                    }
                }
            }
            //System.out.println(al);
            int[] result = new int[number_node + 1];
            for (int c = 0; c < result.length; c++) {
                result[c] = -1;
            }
            for (Node n : al) {
                result[n.x] = n.distance;
            }
            for (int z = 1; z < result.length; z++) {
                if (result[z] != 0) {
                    System.out.print(result[z] + " ");
                }
            }
            System.out.println("");
        }
    }
}

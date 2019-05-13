import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
/*
Task: swap node based on the k, for all the depth of node that is equals to 1k,2k,3k... swap the left node and right node
Input: two d array represent as parent array the array in side the index represent the children of index node.
        one array named queries for how many k. 
Output: inorder after each k.
*/
public class SwapNodes {

    /*
     * Complete the swapNodes function below.
     */
    static class Node {
        public Node left;
        public Node right;
        public int data;
        public int depth;
        public Node(int data, int depth) {
            this.data = data;
            this.depth = depth;
        }

    }
    static void assginedDepth(Node root, int depth) {
        if (root == null || root.data == -1) {
            return;
        }
        root.depth = depth;
        assginedDepth(root.left, depth + 1);
        assginedDepth(root.right, depth + 1);
    }
    static void in_Order(Node root, ArrayList<Integer> al) {
        if (root == null || root.data == -1) {
            return;
        }
        in_Order(root.left, al);
        //System.out.println(root.data);
        al.add(root.data);
        in_Order(root.right, al);
    }

    static int[][] swapNodes(int[][] indexes, int[] queries) {
        /*
         * Write your code here.
         */

        int[][] result = new int[queries.length][indexes.length];
        ArrayList<Node> al = new ArrayList<>();
        Node root = new Node(1,0);
        al.add(root);
        for (int i = 0; i < indexes.length; i++) {
            Node left = new Node(indexes[i][0], 0);
            Node right = new Node(indexes[i][1], 0);
            if (left.data != -1) {
                al.add(left);
            }
            if (right.data != -1) {
                al.add(right);
            }
            al.get(i).left = left;
            al.get(i).right = right;
        }
        assginedDepth(root, 1);
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < al.size(); j++) {
                if (al.get(j).depth % queries[i] == 0) {
                    Node copy = al.get(j).left;
                    al.get(j).left = al.get(j).right;
                    al.get(j).right = copy;
                }
            }
            ArrayList<Integer> temp = new ArrayList<>();
            in_Order(root, temp);
            for (int j = 0; j < temp.size(); j++) {
                result[i][j] = temp.get(j);
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

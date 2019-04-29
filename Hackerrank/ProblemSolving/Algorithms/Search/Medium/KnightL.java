import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: Knight on the chess move L move. on a nxn board, calculate the mini moves for a knight from (0,0) to (n-1,n-1);
      if it cannot => -1. It is not the L move like the chess, it could be (1,1), (1,2), (1,3) ... (1,n-1);
                                                                     then (2, 1), (2,2) ...........(2, n-1);
Input: A int n for the size of board
Output: a 2d array for indicate the minimum moves of knight under different L moves to the (n-1, n-1);
*/
class Chess {
    public int x;
    public int y;
    public int move;
    public int path_x;
    public int path_y;
    public Chess(int x, int y) {
        this.x = x;
        this.y = y;
        this.move = 1;
    }
    @Override
    public boolean equals(Object c) {
        if (c == this) {
            return true;
        }
        else if (!(c instanceof Chess)) {
            return false;
        }
        else {
            Chess copy = (Chess) c;
            if ((this.x == copy.x || this.x == copy.y) && (this.y == copy.x || this.y == copy.y)) {
                return true;
            }
            else {
                return false;
            }
        }

    }
   @Override
   public int hashCode() {
       return Integer.hashCode(this.x) * Integer.hashCode(this.y);
   }
}
public class KnightL {

    // Complete the knightlOnAChessboard function below.
    static int[][] knightlOnAChessboard(int n) {
        int[][] result = new int[n - 1][n - 1];
        HashMap<Chess, HashMap<Chess,Chess>> hm =new HashMap<>();
        Queue<Chess> q = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                //System.out.println(i + " " + j);
                HashMap<Chess, Chess> copy = new HashMap<>();
                Chess chess = new Chess(i,j);
                chess.path_x = i;
                chess.path_y = j;
                q.add(chess);
                copy.put(chess,chess);
                hm.put(chess, copy);
            }
        }
        // Chess test2 = new Chess(3,3);
        // for (Map.Entry<Chess, HashMap<Chess, Chess>> e: hm.entrySet()) {
        //     System.out.println(e.getKey().equals(test2));
        // }
        //System.out.println(q.size());
        while(q.size() != 0) {
            Chess copy = q.poll();
            //System.out.println(copy.x + " " + copy.y);
            if (copy.x == n - 1 && copy.y == n - 1) {
                if (copy.move > result[copy.path_x - 1][copy.path_y - 1]) {
                    result[copy.path_x - 1][copy.path_y - 1] = copy.move;
                }
            }
            else {
                Chess path = new Chess(copy.path_x, copy.path_y);
                //System.out.println(hm.containsKey(path));
                int x_left = copy.x + copy.path_x;
                int x_right = copy.x - copy.path_x;
                int y_down = copy.y + copy.path_y;
                int y_up = copy.y - copy.path_y;
                if (x_left < n && y_down < n ) {
                    Chess way = new Chess(x_left, y_down);
                    way.path_x = path.x;
                    way.path_y = path.y;
                    //System.out.println(hm.get(path).containsKey(way));
                    if (!hm.get(path).containsKey(way)) {
                        way.move = copy.move + 1;
                        hm.get(path).put(way, way);
                        q.add(way);
                    }
                }
                if (x_left < n && y_up > -1 ) {
                    Chess way = new Chess(x_left, y_up);
                    way.path_x = path.x;
                    way.path_y = path.y;
                    if (!hm.get(path).containsKey(way)) {
                        way.move = copy.move + 1;
                        hm.get(path).put(way,way);
                        q.add(way);
                    }
                }
                if (x_right > -1 && y_up > -1 ) {
                    Chess way = new Chess(x_right, y_up);
                    way.path_x = path.x;
                    way.path_y = path.y;
                    if (!hm.get(path).containsKey(way)) {
                        way.move = copy.move + 1;
                        hm.get(path).put(way,way);
                        q.add(way);
                    }
                }
                if (x_right > -1 && y_down < n ) {
                    Chess way = new Chess(x_right, y_down);
                    way.path_x = path.x;
                    way.path_y = path.y;
                    if (!hm.get(path).containsKey(way)) {
                        way.move = copy.move + 1;
                        hm.get(path).put(way,way);
                        q.add(way);
                    }
                }
                x_left = copy.x + copy.path_y;
                x_right = copy.x - copy.path_y;
                y_down = copy.y + copy.path_x;
                y_up = copy.y - copy.path_x;
                if (x_left < n && y_down < n ) {
                    Chess way = new Chess(x_left, y_down);
                    way.path_x = path.x;
                    way.path_y = path.y;
                    if (!hm.get(path).containsKey(way)) {
                        way.move =copy.move + 1;
                        hm.get(path).put(way,way);
                        q.add(way);
                    }
                }
                if (x_left < n && y_up > -1 ) {
                    Chess way = new Chess(x_left, y_up);
                    way.path_x = path.x;
                    way.path_y = path.y;
                    if (!hm.get(path).containsKey(way)) {
                        way.move = copy.move + 1;
                        hm.get(path).put(way,way);
                        q.add(way);
                    }
                }
                if (x_right > -1 && y_up > -1 ) {
                    Chess way = new Chess(x_right, y_up);
                    way.path_x = path.x;
                    way.path_y = path.y;
                    if (!hm.get(path).containsKey(way)) {
                        way.move = copy.move + 1;
                        hm.get(path).put(way,way);
                        q.add(way);
                    }
                }
                if (x_right > -1 && y_down < n ) {
                    Chess way = new Chess(x_right, y_down);
                    way.path_x = path.x;
                    way.path_y = path.y;
                    if (!hm.get(path).containsKey(way)) {
                        way.move =copy.move + 1;
                        hm.get(path).put(way,way);
                        q.add(way);
                    }
                }
            }
        }
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1; j++) {
                if (result[i][j] <= 0 && result[j][i] <= 0) {
                    result[i][j] = -1;
                }
                else if (result[i][j] == 0) {
                    result[i][j] = result[j][i];
                }
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] result = knightlOnAChessboard(n);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                bufferedWriter.write(String.valueOf(result[i][j]));

                if (j != result[i].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

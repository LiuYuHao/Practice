import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find the total amount of spot where the queen(chess) can attack on.
Input: int n, int k, int r_q, int c_q, a 2-d array named obstacles
    => size of broad, amount of obstacles, row of queen, column of queen, the postion of obstacles
*/
public class QueensAttack2 {

    // Complete the queensAttack function below.
  static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
      /* brute force solution
        int[][] broad = new int[n + 1][n + 1];
        broad[r_q][c_q] = 2;
        for (int i = 0; i < obstacles.length; i++) {
            broad[obstacles[i][0]][obstacles[i][1]] = 1;
        }
        // for (int i = 1; i < broad.length; i++) {
        //     for (int j = 1; j < broad.length; j++) {
        //         System.out.print(broad[i][j] + " ");
        //     }
        //     System.out.println("");
        // }
        int max_attacks = 0;
        // down
        for (int i = c_q + 1; i <= n; i++) {
            if (broad[r_q][i] != 1) {
                max_attacks += 1;
            }
            else {
                break;
            }
        }
        System.out.println("down" + max_attacks);
        // up
        for (int i = c_q - 1; i > 0; i--) {
            if (broad[r_q][i] != 1) {
                max_attacks += 1;
            }
            else {
                break;
            }
        }
        System.out.println("up" + max_attacks);
        // left
        for (int i = r_q - 1; i > 0; i--) {
            if (broad[i][c_q] != 1) {
                max_attacks += 1;
            }
            else {
                break;
            }
        }
        System.out.println("left" + max_attacks);
        // right
        for (int i = r_q + 1; i <= n; i++) {
            if (broad[i][c_q] != 1) {
                max_attacks += 1;
            }
            else {
                break;
            }
        }
        System.out.println("right" + max_attacks);
        // top left
        for (int i = r_q - 1, j = c_q - 1; i > 0 && j > 0; i--, j--) {
            if (broad[i][j] != 1) {
                max_attacks += 1;
            }
            else {
                break;
            }
        }
        System.out.println("top left" + max_attacks);
        // top right
        for (int i = r_q - 1, j = c_q + 1; i > 0 && j <= n; i--, j++) {
            if (broad[i][j] != 1) {
                max_attacks += 1;
            }
            else {
                break;
            }
        }
        System.out.println("top right" + max_attacks);
        // bottom right
        for (int i = r_q + 1, j = c_q + 1; i <= n && j <= n; i++, j++) {
            if (broad[i][j] != 1) {
                max_attacks += 1;
            }
            else {
                break;
            }
        }
        System.out.println("bottom right" + max_attacks);
        // bottom left
        for (int i = r_q + 1, j = c_q - 1; i <= n && j > 0; i++, j--) {
            if (broad[i][j] != 1) {
                max_attacks += 1;
            }
            else {
                break;
            }
        }
        System.out.println("bottomr left" + max_attacks);
        return max_attacks;
        */
        int max_attacks = 0;
        int top_left = 0;
        int top_right = 0;
        int bottom_left = 0;
        int bottom_right = 0;
        for (int i = r_q - 1, j = c_q - 1; i > 0 && j > 0; i--, j--) {
          top_left++;
        }
        for (int i = r_q - 1, j = c_q + 1; i > 0 && j <= n; i--, j++) {
          top_right++;
        }
        for (int i = r_q + 1, j = c_q + 1; i <= n && j <= n; i++, j++) {
          bottom_right++;
        }
        for (int i = r_q + 1, j = c_q - 1; i <= n && j > 0; i++, j--) {
          bottom_left++;
        }
        if (k == 0) {
          max_attacks += (n - 1) + (n - 1);
          max_attacks = max_attacks + top_left + top_right + bottom_left + bottom_right;
        }
        else {
          int top = r_q - 1;
          int down = n - r_q;
          int left = c_q - 1;
          int right = n - c_q;
          for (int i = 0; i < obstacles.length; i++) {
            if (obstacles[i][1] == c_q && obstacles[i][0] < r_q) {
              if (r_q - obstacles[i][0] - 1 < top) {
                top = r_q - obstacles[i][0] - 1;
              }
            }
            else if (obstacles[i][1] == c_q && obstacles[i][0] > r_q) {
              if (obstacles[i][0] - r_q - 1 < down) {
                down = obstacles[i][0] - r_q - 1;
              }
            }
            else if (obstacles[i][0] == r_q && obstacles[i][1] < c_q) {
              if (c_q - obstacles[i][1] - 1 < left) {
                left = c_q - obstacles[i][1] - 1;
              }
            }
            else if (obstacles[i][0] == r_q && obstacles[i][1] > c_q) {
              if (obstacles[i][1] - c_q - 1 < right) {
                right = obstacles[i][1] - c_q - 1;
              }
            }
            else if (Math.abs(obstacles[i][0] - r_q) == Math.abs(obstacles[i][1] - c_q)) {
              int difference = Math.abs(obstacles[i][0] - r_q);
              if (obstacles[i][0] < r_q && obstacles[i][1] < c_q) {
                if (difference < top_left) {
                  top_left = difference - 1;
                }
              }
              else if (obstacles[i][0] > r_q && obstacles[i][1] > c_q) {
                if (difference < bottom_right) {
                  bottom_right = difference - 1;
                }
              }
              else if (obstacles[i][0] < r_q && obstacles[i][1] > c_q) {
                if (difference < top_right) {
                  top_right = difference - 1;
                }
              }
              if (obstacles[i][0] > r_q && obstacles[i][1] < c_q) {
                if (difference < bottom_left) {
                  bottom_left = difference - 1;
                }
              }
            }
          }
          max_attacks = max_attacks + top + down + left + right + top_left + top_right + bottom_left + bottom_right;
          //System.out.println(top + " " + down + " " + left + " " + right);
        }
        return max_attacks;
      }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

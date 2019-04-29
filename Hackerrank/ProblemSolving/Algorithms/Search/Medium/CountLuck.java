import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: from M to * in a matrix. Calculate if the amount of prediction corrrect or not. The prediction is happen when facing more than one path.
Input: a string array named Matrix(our map), a k the predictions.
Output: return a string of Oops! and Impressed => if the prediction is not match to actual amount of decision makings print Oops!.
        if matched Print Impressed
*/
class Point {
    public int x;
    public int y;
    public int count = 0;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class CountLuck {

    // Complete the countLuck function below.
    static String countLuck(String[] matrix, int k) {
        //System.out.println(matrix.length + " " + matrix[0].length());
        char[][] c_matrix = new char[matrix.length][matrix[0].length()];
        int m_x = 0;
        int m_y = 0;
        int t_x = 0;
        int t_y = 0;
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length(); j++) {
                c_matrix[i][j] = matrix[i].charAt(j);
                if (matrix[i].charAt(j) == 'M') {
                    m_x = i;
                    m_y = j;
                }
                else if (matrix[i].charAt(j) == '*') {
                    t_x = i;
                    t_y = j;
                }
            }
        }
        Queue<Point> q = new LinkedList<>();
        Point start = new Point(m_x,m_y);
        q.add(start);
        while(q.size() != 0) {
            Point p = q.poll();
            if (p.x == t_x && p.y == t_y) {
                count = p.count;
                break;
            }
            else {
                //System.out.println(p.x + " " + p.y);
                c_matrix[p.x][p.y] = 'X';
                boolean left_check = false;
                boolean right_check = false;
                boolean top_check = false;
                boolean bottom_check = false;
                int left = p.y - 1;
                int right = p.y + 1;
                int top = p.x - 1;
                int bottom = p.x + 1;
                if (left > - 1 && c_matrix[p.x][left] != 'X') {
                    left_check = true;
                }
                if (top > - 1 && c_matrix[top][p.y] != 'X') {
                    top_check = true;
                }
                if (right < c_matrix[0].length && c_matrix[p.x][right] != 'X') {
                    right_check = true;
                }
                if (bottom < c_matrix.length && c_matrix[bottom][p.y] != 'X') {
                    bottom_check = true;
                }
                //System.out.println(left_check + " " + right_check + " " + top_check + " " + bottom_check);
                if (left_check == true) {
                    if (top_check == true) {
                        p.count = p.count + 1;
                    }
                    else if (right_check == true) {
                        p.count = p.count + 1;
                    }
                    else if (bottom_check == true) {
                        p.count = p.count + 1;
                    }
                }
                else if (right_check == true) {
                    if (top_check == true) {
                        p.count = p.count + 1;
                    }
                    else if (bottom_check == true) {
                        p.count = p.count + 1;
                    }
                }
                else if (top_check == true) {
                    if (bottom_check == true) {
                        p.count = p.count + 1;
                    }
                }
                if (left_check) {
                    Point tem = new Point(p.x, left);
                    tem.count = p.count;
                    q.add(tem);
                }
                if (right_check) {
                    Point tem = new Point(p.x, right);
                    tem.count = p.count;
                    q.add(tem);
                }
                if (top_check) {
                    Point tem = new Point(top, p.y);
                    tem.count = p.count;
                    q.add(tem);
                }
                if (bottom_check) {
                    Point tem = new Point(bottom, p.y);
                    tem.count = p.count;
                    q.add(tem);
                }
            }
        }
        //System.out.println(count);
        if (count == k) {
            return "Impressed";
        }
        return "Oops!";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            String[] matrix = new String[n];

            for (int i = 0; i < n; i++) {
                String matrixItem = scanner.nextLine();
                matrix[i] = matrixItem;
            }

            int k = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = countLuck(matrix, k);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

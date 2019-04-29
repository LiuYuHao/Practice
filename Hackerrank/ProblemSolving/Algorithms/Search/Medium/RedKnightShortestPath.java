import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: red knight only move 6 kind of movement, 4 movement like knight in chess, and left and right => move left 2 and move right 2.
      Calculate the shorest path and print the path by the prioirty order of UL, UR, R, LR, LL, L
*/
class Point {
    public int x;
    public int y;
    public int count = 1;
    public ArrayList<String> al = new ArrayList<>();
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class RedKnightShorestPath {

    // Complete the printShortestPath function below.
    static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
        // Print the distance along with the sequence of moves.
        int[][] chessboard = new int[n][n];
        chessboard[i_start][j_start] = -1;
        Queue<Point> q = new LinkedList<>();
        if (i_start - 2 > -1) {
            if (j_start - 1 > -1) {
                Point temp = new Point(i_start - 2, j_start - 1);
                temp.al.add("UL");
                q.add(temp);
            }
            if (j_start + 1 < n) {
                Point temp = new Point(i_start - 2, j_start + 1);
                temp.al.add("UR");
                q.add(temp);
            }
        }
        if (j_start + 2 < n) {
            Point temp = new Point(i_start, j_start + 2);
            temp.al.add("R");
            q.add(temp);
        }
        if (i_start + 2 < n) {
            if (j_start + 1 < n) {
                Point temp = new Point(i_start + 2, j_start + 1);
                temp.al.add("LR");
                q.add(temp);
            }
            if (j_start - 1 > -1) {
                Point temp = new Point(i_start + 2, j_start - 1);
                temp.al.add("LL");
                q.add(temp);
            }
        }
        if (j_start - 2 > -1) {
            Point temp = new Point(i_start, j_start - 1);
            temp.al.add("L");
            q.add(temp);
        }
        //System.out.println(q.size());
        //ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        while (q.size() != 0) {
            Point data = q.poll();
            if (data.x == i_end && data.y == j_end) {
                result = data.al;
                //System.out.println(data.al);
                break;
                //System.out.println(data.al);
                //result.add(data.al);
            }
            else {
                chessboard[data.x][data.y] = -1;
                if (data.x - 2 > -1) {
                    if (data.y - 1 > -1 && chessboard[data.x -2][data.y -1] != -1) {
                        Point temp = new Point(data.x - 2, data.y - 1);
                        temp.al = (ArrayList<String>) data.al.clone();
                        temp.al.add("UL");
                        q.add(temp);
                    }
                    if (data.y + 1 < n && chessboard[data.x -2][data.y +1] != -1) {
                        Point temp = new Point(data.x - 2, data.y + 1);
                        temp.al = (ArrayList<String>)data.al.clone();
                        temp.al.add("UR");
                        q.add(temp);
                    }
                }
                if (data.y + 2 < n && chessboard[data.x][data.y +2] != -1) {
                    Point temp = new Point(data.x, data.y + 2);
                    temp.al = (ArrayList<String>)data.al.clone();
                    temp.al.add("R");
                    q.add(temp);
                }
                if (data.x + 2 < n) {
                    if (data.y - 1 > -1 && chessboard[data.x +2][data.y -1] != -1) {
                        Point temp = new Point(data.x + 2, data.y - 1);
                        temp.al = (ArrayList<String>)data.al.clone();
                        temp.al.add("LL");
                        q.add(temp);
                    }
                    if (data.y + 1 < n && chessboard[data.x +2][data.y +1] != -1) {
                        Point temp = new Point(data.x + 2, data.y + 1);
                        temp.al = (ArrayList<String>)data.al.clone();
                        temp.al.add("LR");
                        q.add(temp);
                    }
                }
                if (data.y - 2 > -1 && chessboard[data.x][data.y -2] != -1) {
                    Point temp = new Point(data.x, data.y - 2);
                    temp.al = (ArrayList<String>)data.al.clone();
                    temp.al.add("L");
                    q.add(temp);
                }
            }
        }
        if (result.size() == 0) {
            System.out.println("Impossible");
        }
        else {
            System.out.println(result.size());
            for(String s : result) {
                System.out.print(s + " ");
            }
        }
        // else {
        //     int smallest_size = result.get(0).size();
        //     for (int i = 1; i < result.size(); i++) {
        //         if (result.get(i).size() < smallest_size) {
        //             smallest_size = result.get(i).size();
        //         }
        //     }
        //     System.out.println(smallest_size);
        //     ArrayList<ArrayList<String>> small_result = new ArrayList<>();
        //     for (ArrayList<String> a : result) {
        //         if (a.size() == smallest_size) {
        //             small_result.add(a);
        //         }
        //     }
        //     if (small_result.size() == 1) {
        //         for(String s : small_result.get(0)) {
        //             System.out.print(s + " ");
        //         }
        //     }
        //     else {
        //         ArrayList<ArrayList<String>> final_answer = new ArrayList<>();
        //         HashMap<String, Integer> order= new HashMap<>();
        //         order.put("UL", 6);
        //         order.put("UR", 5);
        //         order.put("R", 4);
        //         order.put("LR", 3);
        //         order.put("LL",2);
        //         order.put("L",1);
        //         int index = 0;
        //         //System.out.println(small_result);
        //         while (small_result.size() != 1) {
        //             String highest = small_result.get(0).get(index);
        //             for (int i = 1; i < small_result.size(); i++) {
        //                 int number = order.get(highest);
        //                 if (order.get(small_result.get(i).get(index)) > number) {
        //                     highest = small_result.get(i).get(index);
        //                 }
        //             }
        //             for (ArrayList<String> a : small_result) {
        //                 if (a.get(index).equals(highest)) {
        //                     final_answer.add(a);
        //                 }
        //             }
        //             index++;
        //             small_result = (ArrayList<ArrayList<String>>)final_answer.clone();
        //             final_answer.clear();
        //         }
        //         for(String s : small_result.get(0)) {
        //             System.out.print(s + " ");
        //         }
        //     }
        // }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] i_startJ_start = scanner.nextLine().split(" ");

        int i_start = Integer.parseInt(i_startJ_start[0]);

        int j_start = Integer.parseInt(i_startJ_start[1]);

        int i_end = Integer.parseInt(i_startJ_start[2]);

        int j_end = Integer.parseInt(i_startJ_start[3]);

        printShortestPath(n, i_start, j_start, i_end, j_end);

        scanner.close();
    }
}

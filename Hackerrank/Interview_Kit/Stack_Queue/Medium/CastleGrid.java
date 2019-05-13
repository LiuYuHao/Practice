import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find the shortest path(count the lower turns(edges)) from start to target. X are obstacle
Input: n => size of grid
       S...
       S... => String for each N lines to represent the grid
       x x x x => Integer ordered as startX and Y, then goalX and Y;
Output: print the shortest turns(edges) to get the goal
*/
public class CastleGrid {

    // Complete the minimumMoves function below.
    static class Node {
        int old_x;
        int old_y;
        int x;
        int y;
        int count;
        String direction;
        public Node(int old_x, int old_y, int x,int y,int count, String direction) {
            this.x = x;
            this.old_x = old_x;
            this.y = y;
            this.old_y = old_y;
            this.count = count;
            this.direction = direction;
        }
    }
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY)    {
        if (startX == goalX && startY == goalY) {
            return 0;
        }
        grid[startX] = grid[startX].substring(0, startY) + "X" + grid[startX].substring(startY + 1, grid[startX].length());
        Queue<Node> q = new LinkedList<>();
        int down_X = startX;
        int up_X = startX;
        int left_Y = startY;
        int right_Y = startY;
        ArrayList<Integer> al = new ArrayList<>();
        int count = 0;
        while (down_X + 1 < grid.length && grid[down_X + 1].charAt(startY) != 'X') {
            down_X++;
            q.add(new Node(startX,startY,down_X, startY, 1, "down"));
        }
        while (up_X - 1 >= 0 && grid[up_X - 1].charAt(startY) != 'X') {
            up_X--;
            q.add(new Node(startX,startY,up_X, startY, 1, "up"));
        }
        while (left_Y - 1>= 0 && grid[startX].charAt(left_Y - 1) != 'X') {
            left_Y--;
            q.add(new Node(startX,startY, startX, left_Y, 1, "left"));
        }
        while (right_Y + 1 < grid.length && grid[startX].charAt(right_Y + 1) != 'X') {
            right_Y++;
            q.add(new Node(startX,startY,startX, right_Y, 1, "right"));
        }
        while (q.size() != 0) {
            Node copy = q.poll();
            //System.out.println(copy.x + " " + copy.y + " " + copy.old_x + " " + copy.old_y);
            if (copy.x == goalX && copy.y == goalY) {
                al.add(copy.count);
            }
            else if (copy.direction.equals("down") || copy.direction.equals("up")) {
                grid[copy.x] = grid[copy.x].substring(0, copy.y) + "X" + grid[copy.x].substring(copy.y + 1, grid[copy.x].length());
                if (copy.x != copy.old_x && copy.y == copy.old_y) {
                    left_Y = copy.y;
                    right_Y = copy.y;
                    while (left_Y - 1 >= 0 && grid[copy.x].charAt(left_Y - 1) != 'X') {
                        left_Y--;
                        q.add(new Node(copy.x,copy.y, copy.x, left_Y, copy.count + 1, "left"));
                    }
                    while (right_Y + 1 < grid.length && grid[copy.x].charAt(right_Y + 1) != 'X'){
                        right_Y++;
                        q.add(new Node(copy.x,copy.y, copy.x, right_Y, copy.count + 1, "right"));
                    }
                }
            }
            else if (copy.direction.equals("left") || copy.direction.equals("right")) {
                grid[copy.x] = grid[copy.x].substring(0, copy.y) + "X" + grid[copy.x].substring(copy.y + 1, grid[copy.x].length());
                if (copy.x == copy.old_x && copy.y != copy.old_y) {
                    up_X = copy.x;
                    down_X = copy.x;
                    while (up_X- 1 >= 0 && grid[up_X - 1].charAt(copy.y) != 'X') {
                        up_X--;
                        q.add(new Node(copy.x,copy.y, up_X, copy.y, copy.count + 1, "up"));
                    }
                    while (down_X + 1 < grid.length && grid[down_X + 1].charAt(copy.y) != 'X'){
                        down_X++;
                        q.add(new Node(copy.x,copy.y, down_X, copy.y, copy.count + 1, "down"));
                    }
                }
            }
        }
        return Collections.min(al);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] startXStartY = scanner.nextLine().split(" ");

        int startX = Integer.parseInt(startXStartY[0]);

        int startY = Integer.parseInt(startXStartY[1]);

        int goalX = Integer.parseInt(startXStartY[2]);

        int goalY = Integer.parseInt(startXStartY[3]);

        int result = minimumMoves(grid, startX, startY, goalX, goalY);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

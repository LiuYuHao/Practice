import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: connect all the cell in the matrix, find the biggest group by print out the sum of all the one inside of region
      cell can be reach to his neiborhood throught vertically, horizontally and diagonally
Input: a grid 2d matrix
Ouput: a int to represent the highest sum of all the regions
*/
class Pair{
    public int x;
    public int y;
    public Pair head;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
        this.head = null;
    }
    public Pair(int x, int y, Pair head) {
        this.x = x;
        this.y = y;
        this.head = head;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        else if (!(o instanceof Pair)) {
            return false;
        }
        else {
            Pair p = (Pair) o;
            return this.x == p.x && this.y == p.y;
        }
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(this.x) * Integer.hashCode(this.y);
    }
    @Override
    public String toString() {
        return Integer.toString(this.x) + " " + Integer.toString(this.y);
    }
}
public class CConnectedCells {

    // Complete the maxRegion function below.
    static int maxRegion(int[][] grid) {
        Stack<Pair> s = new Stack<>();
        int[][] check = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0;  j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    s.push(new Pair(i, j));
                }
            }
        }
        HashMap<Pair, HashSet<Pair>> hm = new HashMap<>();
        while(!s.empty()) {
            //System.out.println(hm);
            Pair data = s.pop();
            if (check[data.x][data.y] == 0 && data.head == null) {
                HashSet<Pair> hs = new HashSet<>();
                hs.add(data);
                hm.put(data, hs);
                check[data.x][data.y] = 1;
                if (data.x - 1 > - 1 && grid[data.x - 1][data.y] == 1 && check[data.x - 1][data.y] == 0) {
                    s.push(new Pair(data.x - 1, data.y, data));
                }
                if (data.x + 1 < grid.length && grid[data.x + 1][data.y] == 1 && check[data.x + 1][data.y] == 0) {
                    s.push(new Pair(data.x + 1, data.y, data));
                }
                if (data.y + 1 < grid[0].length && grid[data.x][data.y + 1] == 1 && check[data.x][data.y + 1] == 0) {
                    s.push(new Pair(data.x, data.y + 1, data));
                }
                if (data.y - 1 > -1 && grid[data.x][data.y - 1] == 1 && check[data.x][data.y - 1] == 0) {
                    s.push(new Pair(data.x, data.y - 1, data));
                }
                if (data.y - 1 > -1 && data.x - 1 > - 1 && grid[data.x - 1][data.y - 1] == 1 && check[data.x - 1][data.y - 1] == 0) {
                    s.push(new Pair(data.x - 1, data.y - 1, data));
                }
                if (data.y + 1 < grid[0].length && data.x - 1 > - 1 && grid[data.x - 1][data.y + 1] == 1 && check[data.x - 1][data.y + 1] == 0) {
                    s.push(new Pair(data.x - 1, data.y + 1, data));
                }
                if (data.y - 1 > -1 && data.x + 1 < grid.length && grid[data.x + 1][data.y - 1] == 1 && check[data.x + 1][data.y - 1] == 0) {
                    s.push(new Pair(data.x + 1, data.y - 1, data));
                }
                if (data.y + 1 < grid[0].length && data.x + 1 < grid.length && grid[data.x + 1][data.y + 1] == 1 && check[data.x + 1][data.y + 1] == 0) {
                    s.push(new Pair(data.x + 1, data.y + 1, data));
                }
            }
            else if (check[data.x][data.y] == 0 && data.head != null) {
                System.out.println(data.x + " " + data.y);
                check[data.x][data.y] = 1;
                hm.get(data.head).add(data);
                if (data.x - 1 > - 1 && grid[data.x - 1][data.y] == 1 && check[data.x - 1][data.y] == 0) {
                    s.push(new Pair(data.x - 1, data.y, data.head));
                }
                if (data.x + 1 < grid.length && grid[data.x + 1][data.y] == 1 && check[data.x + 1][data.y] == 0) {
                    s.push(new Pair(data.x + 1, data.y, data.head));
                }
                if (data.y + 1 < grid[0].length && grid[data.x][data.y + 1] == 1 && check[data.x][data.y + 1] == 0) {
                    s.push(new Pair(data.x, data.y + 1, data.head));
                }
                if (data.y - 1 > -1 && grid[data.x][data.y - 1] == 1 && check[data.x][data.y - 1] == 0) {
                    s.push(new Pair(data.x, data.y - 1, data.head));
                }
                if (data.y - 1 > -1 && data.x - 1 > - 1 && grid[data.x - 1][data.y - 1] == 1 && check[data.x - 1][data.y - 1] == 0) {
                        s.push(new Pair(data.x - 1, data.y - 1, data.head));
                }
                if (data.y + 1 < grid[0].length && data.x - 1 > - 1 && grid[data.x - 1][data.y + 1] == 1 && check[data.x - 1][data.y + 1] == 0) {
                    s.push(new Pair(data.x - 1, data.y + 1, data.head));
                }
                if (data.y - 1 > -1 && data.x + 1 < grid.length && grid[data.x + 1][data.y - 1] == 1 && check[data.x + 1][data.y - 1] == 0) {
                        s.push(new Pair(data.x + 1, data.y - 1, data.head));
                }
                if (data.y + 1 < grid[0].length && data.x + 1 < grid.length && grid[data.x + 1][data.y + 1] == 1 && check[data.x + 1][data.y + 1] == 0) {
                        s.push(new Pair(data.x + 1, data.y + 1, data.head));
                }
            }
        }
        int sum = 0;
        for (Map.Entry<Pair, HashSet<Pair>> e : hm.entrySet()) {
            //System.out.println(e.getValue());
            if (e.getValue().size() > sum) {
                sum = e.getValue().size();
            }
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] gridRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int gridItem = Integer.parseInt(gridRowItems[j]);
                grid[i][j] = gridItem;
            }
        }

        int res = maxRegion(grid);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

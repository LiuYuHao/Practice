import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: to find a number in a matrix where it is biggest than everyone it surround (diagonal number is exclusive) replace with x
Input: a String array
Ouput: a String array where replace x to all number match to the condition
*/
class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Solution {

    // Complete the cavityMap function below.
    static String[] cavityMap(String[] grid) {
        String[][] map = new String[grid.length][grid[0].length()];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Character.toString(grid[i].charAt(j));
            }
        }
        // for(String[] x : map) {
        //     for (String y : x) {
        //         System.out.print(y);
        //     }
        //     System.out.println("");
        // }
        // System.out.println(map[0][0]);
        ArrayList<Pair> al = new ArrayList<>();
        for (int i = 1; i < map.length - 1; i++) {
            for (int j = 1; j < map[i].length - 1; j++) {
                int center = Integer.parseInt(map[i][j]);
                int top = Integer.parseInt(map[i - 1][j]);
                int left = Integer.parseInt(map[i][j-1]);
                int right = Integer.parseInt(map[i][j + 1]);
                int bottom = Integer.parseInt(map[i + 1][j]);
                if (center > top && center > left && center > right && center > bottom) {
                    al.add(new Pair(i,j));
                }
            }
        }
        for (int i = 0; i < al.size(); i++) {
            map[al.get(i).x][al.get(i).y] = "X";
        }
        String[] result = new String[grid.length];
        for (int i = 0; i < map.length; i++) {
            String data = "";
            for (int j = 0; j < map[i].length; j++) {
                data += map[i][j];
            }
            result[i] = data;
        }
        return result;
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

        String[] result = cavityMap(grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

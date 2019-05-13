import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
// repeated ProblemSolving/Algorithmns/String/Medium
/*
Task: find the commonChild of two string, abcd  and abdc = > abc or abd by remove d or c.
Input: two string s1 and s2
Output: return a Int where shows the max size of commonChild of s1 and s2
*/
class Data {
    public int x;
    public int y;
    public int count;
    public int index;
    public Data(int x, int y, int count,int index) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.index = index;
    }
}
public class CommonChild {
  // using longest common subsequence methods
    static int commonChild(String s1, String s2) {
      int[][] grid = new int[s1.length() + 1][s2.length() + 1];
      for (int i = 0; i <= s1.length(); i++) {
          for (int j = 0; j <= s2.length(); j++) {
              if (i == 0 || j == 0) {
                  grid[i][j] = 0;
              }
              else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                  grid[i][j] = grid[i - 1][j - 1] + 1;
              }
              else {
                  grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]);
              }
          }
      }
      return grid[s1.length()][s2.length()];
  }
    // Complete the commonChild function below.
    // Brute force solution
    // static int commonChild(String s1, String s2) {
    //     int max = 0;
    //     ArrayList<Integer> al_s1 = new ArrayList<>();
    //     ArrayList<Integer> al_s2 = new ArrayList<>();
    //     for (int i = 0; i < s1.length(); i++) {
    //         for (int j = 0; j < s2.length(); j++) {
    //             if (s1.charAt(i) == s2.charAt(j)) {
    //                 al_s1.add(i);
    //                 al_s2.add(j);
    //             }
    //         }
    //     }
    //     Queue<Data> q = new LinkedList<>();
    //     for (int i = 0; i < al_s1.size(); i++) {
    //         Data data = new Data(al_s1.get(i), al_s2.get(i), 1, i);
    //         q.add(data);
    //     }
    //     while (q.size() != 0) {
    //         Data data = q.poll();
    //         for (int i = data.index + 1; i < al_s1.size(); i++) {
    //             if (al_s1.get(i) > data.x && al_s2.get(i) > data.y) {
    //                 q.add(new Data(al_s1.get(i), al_s2.get(i), data.count + 1,i));
    //             }
    //         }
    //         if (data.count > max) {
    //             max = data.count;
    //         }
    //     }
        //System.out.println(max);
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

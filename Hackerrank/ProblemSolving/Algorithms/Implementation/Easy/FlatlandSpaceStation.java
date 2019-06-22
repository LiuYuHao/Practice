import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find the max distance for a city without space station to the city with space station
Input: a int n (amonut of cities 0 to n-1), a array c which indicate which cities has space station
Output: a int for the max distance
*/
public class Solution {

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
        if (n  == c.length) {
            return 0;
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < c.length; i++) {
            hs.add(c[i]);
        }
        int max_distance = 0;
        int cities_no_station = 0;
        int cities_station = 0;
        int distance = 0;
        for (int i = 0; i < n; i++) {
            if (hs.contains(i)) {
                cities_station++;
                if (cities_no_station != 0) {
                    if (cities_station == 2) {
                        distance = (cities_no_station + 1) /2;
                    }
                    else {
                        distance = cities_no_station;
                    }
                    cities_no_station = 0;
                    cities_station = 1;
                    if (distance > max_distance) {
                        max_distance = distance;
                    }
                }
                else if (cities_no_station == 0 && cities_station == 2) {
                    cities_station = 1;
                }
            }
            else {
                cities_no_station++;
            }
            //System.out.println(i + " " + cities_no_station + " " + cities_station + " " + distance);
        }
        if (cities_no_station > max_distance) {
            max_distance = cities_no_station;
        }
        return max_distance;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

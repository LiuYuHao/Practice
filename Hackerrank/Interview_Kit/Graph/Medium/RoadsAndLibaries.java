import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: based on the roads and amount of cities, we need to reconstruct the city where all the citizens are able to have a path to
      a city where contain library. Therefore, we need to build road and library with minimum cost
Input: a int n (number of city), int c_lib (cost of library), int c_road (cost of road), a two d int cities the roads between two cities
Output: a long where shows min cost to reconstruct the city.

*/
class Pair {
    public int x;
    public int head;
    public Pair(int x) {
        this.x = x;
        this.head = -1;
    }
    public Pair(int x, int head) {
        this.x = x;
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
            return this.x == p.x && this.head == p.head;
        }
    }
    @Override
    public String toString() {
        return Integer.toString(this.x);
    }
}
public class RoadsAndLibraries {

    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        if (c_lib < c_road) {
            return (long) c_lib * n;
        }
        ArrayList<Integer> check = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            check.add(0);
        }
        //int[][] matrix = new int[n + 1][n +1];
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            matrix.add((ArrayList<Integer>) check.clone());
        }
        Stack<Pair> s = new Stack<>();
        for (int i = 0; i < cities.length; i++) {
            matrix.get(cities[i][0]).set(cities[i][1], 1);
            //matrix[cities[i][0]][cities[i][1]] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            s.push(new Pair(i));
        }
        HashMap<Integer, HashSet<Pair>> hm = new HashMap<>();
        while(!s.empty()) {
            Pair data = s.pop();
            if (check.get(data.x) == 0 && data.head == -1) {
                check.set(data.x, 1);
                HashSet<Pair> hs = new HashSet<>();
                hs.add(data);
                hm.put(data.x,hs);
                for (int i = 1; i < n + 1; i++) {
                    if (i != data.x && (matrix.get(data.x).get(i) == 1 || matrix.get(i).get(data.x) == 1) && check.get(i) == 0) {
                        //s.remove(new Pair(i, -1));
                        s.push(new Pair(i, data.x));
                    }
                }
            }
            else if (check.get(data.x) == 0 && data.head != -1) {
                check.set(data.x, 1);
                hm.get(data.head).add(data);
                for (int i = 1; i < n + 1; i++) {
                    if (i != data.x && (matrix.get(data.x).get(i) == 1 || matrix.get(i).get(data.x) == 1) && check.get(i) == 0) {
                        s.push(new Pair(i, data.head));
                    }
                }
            }
        }
        //System.out.println(hm);
        long sum = 0;
        for (Map.Entry<Integer, HashSet<Pair>> e : hm.entrySet()) {
            sum += (long) (e.getValue().size() - 1) * c_road;
        }
        sum += (long) c_lib * hm.size();
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

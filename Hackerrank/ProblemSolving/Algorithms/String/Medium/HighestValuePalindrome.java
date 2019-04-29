import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find the highest palindrome under the max changes.
Input: one s contained all Integer string, n = the size of Integer, and k = amount of changes
Output: a string => -1 for unable to make it into palindrome, or return a highest value of palindrome
*/
public class HighestValuePalindrome {

    // Complete the highestValuePalindrome function below.
    static String highestValuePalindrome(String s, int n, int k) {
        String result = "";
        String[] container = s.split("");
        LinkedHashMap<Integer, Integer> lhm_position = new LinkedHashMap<>();
        //ArrayList<Integer> al_position = new ArrayList<>();
        for (int i = 0; i < n/2; i++) {
            // System.out.println(n - i - 1);
            if (!(container[i].equals(container[n - i - 1]))) {
                //al_position.add(i);
                lhm_position.put(i,i);
            }
        }
        //System.out.println(al_position);
        //System.out.println(lhm_position);
        int difference = k - lhm_position.size();
        if (lhm_position.size() > k) {
            return "-1";
        }
        else {
            if (difference > 1) {
                for (int i = 0; i < n/2; i++) {
                    if (difference < 2) {
                        break;
                    }
                    int x = Integer.parseInt(container[i]);
                    int y = Integer.parseInt(container[n - i - 1]);
                    if (x != 9 && y != 9) {
                        if (lhm_position.containsKey(i)) {
                            difference--;
                            lhm_position.remove(i);
                            container[i] = Integer.toString(9);
                            container[n - i - 1] = Integer.toString(9);
                        }
                        else {
                            difference = difference - 2;
                            lhm_position.remove(i); // this is funny, because this reduce time complexity somehow.
                                                    // if remove it, there is one case will not passed.
                                                    // but logically, this is useless but it is under the statement where
                                                    // i is not in lhm_position
                            container[i] = Integer.toString(9);
                            container[n - i - 1] = Integer.toString(9);
                        }
                    }
                    else if ((x != 9 && y == 9) || (x == 9 && y != 9)) {
                        if (lhm_position.containsKey(i)) {
                            lhm_position.remove(i);
                            container[i] = Integer.toString(9);
                            container[n - i - 1] = Integer.toString(9);
                        }
                        else {
                            difference--;
                            lhm_position.remove(i); // same as above
                            container[i] = Integer.toString(9);
                            container[n - i - 1] = Integer.toString(9);
                        }
                    }
                }
            }
            if (difference <= 1) {
                for (Map.Entry<Integer, Integer> e: lhm_position.entrySet()) {
                    int x = Integer.parseInt(container[e.getKey()]);
                    int y = Integer.parseInt(container[n - e.getKey() - 1]);
                    if (x != 9 && y != 9 && difference == 1) {
                        container[e.getKey()] = Integer.toString(9);
                        container[n - e.getKey() - 1] = Integer.toString(9);
                        difference--;
                    }
                    else {
                        int z = Math.max(x,y);
                        container[e.getKey()] = Integer.toString(z);
                        container[n - e.getKey() - 1] = Integer.toString(z);
                    }
                }
            }
        }
        if (difference > 0 && s.length() % 2 == 1) {
            container[s.length() / 2] = "9";
        }
        for (int i = 0; i < n; i++) {
            result += container[i];
        }
        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String s = scanner.nextLine();

        String result = highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

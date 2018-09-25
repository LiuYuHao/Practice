import java.util.*;

/*
Task
input:
a int K and one string S
output:
the smallest and largest of substring size of k of s
*/
public class SubstringComparisons {
  public static String getSmallestAndLargest(String s, int k) {
    String smallest = "";
    String largest = "";
    smallest = s.substring(0,k);
    largest = s.substring(0,k);
    for (int i = 1; k+i <= s.length(); i++) {
        String substring = s.substring(i,k+i);
        if (substring.compareTo(smallest) <= 0) {
            smallest = substring;
        }
        if (substring.compareTo(largest) > 0) {
            largest = substring;
        }
    }
    // Complete the function
    // 'smallest' must be the lexicographically smallest substring of length 'k'
    // 'largest' must be the lexicographically largest substring of length 'k'

    return smallest + "\n" + largest;
  }
  public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}

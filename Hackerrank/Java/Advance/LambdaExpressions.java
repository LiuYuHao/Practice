import java.io.*;
import java.util.*;
/*
Task: Use lambda expression to create functions which deal with prime, odd and palindrome
*/
interface PerformOperation {
 boolean check(int a);
}
class MyMath {
 public static boolean checker(PerformOperation p, int num) {
  return p.check(num);
 }
public static PerformOperation isOdd() {
    PerformOperation op = (int x) -> x % 2 != 0;
    return op;
}
public static PerformOperation isPrime() {
    PerformOperation op = (int x) -> {
        if (x < 2) {
            return false;
        }
        if (x == 2) {
            return true;
        }
        for (int i = 2; i < x; i++) {
            if ( x % i == 0) {
                return false;
            }
        }
        return true;
    };
    return op;
}
public static PerformOperation isPalindrome() {
    PerformOperation op = (int x) -> {
        String x_string = Integer.toString(x);
        String[] x_array = x_string.split("");
        for (int i = 0; i < x_array.length/2;i++) {
            if (!(x_array[i].equals(x_array[x_array.length -i -1]))) {
                return false;
            }
        }
        return true;
    };
    return op;
}
}
   // Write your code here

public class Solution {

 public static void main(String[] args) throws IOException {
  MyMath ob = new MyMath();
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int T = Integer.parseInt(br.readLine());
  PerformOperation op;
  boolean ret = false;
  String ans = null;
  while (T--> 0) {
   String s = br.readLine().trim();
   StringTokenizer st = new StringTokenizer(s);
   int ch = Integer.parseInt(st.nextToken());
   int num = Integer.parseInt(st.nextToken());
   if (ch == 1) {
    op = ob.isOdd();
    ret = ob.checker(op, num);
    ans = (ret) ? "ODD" : "EVEN";
   } else if (ch == 2) {
    op = ob.isPrime();
    ret = ob.checker(op, num);
    ans = (ret) ? "PRIME" : "COMPOSITE";
   } else if (ch == 3) {
    op = ob.isPalindrome();
    ret = ob.checker(op, num);
    ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

   }
   System.out.println(ans);
  }
 }
}

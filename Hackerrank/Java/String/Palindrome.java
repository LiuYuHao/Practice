import java.io.*;
import java.util.*;

/*
task
input:
a string S
output:
yes for palindrome
no if not.
*/
public class Palindrome {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        int test = 0;
        for (int i = 0; i < A.length()/2; i++) {
            if (A.charAt(i) != A.charAt(A.length()-i-1)) {
                System.out.println("No");
                test = 1;
                break;
            }
        }
        if (test == 0) {
            System.out.println("Yes");
        }
        /* Enter your code here. Print output to STDOUT. */

    }
}

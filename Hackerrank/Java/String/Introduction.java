import java.io.*;
import java.util.*;

/*
Task
input:
two Stirng A and B
Output:
Sum of both
lexicographically compare
combine with first letter uppercase.
*/
public class Introduction {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(A.length() + B.length());
        if (A.compareTo(B) <= 0) {
            System.out.println("No");
        }
        else {
            System.out.println("Yes");
        }
        String output = "";
        String A2 = A.substring(0,1).toUpperCase() + A.substring(1).toLowerCase();
        String B2 = B.substring(0,1).toUpperCase() + B.substring(1).toLowerCase();
        output = A2 + " " + B2;
        System.out.println(output);
    }
}

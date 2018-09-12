import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
task
Given an integer, , perform the following conditional actions:

If  is odd, print Weird
If  is even and in the inclusive range of 2 to 5 , print Not Weird
If  is even and in the inclusive range of 6 to 20, print Weird
If  is even and greater than 20, print Not Weird
*/
public class ifelse {

    public static void main(String[] args) {
        // create a scanner
        Scanner sc=new Scanner(System.in);
        // get inputs
        int n=sc.nextInt();
        String ans="";
        // check for odd
        if(n%2==1){
          // if odd set answer as weird
          ans = "Weird";
        }
        // if not odd
        else{
            // check for the range of even
            if (n >= 6 && n <= 20) {
              // if range from 6 - 20
                ans= "Weird";
            }
            else {
                // not in 6 and 20
                ans = "Not Weird";
            }
        }
        // print the answer
        System.out.println(ans);

    }
}

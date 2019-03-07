import java.io.*;
import java.util.*;
/*
Task:
input:
A String
out:
tokenize them into word by word;
*/
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine(); // get the string
        // Write your code here.
        String[] a=s.trim().split("[ !,?\\._'@]+",0); // trim = remove space
        if (a.length == 1 && a[0].equals("")) {
            System.out.println(0);
        }
        else {
            System.out.println(a.length);
            for (String token: a) {
                System.out.println(token);
            }
        }
        scan.close();
    }
}

import java.io.*;
import java.util.*;

public class Java_End-of-file {
    /*
    input format:
    Read some unknown n lines of input from stdin(System.in) until you reach EOF; each line of input contains a non-empty String.
    output format:
    For each line, print the line number, followed by a single space, and then the line content received as input.
    */
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        // declare scanner
        Scanner scan = new Scanner(System.in);
        // set a input variable
        String input = "";
        // the index of output
        int i = 1;
        // until the user stop type the input
        while (scan.hasNext()) {
            // read and output with i
            input = scan.nextLine();
            System.out.printf("%d %s%n",i,input);
            i++;
        }
    }
}

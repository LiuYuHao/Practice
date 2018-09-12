import java.io.*;
import java.util.*;
// task
/*Given an integer,N, print its first 10 multiples. Each multiple N x i
should be printed on a new line in the form: N x i = result.
*/
public class loop {

    public static void main(String[] args) {
        // create scanner and input to x
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        // the 10 times looping
        for(int i = 1; i < 11;i++){
            System.out.printf("%d x %d = %d%n",x,i,x*i);
        }
        /*
        based on the input, the output = a + 2^n * b. N = amount of output
        */
        // declare scanner
        Scanner in = new Scanner(System.in);
        // based on the input to decide how many time
        int t=in.nextInt();
        for(int i=0;i<t;i++){
          // get the in puts
          int a = in.nextInt();
          int b = in.nextInt();
          int n = in.nextInt();
          int answer = a;
          int temp = 0;
          // the loop for how many N(series)
          for(int j = 0; j < n; j++) {
            // this is how to convert from double to int
            // the default type from math.pow is double
            temp = (int)Math.pow(2,j) * b;
            // we need to add to the a
            answer = answer + temp;
            // print the answer
            System.out.print(answer);
            // space for formate of output requried
            System.out.print(" ");
          }
          System.out.println();
        }
        in.close();
    }
}

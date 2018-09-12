import java.io.*;
import java.util.*;

public class loop {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /*Given an integer,N, print its first 10 multiples. Each multiple N x i
        should be printed on a new line in the form: N x i = result.
        */
        int x = scan.nextInt();
        for(int i = 1; i < 11;i++){
            System.out.printf("%d x %d = %d%n",x,i,x*i);
        }
        /*
        based on the input, the output = a + 2^n * b. N = amount of output
        */
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
          int a = in.nextInt();
          int b = in.nextInt();
          int n = in.nextInt();
          int answer = a;
          int temp = 0;
          for(int j = 0; j < n; j++) {
            // this is how to convert from double to int
            temp = (int)Math.pow(2,j) * b;
            answer = answer + temp;
            System.out.print(answer);
            System.out.print(" ");
          }
          System.out.println();
        }
        in.close();
    }
}

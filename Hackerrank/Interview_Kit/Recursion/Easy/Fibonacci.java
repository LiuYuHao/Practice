import java.util.*;
/*
Task: calcuate the fibonacci(N);
Input a int n;
Output a int represents the nth fibonacci number; 
*/
public class Fibonacci {

    public static int fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
        // Complete the function.
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}

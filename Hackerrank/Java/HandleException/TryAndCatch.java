import java.io.*;
import java.util.*;

/*
Task: use try and catch to catch two exception of InputMismatchException and ArithmeticException.
input: Two integers x and y
output: print x/y if no exception happends, if there is one then print the exception.
*/
public class TryAndCatch {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try {
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(x/y);
        }
        catch (InputMismatchException e){
            System.out.println(e.getClass().getName());
        }
        catch (ArithmeticException e) {
            System.out.println(e);
        }

    }
}

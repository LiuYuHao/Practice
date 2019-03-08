import java.io.*;
import java.util.*;
import java.math.*;
/*
Task: use BigInteger class to add and multiply the big Integer which it is unable to store as primary type
input: two Integers
output: first line result of add and second line of result of multiply
*/
public class BigDecimal_Problem {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String x = scanner.nextLine();
        String y = scanner.nextLine();
        BigInteger big_x = new BigInteger(x);
        BigInteger big_y = new BigInteger(y);
        BigInteger result_add = big_x.add(big_y);
        BigInteger result_mul = big_x.multiply(big_y);
        System.out.println(result_add);
        System.out.println(result_mul);
    }
}

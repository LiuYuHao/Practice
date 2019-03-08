import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
Task: Determine the prime number using isProbablePrime function of BigInteger
Input: a int input
Output: return "prime" if it is prime, return "not prime" if it is not prime.
*/
public class PrimalityTest {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String n = scanner.nextLine();
        BigInteger x = new BigInteger(n);
        boolean result = x.isProbablePrime(1);
        if (result) {
            System.out.println("prime");
        }
        else {
            System.out.println("not prime");
        }
        scanner.close();
    }
}

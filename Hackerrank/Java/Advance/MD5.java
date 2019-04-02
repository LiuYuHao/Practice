import java.io.*;
import java.util.*;
import java.security.*;
public class MD5 {
/*
  Task: use MessageDigest to implement md5 algorithm for encryption of a text.
*/
    public static void main(String[] args) throws NoSuchAlgorithmException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        // singleton - get object from methods
        MessageDigest md = MessageDigest.getInstance("MD5");
        // get bytes from text
        byte[] b = text.getBytes();
        // hashing
        md.update(b);
        // get the result
        byte[] result_bit = md.digest();
        // convert to hex
        for(byte c: result_bit) {
            System.out.print(String.format("%02x", c));
        }
    }
}

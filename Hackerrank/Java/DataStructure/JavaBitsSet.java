import java.io.*;
import java.util.*;
/*
Task: use bitset to do and, or, xor, flip, and set operation on bit
input:
      m n -> m size of bitset, n = amount of cases
      op int int -> each cases, op = operation, int represent which bit or index based on the operation
output: the decimal of two bitset after each operations
*/
public class JavaBitsSet {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int size_case = scanner.nextInt();
        BitSet b1 = new BitSet(size);
        BitSet b2 = new BitSet(size);
        for (int i = 0; i < size_case; i++) {
            String op = scanner.next();
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            if (op.equals("AND")) {
                if (first == 1) {
                    b1.and(b2);
                    System.out.println(b1.cardinality()+" "+b2.cardinality());
                }
                else {
                    b2.and(b1);
                    System.out.println(b1.cardinality()+" "+b2.cardinality());
                }
            }
            else if (op.equals("SET")) {
                if (first == 1) {
                    b1.set(second);
                    System.out.println(b1.cardinality()+" "+b2.cardinality());
                }
                else {
                    b2.set(second);
                    System.out.println(b1.cardinality()+" "+b2.cardinality());
                }
            }
            else if (op.equals("FLIP")) {
                if (first == 1) {
                    b1.flip(second);
                    System.out.println(b1.cardinality()+" "+b2.cardinality());
                }
                else {
                    b2.flip(second);
                    System.out.println(b1.cardinality()+" "+b2.cardinality());
                }
            }
            else if (op.equals("OR")) {
                if (first == 1) {
                    b1.or(b2);
                    System.out.println(b1.cardinality()+" "+b2.cardinality());
                }
                else {
                    b2.or(b1);
                    System.out.println(b1.cardinality()+" "+b2.cardinality());
                }
            }
            else if (op.equals("XOR")) {
                if (first == 1) {
                    b1.xor(b2);
                    System.out.println(b1.cardinality()+" "+b2.cardinality());
                }
                else {
                    b2.xor(b1);
                    System.out.println(b1.cardinality()+" "+b2.cardinality());
                }
            }
        }
    }
}

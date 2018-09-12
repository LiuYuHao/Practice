import java.util.*;
import java.security.*;

class Conversion {
  public static void main(String[] args) {
    //There are automatic convertion
    int i = 100;
    long l = i;
    double d = i;
    System.out.printf("%d %d %f", i,l,d);

    // use typecast
    System.out.println();
    long l1 = (long)i;
    double d1 = (double)i;
    String s = Integer.toString(i);
    String s2 = String.valueOf(i);
    int test = Integer.parseInt(s2);
    System.out.printf("%d %d %f %s %s", i,l1,d1,s,s2);
    System.out.println();
  }
}

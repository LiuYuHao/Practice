import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Initalizer  {
  // Initalize the variable
  static boolean flag;
  static int B,H;
  // static block for give Initalize value for varaible, which they can use
  // in the static main function
  static {
    Scanner sc = new Scanner(System.in);
    flag = true;
    B = sc.nextInt();
    H = sc.nextInt();
    if (B <= 0 || H <= 0) {
        flag = false;
        System.out.print("java.lang.Exception: Breadth and height must be positive");
    }
  }
}

import java.util.*;
class Welcome {
  public static void main(String[] args) {
    // this is std output
    System.out.println("Hello World");
    // std input from user
    Scanner scan = new Scanner(System.in);
    int i = scan.nextInt();
    double d = scan.nextDouble();
    // since the nextInt or other method stop at nextline chacater, therefore
    // the nextline read the nextline chacater(empty on display)
    String s = scan.nextLine();
    s = scan.nextLine();
    System.out.println("String: " + s);
    System.out.println("Double: " + d);
    System.out.println("Int: " + i);
    // prinf,
    /*
    Each String is left-justified with trailing whitespace through the first 15 characters.
    The leading digit of the integer is the 16th character, and each integer that was less than 3 digits now has leading zeroes.
    */
    System.out.println("================================");
    for(int i=0;i<3;i++)
    {
      String s1=sc.next();
      int x=sc.nextInt();
      if (x < 100) {
        System.out.printf("%-15s%03d%n",s1,x);
      }
      else {
        System.out.printf("%-15s%d%n",s1,x);
      }
    }
    System.out.println("================================");
  }
}

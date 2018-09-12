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
    // create a scanner
    Scanner sc = new Scanner(System.in);
    System.out.println("================================");
    // a forloop since can test mulitple times
    for(int j=0;j<3;j++)
    {
      // get the input
      String s1=sc.next();
      int x=sc.nextInt();
      // we need to make sure if the integer is 3 digits or not
      if (x < 100) {
        // if not we need to add a 0
        System.out.printf("%-15s%03d%n",s1,x);
      }
      else {
        // else jsut normal
        System.out.printf("%-15s%d%n",s1,x);
      }
    }
    System.out.println("================================");
  }
}

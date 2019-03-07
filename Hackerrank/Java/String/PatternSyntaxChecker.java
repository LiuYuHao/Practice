import java.util.Scanner;
import java.util.regex.*;

/*
Input:
  size of cases, and string per case
output:
  use Pattern complie method from regex to recognize the pattern.
  valid and not valid
*/
public class PatternSyntaxException
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String pattern = in.nextLine();
            try {
                Pattern.compile(pattern);
                System.out.println("Valid");
            }
            catch(PatternSyntaxException e) {
                System.out.println("Invalid");
            }
            testCases--;
          	//Write your code
		}
	}
}

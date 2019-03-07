import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/*
Task: Return the content if the tag is right
input: number of cases and each html statement as input per cases
output: return content if the tag is right is not return none. Nest tag is valid.
*/
public class Solution{
	public static void main(String[] args){

		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String line = in.nextLine();

            boolean result = false;
			Pattern p = Pattern.compile("<(.+)>([^<]+)<\\/\\1>");
            Matcher m = p.matcher(line);
            //boolean matches = m.matches();

            while(m.find()) {
                System.out.println(m.group(2));
                result = true;
            }
            if (!result) {
                System.out.println("None");
            }
          	//Write your code here

			testCases--;
		}
	}
}

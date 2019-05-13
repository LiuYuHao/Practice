import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: check for the pair of bracket: {} [] (), if complete(there has pair to close each bracket) return yes, if not return no
*/
public class BalancedBracket {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty()) {
                char input = s.charAt(i);
                char top = stack.peek();
                if (input == ']' && top == '[') {
                    stack.pop();
                }
                else if (input == '}' && top == '{') {
                    stack.pop();
                }
                else if (input == ')' && top == '(') {
                    stack.pop();
                }
                else {
                    stack.push(input);
                }
            }
            else {
                stack.push(s.charAt(i));
            }
        }
        if (!stack.empty()) {
            return "NO";
        }
        else {
            return "YES";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

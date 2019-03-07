import java.util.Scanner;

/*
Task: check for valid username
Input: number of cases and the string (name) per each cases
output: valid or unvalid based on the condition: first character must be alpha, then length between 8 to 30, digit _ and alpha only
*/
class UsernameValidator {
    /*
     * Write regular expression here.
     */
    public static final String regularExpression = "[a-zA-Z][a-zA-Z0-9_]{7,29}";
}


public class UsernameRegex {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches(UsernameValidator.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
    }
}

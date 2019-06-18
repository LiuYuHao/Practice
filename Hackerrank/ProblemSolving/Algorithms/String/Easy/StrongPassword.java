import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: check if the password is match to requirement of strong password
Input: a int n = size, a string of password
Output: return a int which shows how many string it needs to add to become a strong password
*/
public class StrongPassword {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";
        HashSet<Character> number_hs = new HashSet<>();
        HashSet<Character> lower_hs = new HashSet<>();
        HashSet<Character> upper_hs = new HashSet<>();
        HashSet<Character> special_hs = new HashSet<>();
        for (int i = 0; i < numbers.length(); i++) {
            number_hs.add(numbers.charAt(i));
        }
        for (int i = 0; i < lower_case.length(); i++) {
            lower_hs.add(lower_case.charAt(i));
        }
        for (int i = 0; i < upper_case.length(); i++) {
            upper_hs.add(upper_case.charAt(i));
        }
        for (int i = 0; i < special_characters.length(); i++) {
            special_hs.add(special_characters.charAt(i));
        }
        int size_difference = 6 - n;
        int requirement_check = 0;
        boolean check_number = true;
        boolean check_lower = true;
        boolean check_upper = true;
        boolean check_speical = true;
        for (int i = 0; i < password.length(); i++) {
            if (check_number && number_hs.contains(password.charAt(i))) {
                check_number = false;
                requirement_check++;
            }
            else if (check_lower && lower_hs.contains(password.charAt(i))) {
                requirement_check++;
                check_lower = false;
            }
            else if (check_speical && special_hs.contains(password.charAt(i))) {
                requirement_check++;
                check_speical = false;
            }
            else if (check_upper && upper_hs.contains(password.charAt(i))) {
                requirement_check++;
                check_upper = false;
            }
        }
        int requirement_difference = 4 - requirement_check;
        if (requirement_difference > size_difference) {
            return requirement_difference;
        }
        else {
            return size_difference;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Task: use regex to remove duplicated word
input: the case number and the string per case
output: no duplcated sentence
*/
public class DuplicateWords {

    public static void main(String[] args) {

        // this regex find the duplicated words when they are continously
        // b for boundary, whole word, w+ for the words and it is in capture group,
        // W for space between two duplicated words, and we need to match to the first capture group for next words
        // close with b and + for more duplicated words
        String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());

        while (numSentences-- > 0) {
            String input = in.nextLine();

            Matcher m = p.matcher(input);

            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                // replace m.group (group of duplciated) to first capture group
                input = input.replaceAll(m.group(), m.group(1));
            }

            // Prints the modified sentence.
            System.out.println(input);
        }

        in.close();
    }
}

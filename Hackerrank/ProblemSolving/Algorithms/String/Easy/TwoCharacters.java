import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: find the max string which reduced all the characters where only two left and also they are not adjacent to each other
input: a stirng s
output: a int for denoted the max string after reduction
*/
public class TwocCharacters {
    // Complete the alternate function below.
    static int alternate(String s) {
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            hs.add(s.charAt(i));
        }
        int max = 0;
        Character[] distinct_character_array = hs.toArray(new Character[hs.size()]);
        for (int i = 0; i < distinct_character_array.length; i++) {
            for (int j = i + 1; j < distinct_character_array.length; j++) {
                String temp = "";
                for (int k = 0; k < s.length(); k++) {
                    if (s.charAt(k) == distinct_character_array[i] || s.charAt(k) == distinct_character_array[j]) {
                        temp += s.charAt(k);
                    }
                }
                //System.out.println(temp);
                boolean check = true;
                for (int k = 0; k < temp.length() - 1; k++) {
                    if (temp.charAt(k) == temp.charAt(k+1)) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    if (temp.length() > max) {
                        max = temp.length();
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

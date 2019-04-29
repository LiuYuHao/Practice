import java.util.*;
import java.io.*;
public class test {
  static String biggerIsGreater(String w) {
      int target = -1;
      for (int i = w.length() - 1; i > 0; i--) {
          if (w.charAt(i - 1) < w.charAt(i)) {
              target = i - 1;
              break;
          }
      }
      if (target == -1) {
          return "no answer";
      }
      int start = w.length() - 1;
      while (w.charAt(start) <= w.charAt(target)) {
          start--;
      }
      //System.out.println(target);
      //System.out.println(start);
      String w2 = w.substring(0, target) + w.charAt(start) + w.substring(target + 1, start) + w.charAt(target) + w.substring(start + 1, w.length());
      //System.out.println(w2);
      String reverse = "";
      for (int i = w2.length() - 1; i > target; i--) {
          reverse += w2.charAt(i);
      }
      String result = w2.substring(0, target) + w2.charAt(target) + reverse;
      return result;
  }

    public static void main(String[] args) throws IOException  {
        File Out_file = new File("Output.txt");
        File In_file = new File("Input.txt");
        BufferedReader out = new BufferedReader(new FileReader(Out_file));
        BufferedReader in = new BufferedReader(new FileReader(In_file));
        int p = 10000;
        while(p-- > 0) {
          String input_data = in.readLine();
          String right_answer = out.readLine();
          if (!(biggerIsGreater(input_data).equals(right_answer))) {
            System.out.println(input_data);
          }
        }
    }
}

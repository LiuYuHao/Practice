import java.util.*;
import java.io.*;
public class test {
  public static int factorial(int n) {
    int sum = 1;
    for (int i = 2; i <= n; i++) {
        sum *= i;
    }
    return sum;
}
public static int answerQuery(String s, int l, int r) {
// Return the answer for this query modulo 1000000007.
    String sub = s.substring(l - 1, r);
    int event = 0;
    int odd = 0;
    int repeat = 1;
    //System.out.println(sub);
    HashMap<Character, Integer> hm = new HashMap<>();
    for (int i = 0; i < sub.length(); i++) {
        hm.merge(sub.charAt(i), 1, Integer::sum);
    }
    //System.out.println(hm);
    for (Map.Entry<Character, Integer> e : hm.entrySet()) {
        int x = (int) e.getValue() / 2;
        event += x;
        if (x != 0) {
            repeat *= factorial(x);
        }
        if (e.getValue() % 2 == 1) {
            odd += 1;
        }
    }
    //System.out.println(event + " " + odd);
    System.out.println(l + " " + r);
    int result = (factorial(event)/repeat) * odd;
    if (odd == 0) {
        result = factorial(event);
    }
    return result % 1000000007;
}

    public static void main(String[] args) throws IOException  {
        File Out_file = new File("Output.txt");
        File In_file = new File("Input.txt");
        BufferedReader out = new BufferedReader(new FileReader(Out_file));
        BufferedReader in = new BufferedReader(new FileReader(In_file));
        String s = in.readLine();
        int p = Integer.parseInt(in.readLine());
        while(p-- > 0) {
          String input_data = in.readLine();
          String[] inputs = input_data.split(" ");
          String right_answer = out.readLine();
          //System.out.println(input_data + " " + right_answer);
          if (!(Integer.toString(answerQuery(s,Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]))).equals(right_answer))) {
            //System.out.println(answerQuery(s,Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1])) + " " + right_answer);
            System.out.println(input_data + " " + right_answer);
          }
        }
    }
}

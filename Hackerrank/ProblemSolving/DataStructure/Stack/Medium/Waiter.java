import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
/*
Task: There are N stacked plates with numbers on pile A, after q iterations, each ith iteration, the number on the plates that is divisible by the ith prime
      save it into b(i) stack, and rest goes to back to A.
output: from element in the b1 .... bn A;
*/
public class waiter {

    /*
     * Complete the waiter function below.
     */
    static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        int top = (int) Math.sqrt(number);
        for (int i = 3; i <= top; i = i + 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    static int findPrime(int index) {
        if (index == 1) {
            return 2;
        }
        else {
            int number = 3;
            int result = 3;
            int count = 2;
            while (count != index) {
                number = number + 2;
                if (isPrime(number)) {
                    count++;
                    result = number;
                }
            }
            return result;
        }
    }
    static int[] waiter(int[] number, int q) {
        /*
         * Write your code here.
         */
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < number.length; i++) {
            stack.push(number[i]);
        }
        Stack<Integer> a = new Stack<>();
        int[] primelist = new int[q+1];
        Stack[] b = new Stack[q + 1];
        for (int i = 0; i < q; i++) {
            b[i] = new Stack<Integer>();
        }
        for (int i = 1; i < q + 1; i++) {
            primelist[i] = findPrime(i);
        }
        for (int i = 1; i < q + 1; i++) {
            int x = stack.size();
            for (int j = 0; j < x; j++) {
                int data = stack.pop();
                if (data % primelist[i] == 0) {
                    b[i - 1].push(data);
                }
                else {
                    a.push(data);
                }
            }
            stack = (Stack<Integer>) a.clone();
            a.clear();
        }
        b[q] = stack;
        int[] result = new int[number.length];
        int i = 0;
        for (Stack<Integer> s : b) {
            while (!s.empty()){
                int data = s.pop();
                result[i] = data;
                i++;
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nq[0].trim());

        int q = Integer.parseInt(nq[1].trim());

        int[] number = new int[n];

        String[] numberItems = scanner.nextLine().split(" ");

        for (int numberItr = 0; numberItr < n; numberItr++) {
            int numberItem = Integer.parseInt(numberItems[numberItr].trim());
            number[numberItr] = numberItem;
        }

        int[] result = waiter(number, q);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

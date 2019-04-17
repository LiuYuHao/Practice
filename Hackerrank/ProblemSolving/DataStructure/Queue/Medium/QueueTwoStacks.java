import java.io.*;
import java.util.*;
/*
Task: use two stacks to preform queue functionality first in and first out
*/
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Stack<Integer> stack_1 = new Stack<>();
        Stack<Integer> stack_2 = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int op = scanner.nextInt();
            if (op == 1) {
                int data = scanner.nextInt();
                stack_1.push(data);
            }
            else if (op == 2) {
                if (stack_2.empty()) {
                    while (!stack_1.empty()) {
                        stack_2.push(stack_1.pop());
                    }
                }
                stack_2.pop();
            }
            else if (op == 3) {
                if (stack_2.empty()) {
                    while (!stack_1.empty()) {
                        stack_2.push(stack_1.pop());
                    }
                }
                System.out.println(stack_2.peek());
            }
        }
    }
}

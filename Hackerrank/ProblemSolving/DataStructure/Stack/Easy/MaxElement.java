import java.io.*;
import java.util.*;

/*
Task: Three queries, 1 for add 2 for delete 3 for print max
Input: n -> amount of queries
       op (x) -> op = oepration, x only happen when op = 1
*/
public class MaxElement {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return Integer.compare(y,x);
            }
        });
        for (int i = 0; i < n; i++) {
            int op = scanner.nextInt();
            if (op == 1) {
                int number = scanner.nextInt();
                stack.push(number);
                pq.add(number);
            }
            else if (op == 2) {
                if(!stack.isEmpty()){
                    int x = stack.pop();
                    pq.remove(x);
                }
            }
            else {
                if (pq.size() != 0){
                    System.out.println(pq.peek());
                }
            }
        }
    }
}

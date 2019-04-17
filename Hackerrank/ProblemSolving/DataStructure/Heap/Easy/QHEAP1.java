import java.io.*;
import java.util.*;

public class Solution {
/*
Task: Understand The heap operations, 1 - add , 2 - remove, 3 - print the min;
Input: n - size of queries
       op data - op = 1,2,3 data only when 1, 2.
Output: the min value based on op 3
*/
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int op = sc.nextInt();
            if (op == 1) {
                int data = sc.nextInt();
                pq.add(data);
            }
            else if (op == 2) {
                int data = sc.nextInt();
                pq.remove(data);
            }
            else {
                System.out.println(pq.peek());
            }
        }
    }
}

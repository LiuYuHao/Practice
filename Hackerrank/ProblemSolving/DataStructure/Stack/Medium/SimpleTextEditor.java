import java.io.*;
import java.util.*;
/*
Task: four queries, 1 - add x, 2 delete k, 3 print k, 4 undo. x = string to add, k is the last index for delete and print kth index.
     undo - undo the string from last operation 1 and 2;
input: n = > Integer of queries;
       op data -> input
       ...
       ...
output: output the corresponding character based on the operation 3
*/
public class SimpleTextEditor {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = "";
        LinkedList<String> ll = new LinkedList<>();
        ll.add(s);
        for (int i = 0; i < n; i++) {
            int op = sc.nextInt();
            if (op == 1) {
                String data = sc.next();
                s = s + data;
                ll.add(s);
            }
            else if (op == 2) {
                int k = sc.nextInt();
                s = s.substring(0,s.length() - k);
                ll.add(s);
            }
            else if (op == 3) {
                int p = sc.nextInt();
                System.out.println(s.charAt(p - 1));
            }
            else {
                s = ll.get(ll.size() - 2);
                ll.remove(ll.size() - 1);
            }
        }
    }
}

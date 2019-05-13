import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
Task: build myqueue class which makes the main function works
*/
class MyQueue<T> {
    public Stack<T> s1;
    public Stack<T> s2;
    public MyQueue() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }
    public void enqueue(T x) {
        s1.push(x);
    }
    public void dequeue() {
        if (s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        if (!s2.isEmpty()) {
            s2.pop();
        }
    }
    public T peek() {
        if (s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
}
public class TwoStacks_Queue {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

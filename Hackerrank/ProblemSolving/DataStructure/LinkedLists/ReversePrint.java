import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
Task: Complete the function such that it print the linkedlist reversely
*/
public class ReversePrint {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {
        while (node != null) {
            System.out.print(node.data);

            node = node.next;

            if (node != null) {
                System.out.print(sep);
            }
        }
    }

    // Complete the reversePrint function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
     // Recursively solution - shorter code
     /*
     if (head != null) {
        ReversePrint(head.next);
        System.out.println(head.data);
      }
     */
    static void reversePrint(SinglyLinkedListNode head) {
        SinglyLinkedListNode head_copy = head;
        if (head == null) {
            return;
        }
        else {
            SinglyLinkedListNode reverse_tail = new SinglyLinkedListNode(head_copy.data);
            SinglyLinkedListNode reverse_head = reverse_tail;
            if (head_copy.next == null) {
                System.out.println(head_copy.data);
                return;
            }
            else {
                head_copy = head_copy.next;
            }
            while (head_copy != null) {
                SinglyLinkedListNode copy = new SinglyLinkedListNode(head_copy.data);
                reverse_head = copy;
                reverse_head.next = reverse_tail;
                reverse_tail = reverse_head;
                head_copy = head_copy.next;
            }
            while (reverse_head != null) {
                System.out.println(reverse_head.data);
                reverse_head = reverse_head.next;
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist = new SinglyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            reversePrint(llist.head);
        }

        scanner.close();
    }
}

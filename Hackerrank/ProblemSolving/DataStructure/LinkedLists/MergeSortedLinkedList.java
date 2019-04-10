import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
Task: Merge two sorted LinkedList
*/
public class MergeSortedLinkedList {

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

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the mergeLists function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode head1_copy = head1;
        SinglyLinkedListNode head2_copy = head2;
        if (head1 == null && head2==null) {
            return head1;
        }
        else if (head1 == null) {
            return head2;
        }
        else if (head2 == null) {
            return head1;
        }
        else {
            SinglyLinkedListNode head_merge = new SinglyLinkedListNode(head1_copy.data);
            if (head2_copy.data < head1_copy.data) {
                head_merge.data = head2_copy.data;
                head2_copy = head2_copy.next;
            }
            else {
                head1_copy = head1_copy.next;
            }
            SinglyLinkedListNode tail_merge = head_merge;
            while (head1_copy != null && head2_copy != null) {
                if (head1_copy.data < head2_copy.data) {
                    SinglyLinkedListNode copy = new SinglyLinkedListNode(head1_copy.data);
                    tail_merge.next = copy;
                    tail_merge = tail_merge.next;
                    head1_copy = head1_copy.next;
                }
                else {
                    SinglyLinkedListNode copy = new SinglyLinkedListNode(head2_copy.data);
                    tail_merge.next = copy;
                    tail_merge = tail_merge.next;
                    head2_copy = head2_copy.next;
                }
            }
            if (head1_copy == null && head2_copy != null) {
                tail_merge.next = head2_copy;
            }
            if (head2_copy == null && head1_copy != null) {
                tail_merge.next = head1_copy;
            }
            return head_merge;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

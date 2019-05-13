/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as:
    class Node {
        int data;
        Node next;
    }
*/
/*
Others code are not given.
Task: detect the Node has cycle or not
Input: the head of linkedlist
Output: return falsse = no cycle, return true = cycle
*/
boolean hasCycle(Node head) {
    if (head == null) {
        return false;
    }
    Node slow = head;
    Node fast = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if (slow.equals(fast)) {
            return true;
        }
    }
    return false;
}
// Other easy are located at ProblemSolving/DataStructure/linkedlist

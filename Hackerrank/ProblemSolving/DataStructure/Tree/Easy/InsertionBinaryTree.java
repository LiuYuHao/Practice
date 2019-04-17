import java.util.*;
import java.io.*;
/*
Task: make a insertion on a binary tree, left < root and right > root, if == anyside
*/
class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class InsertionBinaryTree {

  	public static void preOrder( Node root ) {

    	if( root == null)
        	return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

 /* Node is defined as :
 class Node
    int data;
    Node left;
    Node right;

    */

	public static Node insert(Node root,int data) {
        if (root == null) {
            Node result = new Node(data);
            return result;
        }
        else {
            Node root_copy = root;
            while(root_copy != null) {
                if (data < root_copy.data) {
                    if (root_copy.left == null) {
                        Node copy = new Node(data);
                        root_copy.left = copy;
                        return root;
                    }
                    root_copy = root_copy.left;
                }
                else {
                    if (root_copy.right == null) {
                        Node copy = new Node(data);
                        root_copy.right = copy;
                        return root;
                    }
                    root_copy = root_copy.right;
                }
            }
            return root;
        }
    }

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
      	preOrder(root);
    }
}

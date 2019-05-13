import java.util.*;
import java.io.*;
/*
Task: find the lower common ancestor of v1 and v2, the lower root where they both had.
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

class LowerCommonAncestor {

	/*
    class Node
    	int data;
    	Node left;
    	Node right;
	*/
	public static Node lca(Node root, int v1, int v2) {
      	// Write your code here.
        HashMap<Node, Node> tm = new HashMap<>();
        Node root_copy = root;
        while (root_copy != null) {
            if (root_copy.data == v1) {
                tm.put(root_copy,root_copy);
                break;
            }
            if (v1 < root_copy.data) {
                tm.put(root_copy,root_copy);
                root_copy = root_copy.left;
            }
            else {
                tm.put(root_copy,root_copy);
                root_copy = root_copy.right;
            }
        }
        root_copy = root;
        Node answer = root_copy;
        while (root_copy != null) {
            if(root_copy.data == v2) {
                break;
            }
            if (v2 < root_copy.data) {
                if (tm.containsKey(root_copy)) {
                    answer = root_copy;
                }
                root_copy = root_copy.left;
            }
            else {
                if (tm.containsKey(root_copy)) {
                    answer = root_copy;
                }
                root_copy = root_copy.right;
            }
        }
        return answer;
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
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
      	int v1 = scan.nextInt();
      	int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }
}

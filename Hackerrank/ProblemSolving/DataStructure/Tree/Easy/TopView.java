import java.util.*;
import java.io.*;
/*
Task: print the topview, it means find the topmost horizantal distance of each node. left - 1 right + 1;
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

class TopView {

	/*

    class Node
    	int data;
    	Node left;
    	Node right;
	*/
	public static void topView(Node root) {
        class Node_Hd {
            public Node node;
            public int hd;
            public Node_Hd(Node n, int hd) {
                this.node = n;
                this.hd = hd;
            }
        }
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        Queue<Node_Hd> q = new LinkedList<>();
        Node_Hd root_hd = new Node_Hd(root, 0);
        q.add(root_hd);
        while(!q.isEmpty()) {
            Node_Hd temp_node = q.poll();
            if (!tm.containsKey(temp_node.hd)) {
                tm.put(temp_node.hd, temp_node.node.data);
            }
            if (temp_node.node.left != null) {
                q.add(new Node_Hd(temp_node.node.left, temp_node.hd - 1));
            }
            if (temp_node.node.right != null) {
                q.add(new Node_Hd(temp_node.node.right,temp_node.hd + 1));
            }
        }
        tm.forEach((k,v) -> System.out.print(v + " "));
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
        scan.close();
        topView(root);
    }
}

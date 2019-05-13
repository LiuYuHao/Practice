/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.
// From DataStructure/Trees
The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
void inOrder(Node head, ArrayList<Integer> al) {
    if (head == null) {
        return;
    }
    inOrder(head.left, al);
    al.add(head.data);
    inOrder(head.right, al);
}
    boolean checkBST(Node root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        ArrayList<Integer> al = new ArrayList<>();
        inOrder(root, al);
        for (int i = 1; i < al.size(); i++) {
             if (al.get(i) <= al.get(i - 1)) {
                 return false;
             }
        }
        return true;
    }

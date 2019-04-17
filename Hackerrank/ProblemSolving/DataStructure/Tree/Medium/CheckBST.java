/*
Task: only need to complete the function of checkBST;
*/
/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The Node class is defined as follows:
    class Node {
    int data;
    Node left;
    Node right;
     }
*/  void in_Order(Node root, ArrayList<Integer> al) {
        if (root == null) {
            return;
        }
        in_Order(root.left, al);
        al.add(root.data);
        in_Order(root.right, al);
    }
    boolean checkBST(Node root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        ArrayList<Integer> al = new ArrayList<>();
        in_Order(root, al);
        for (int i = 0; i < al.size(); i++) {
            for (int j = i + 1; j < al.size(); j++) {
                if (al.get(i) >= al.get(j)) {
                    return false;
                }
            }
        }
        return true;
    }

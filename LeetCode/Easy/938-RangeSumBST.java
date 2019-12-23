class Hold {
    int sum;
    Hold(int x) {
        this.sum = x;
    }
}
class Solution {
  public void inOrder(TreeNode root, Hold hold, int L, int R) {
    if (root == null) {
        return;
    }
    if (root.val < L) {
        inOrder(root.right, hold, L, R);
    }
    else if (root.val > R) {
        inOrder(root.left, hold, L, R);
    }
    else {
        hold.sum += root.val;
        inOrder(root.left, hold, L, R);
        inOrder(root.right, hold, L, R);
    }
  }
    // public void inOrder(TreeNode root, ArrayList<Integer> al) {
    //     if (root == null) {
    //         return;
    //     }
    //     inOrder(root.left, al);
    //     al.add(root.val);
    //     inOrder(root.right, al);
    // }
    public int rangeSumBST(TreeNode root, int L, int R) {
        /* use inOrder good memory but bad in complexity
        int sum = 0;
        ArrayList<Integer> al = new ArrayList<>();
        inOrder(root, al);
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i) >= L && al.get(i) <= R) {
                sum += al.get(i);
            }
        }
        return sum;
        */
        Hold answer = new Hold(0);
        inOrder(root, answer, L, R);
        return answer.sum;
    }
}

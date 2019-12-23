/*
Task: Organzie the array such that even on left side followed by odd
Input: a int array
Output: a int array
*/
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                int temp = A[i];
                A[i] = A[index];
                A[index] = temp;
                index++;
            }
        }
        return A;
    }
}

/*
Task: flip the matrix horizontally and invert the data from 1 - 0 or 0 - 1;
Input: a two dimensional array
Output: a two dimensional array
*/
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i].length % 2 == 1) {
                int x = A[i][A[i].length/2];
                if (x == 0) {
                    A[i][A[i].length/2] = 1;
                }
                else {
                    A[i][A[i].length/2] = 0;
                }
            }
            for (int j = 0; j < A[i].length/2; j++) {
                if(A[i][j] == 1) {
                    A[i][j] = 0;
                }
                else {
                    A[i][j] = 1;
                }
                if(A[i][A[i].length - 1 - j] == 1) {
                    A[i][A[i].length - 1 - j] = 0;
                }
                else {
                    A[i][A[i].length - 1 - j] = 1;
                }
                if (A[i][j] != A[i][A[i].length - 1 - j]) {
                    int temp = A[i][j];
                    A[i][j] = A[i][A[i].length - 1 - j];
                    A[i][A[i].length - 1 - j] = temp;
                }
            }
        }
        return A;
    }
}

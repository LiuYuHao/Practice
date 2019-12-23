/*
Task: given a sorted array, return the squares of sorted array of it
Input: an int array;
Output: an int array
*/
class Solution {
    public int[] sortedSquares(int[] A) {
        int negative = 0;
        while(negative < A.length && A[negative] < 0) {
            negative++;
        }
        int positive = negative;
        negative--;
        int[] result = new int[A.length];
        for (int i = 0; i < result.length; i++) {
            if (negative == -1) {
                result[i] = A[positive] * A[positive];
                positive++;
            }
            else if (positive == A.length) {
                result[i] = A[negative] * A[negative];
                negative--;
            }
            else if (A[negative] * A[negative] < A[positive] * A[positive]) {
                result[i] = A[negative] * A[negative];
                negative--;
            }
            else {
                result[i] = A[positive] * A[positive];
                positive++;
            }
        }
        return result;
    }
}

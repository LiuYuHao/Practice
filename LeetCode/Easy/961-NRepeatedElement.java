/*
Task: in a int array which size is 2N and there are n + 1 unique element and rest are the repeated element of one of the unique elemnt, find it.
Input: a int array
Output: a int
*/
class Solution {
    public int repeatedNTimes(int[] A) {
        HashSet<Integer> hs = new HashSet<>();
        int baseline = A.length/2;
        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            if (!hs.contains(A[i])) {
                hs.add(A[i]);
            }
            else {
                answer = A[i];
                break;
            }
        }
        return answer;
    }
}

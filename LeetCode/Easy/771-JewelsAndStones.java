/*
Task: find amount of jewels in the stones
Input: a string which contains jewels(each charater) and a string contains Stones
Output: a int for represent amonut of jewels in the stones
*/
class Solution {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            hs.add(J.charAt(i));
        }
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (hs.contains(S.charAt(i)))  {
                count++;
            }
        }
        return count;
    }
}

/*
Task: check if after amount of moves does robot still stay in the origin (0,0);
Input: a String
Output: a boolean
*/
class Solution {
    public boolean judgeCircle(String moves) {
        int u_d = 0;
        int l_r = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                u_d += 1;
            }
            else if (c == 'D') {
                u_d -= 1;
            }
            else if (c == 'L') {
                l_r += 1;
            }
            else {
                l_r -= 1;
            }
        }
        if (u_d == 0 && l_r == 0) {
            return true;
        }
        return false;
    }
}

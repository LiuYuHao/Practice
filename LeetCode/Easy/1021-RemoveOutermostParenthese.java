/*
Task: remove the outer parenthese return the rest
Input: String s
Output: String s
*/
class Solution {
    public String removeOuterParentheses(String S) {
        /* didn't have good time complexity
        String result  = "";
        Stack<Character> s = new Stack<>();
        for (int i = 0; i  < S.length(); i++) {
            if (s.isEmpty()) {
                s.push(S.charAt(i));
            }
            else {
                char c = S.charAt(i);
                if (c == '(') {
                    s.push(c);
                    result += c;
                }
                else if (c == ')') {
                    s.pop();
                    if (!s.isEmpty()) {
                        result += c;
                    }
                }
                else {
                    result += c;
                }
            }
        }
        return result;
        */
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < S.length(); i++) {
          if (S.charAt(i) == '(') {
            count++;
          }
          if (count > 1) {
            sb.append(S.charAt(i));
          }
          if (S.charAt(i) == ')') {
            count--;
          }
        }
        return sb.toString();
    }
}

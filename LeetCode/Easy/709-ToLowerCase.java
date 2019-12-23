/*
Task: convert the str to lowercase
Input: a str
Output: a str
*/
class Solution {
    public String toLowerCase(String str) {
        HashMap<Integer, Character> lower = new HashMap<>();
        HashMap<Character, Integer> upper = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char l = (char) (97 + i);
            char u = (char) (65 + i);
            lower.put(i, l);
            upper.put(u, i);
        }
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char e = str.charAt(i);
            if (upper.containsKey(e)) {
                int index = upper.get(e);
                result += lower.get(index);
            }
            else {
                result += e;
            }
        }
        return result;
    }
}

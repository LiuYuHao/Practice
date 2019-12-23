/*
Task: convert the word in the words (String array) to morse code
Input: a String array
Output: a int indicate the amount of difference morse code generated from the input
*/
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> hs = new HashSet<>();
        String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for (int i = 0; i < words.length; i ++) {
            StringBuilder sb= new StringBuilder();
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                sb.append(code[c - 'a']);
            }
            hs.add(sb.toString());
        }
        return hs.size();
    }
}

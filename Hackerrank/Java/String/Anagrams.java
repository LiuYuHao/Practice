import java.util.*;
/*
Task: check for anagram -> same amount of each character of two strings
input: two strings
output: return Anagram or not Anagram
*/
public class Anagrams {
    // use map, it is not able to use in Hackerrank
    // static void collect_frequency(String[] s, Map<String, Integer> m) {
    //     for (int i = 0; i<s.length; i++) {
    //         if (!m.containsKey(s[i])) {
    //             m.put(s[i], 1);
    //         }
    //         else {
    //             m.put(s[i], m.get(s[i]) + 1);
    //         }
    //     }
    // }
    // static boolean loop_map(Map<String, Integer> m, Map<String, Integer> m2) {
    //   for (Map.Entry<String, Integer> entry : m.entrySet()) {
    //     if (!m2.containsKey(entry.getKey())) {
    //       return false;
    //     }
    //     else {
    //       if (entry.getValue() != m2.get(entry.getKey())) {
    //         return false;
    //       }
    //     }
    //   }
    //   return true;
    // }
    // static boolean isAnagram(String a, String b) {
    //     // Complete the function
    //     if (a.length() != b.length()) {
    //         return false;
    //     }
    //     else {
    //         String a_lower = a.toLowerCase();
    //         String b_lower = b.toLowerCase();
    //         String[] a_split = a_lower.split("");
    //         String[] b_split = b_lower.split("");
    //         Map<String, Integer> a_map = new HashMap<>();
    //         Map<String, Integer> b_map = new HashMap<>();
    //         collect_frequency(a_split, a_map);
    //         collect_frequency(b_split, b_map);
    //         //System.out.println(a_map.get("a"));
    //         boolean resultA = loop_map(a_map, b_map);
    //         boolean resultB = loop_map(b_map, a_map);
    //         return resultA && resultB;
    //     }
    // }
    /* use standard way to compute with n^2 complexity*/

    // this function compute the frequncy of s inside of a
    static int find_frequency(String[] a, String s) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals(s)) { // use equal function instead of ==, since their object are not the same
                result = result + 1;
            }
        }
        return result;
    }
    static boolean isAnagram(String a, String b) {
            // Complete the function
            if (a.length() != b.length()) { // check length first
                return false;
            }
            else { // when they had the same length
                String a_lower = a.toLowerCase(); // to lower case
                String b_lower = b.toLowerCase(); // to lower case
                String[] a_split = a_lower.split(""); // spltit them into character
                String[] b_split = b_lower.split("");
                for (int i = 0; i < a_split.length; i++) { // loop it and check with frequency fucntion
                    int frequncy_a = find_frequency(a_split, a_split[i]); // get the frequncy in a_split
                    int frequncy_b = find_frequency(b_split, a_split[i]); // and get the frequncy of same character in b_split
                    if (frequncy_a != frequncy_b) { // check if they are eqaul or not
                        return false;
                    }
                }
            }
            return true;
        }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String a = scan.next();
    String b = scan.next();
    scan.close();
    boolean ret = isAnagram(a, b);
    System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
  }
}

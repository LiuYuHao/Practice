import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
Task: use hashset to check out the unique pair
Input: A Integer = size of cases, each case = one pair of string
Output: for each time input, print amout of unique pair
*/
public class HashSetPair {

 public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }
        /* Simple answer
        HashSet<String> pairs = new HashSet<String>(t);

        for(int i = 0; i < t; i++)
        {
          pairs.add("(" + pair_left[i] + ", " + pair_right[i] + ")" );
          System.out.println(pairs.size());
        }
        */
        //Write your code here
        // create three hashset to deal with two kind of situation
        HashSet<String> l_hset = new HashSet<>();
        HashSet<String> r_hset = new HashSet<>();
        HashSet<String> m_hset = new HashSet<>();
        // loop
        for (int i = 0; i < t; i++) {
            // add two string together
            String sum = pair_right[i] + pair_left[i];
            // left part to left set
            l_hset.add(pair_left[i]);
            // right part to right set
            r_hset.add(pair_right[i]);
            // sum to the middle
            m_hset.add(sum);
            // the largest size among of three hashsets = right answer
            // because two type of situation will happen:
            // 1. a bc == ab c solve by left and right
            // 2. a b and b a solve by mid
            if (l_hset.size() >= r_hset.size() && l_hset.size() >= m_hset.size()) {
                System.out.println(l_hset.size());
            }
            else if (r_hset.size() >= l_hset.size() && r_hset.size() >= m_hset.size()) {
                System.out.println(r_hset.size());
            }
            else if (m_hset.size() >= l_hset.size() && m_hset.size() >= r_hset.size()) {
                System.out.println(m_hset.size());
            }
        }
   }
}

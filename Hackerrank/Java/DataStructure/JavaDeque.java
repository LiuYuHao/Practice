import java.util.*;
/*
Task: Use deque to find the max unique Integer inside of continuous subarray size of m
input:
      m n => m for size of array, n for size of subarray
      m m .... m m => m times of input of Integer (array)
output: the max unique Integer
*/
/* much more cleaner answer (stucture and size of code)
public class test {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Deque<Integer> deque          = new ArrayDeque<>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int max = map.size();

        for (int i = 0; i < n; i++) {
            /* Remove old value (if necessary)
            if (i >= m) {
                int old = deque.remove();
                if (map.get(old) == 1) {
                    map.remove(old);
                } else {
                    map.put(old, map.get(old) - 1);
                }
            }
            /* Add new value
            int num = scan.nextInt();
            deque.add(num);
            map.merge(num, 1, Integer::sum);

            max = Math.max(max, map.size());

            /* If all integers are unique, break out of loop
            if (max == m) {
                break;
            }
        }

        scan.close();
        System.out.println(max);
    }
}
*/
public class JavaDeque {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Declare deque and HashMap
        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        // get the size and size of subarray
        // use  deque for tracking subarray
        // use map to check for unique Integer
        int n = in.nextInt();
        int m = in.nextInt();
        // a variabel to max
        int max = 0;
        for (int i = 0; i < n; i++) {
          // get the size of element of array
            int num = in.nextInt();
            // begin with getting all the element that with subarray
            // for the first subarray
            if (i < m) {
              // add to deque
                deque.add(num);
                // add to map
                // common frequence of using map
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                }
                else {
                    map.put(num, 1);
                }
                // get the size of map = unique Integer
                max = map.size();
            }
            else {
              // remove the first oen (queue);
                int x = deque.remove();
                // common style of decreasing the frequence using map
                if (map.get(x) == 1) {
                    map.remove(x);
                }
                else {
                    map.put(x, map.get(x) - 1);
                }
                // add the new one that is another subarray
                deque.add(num);
                // use merge to replace the frequence style of map
                map.merge(num, 1, Integer::sum);
                // get the size and compare with max
                int temp = map.size();
                if (temp > max) {
                    max = temp;
                }
            }
            // condition when max is the number of size of subarray which that is maximum unique Integer can be
            if (max == m) {
                break;
            }
        }
        System.out.println(max);
    }
}

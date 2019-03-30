import java.io.*;
import java.util.*;

/*
Task: find the all negative sum subarray which are continuous subarray
Input: a array
Output: sum of all the sum of the subarray that is negative
*/
public class Subarray {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        String[] in = scanner.nextLine().split(" ");
        int[] container = new int[size];
        int counter = 0;
        for (int i = 0; i < size; i++) {
            container[i] = Integer.parseInt(in[i]);
        }
        /* Better solution, this works because it checked while it add to the sum.
        for(int j=0;j<n;j++){
          int sum=0;
          for(int k=j;k<n;k++){
            sum=array1[k]+sum;
            if(sum<0){
              count++;
            }
          }
        }
        */
        // loop the array, start index
        for (int i = 0; i<size; i++) {
           // loop the array begin with i, end index
            for (int j = i; j <size; j ++) {
                int sum = 0;
                // add the sum from start index to end index
                for (int k = i; k <= j; k++) {
                    sum = sum + container[k];
                }
                // if it is smaller than 0
                if (sum < 0) {
                  // increase the counter
                    counter = counter + 1;
                }
            }
        }
        System.out.println(counter);
    }
}

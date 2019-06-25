import java.io.*;
import java.util.*;
/*
Task: fix the code for insertionSort
Fix: j > 0 => j > -1
*/
/*
Loop Invariant: the proof
Initialization: it is true before loop runs
Maintenance: It is true before next iteration
Termination: it will terminate in a useful way once it is finished
*/
/*
Example: loop Invariant of insertion sort
Statement: At the start of every iteration of the outer loop(indexed with i), the subarray until ar[i] consists of the original elements that were there,
           but in sorted order.
Initialization: The subarray starts with first element => sorted
Maintenance: each iteration of the loop expands the subarray, but keep the sorted property. An element V gets inserted into the array only when it is
             greater than the element to its left, sinec left is already been sorted, it means V is greater than all the element in the left subarray
Termination: The code will terminate after i has reached the last element in the array, which means the sorted subarray has expanded to encompass the
             entire array. The array is fully sorted
*/
public class Solution {

    public static void insertionSort(int[] A){
        for(int i = 1; i < A.length; i++){
            int value = A[i];
            int j = i - 1;
            while(j > -1 && A[j] > value){
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = value;
        }

        printArray(A);
    }


    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        insertionSort(ar);
    }
}

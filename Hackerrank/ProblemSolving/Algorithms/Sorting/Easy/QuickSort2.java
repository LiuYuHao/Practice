

import java.util.*;
/*
Task: implement quicksort and print the merge part for every iterations
Input: a int array
Output: system.out.print the merge part of every iterations
*/
public class QuickSort2 {
	    static int partition(int[] ar, int l, int h) {
            int pivot = ar[l];
            ArrayList<Integer> left = new ArrayList<>();
            ArrayList<Integer> right = new ArrayList<>();
            for (int i = l + 1; i <= h; i++) {
                if (ar[i] < pivot) {
                    left.add(ar[i]);
                }
                else {
                    right.add(ar[i]);
                }
            }
            int position = l;
            for (int i = 0; i < left.size(); i++) {
                ar[position] = left.get(i);
                position++;
            }
            ar[position] = pivot;
            int result = position;
            position++;
            for (int i = 0; i < right.size(); i++) {
                ar[position] = right.get(i);
                position++;
            }
            return result;
        }
        static void sort(int[] ar, int l, int h) {
            if (l < h) {
                int p = partition(ar, l, h);
                sort(ar, l, p - 1);
                sort(ar, p + 1, h);
                for (int i = l; i <= h; i++) {
                    System.out.print(ar[i] + " ");
                }
                System.out.println("");
            }
        }
        static void quickSort(int[] ar) {
            sort(ar, 0, ar.length - 1);
	    }


 static void printArray(int[] ar) {
			for(int n: ar){
				System.out.print(n+" ");
			}
	        System.out.println("");
		}

	   public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[] ar = new int[n];
	        for(int i=0;i<n;i++){
	           ar[i]=in.nextInt();
	        }
	        quickSort(ar);
	    }
	}

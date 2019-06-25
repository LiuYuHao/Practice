import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
Task: QuickSort inplace
*/
public class QuickSortInplace {
    public static int Partition(int[] ar, int l, int h ) {
        //System.out.println(l + " " + h);
        int pivot = ar[h];
        int position = l;
        for (int i = l; i < h; i++) {
            if (ar[i] < pivot) {
                int temp = ar[i];
                ar[i] = ar[position];
                ar[position] = temp;
                position++;
            }
        }
        int temp = ar[position];
        ar[position] = ar[h];
        ar[h] = temp;
        return position;
    }
    public static void QuickSort(int[] ar, int l, int h) {
        if (l < h) {
            int p = Partition(ar, l, h);
            for (int i = 0; i < ar.length; i++) {
                System.out.print(ar[i] + " ");
            }
            System.out.println("");
            QuickSort(ar, l, p - 1);
            QuickSort(ar, p + 1, h);
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] ar = new int[size];
        for (int i = 0; i < size; i++) {
            ar[i] = sc.nextInt();
        }
        QuickSort(ar, 0, ar.length - 1);
    }
}

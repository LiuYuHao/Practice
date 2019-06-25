import java.io.*;
import java.util.*;
/*
Task: Find the different amount of moves(change, swap) betwen insertion sort and quick sort
*/
public class QuickSortRunningTime {
    public static int InsertionSort(int[] ar) {
        int count = 0;
        for (int i = 1; i < ar.length; i++) {
            for (int j = i; j - 1 > -1 && ar[j - 1] > ar[j]; j--) {
                int temp = ar[j];
                ar[j] = ar[j - 1];
                ar[j - 1] = temp;
                count++;
            }
        }
        return count;
    }
    public static int Partition(int[] ar, int l, int h, ArrayList<Integer> al) {
        int pivot = ar[h];
        int position = l;
        int count = 0;
        for (int i = l; i < h; i++) {
            if (ar[i] < pivot) {
                int temp = ar[i];
                ar[i] = ar[position];
                ar[position] = temp;
                position++;
                count++;
            }
        }
        int temp = ar[position];
        ar[position] = pivot;
        ar[h] = temp;
        count++;
        al.add(count);
        return position;
    }
    public static void QuickSort(int[] ar, int l, int h, ArrayList<Integer> al) {
        if (l < h) {
            int p = Partition(ar, l, h, al);
            QuickSort(ar, l, p - 1, al);
            QuickSort(ar, p + 1, h, al);
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = new int[size];
        int[] array_2 = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
            array_2[i] = array[i];
        }
        int in_count = InsertionSort(array);
        ArrayList<Integer> al = new ArrayList<Integer>();
        QuickSort(array_2, 0, array.length - 1, al);
        int qu_count = 0;
        for (int i = 0; i < al.size(); i++) {
            qu_count += al.get(i);
        }
        System.out.println(in_count - qu_count);
    }
}

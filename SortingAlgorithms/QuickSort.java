import java.util.*;
/*
QuickSort: best: nlogn, worst: n^2, not stable inplace
*/
public class QuickSort {
  public static int partition(int[] array, int l, int h) {
    int p = array[h];
    int start = l - 1;
    for (int i = l; i < h; i++) {
      if (array[i] <= p) {
        start++;
        int temp = array[start];
        array[start] = array[i];
        array[i] = temp;
      }
    }
    int temp = array[h];
    array[h] = array[start + 1];
    array[start + 1] = temp;
    return start + 1;
  }
  public static void quickSort(int[] array, int l, int h){
    if (l < h) {
      int p = partition(array, l, h);
      quickSort(array, l, p - 1);
      quickSort(array, p+1, h);
    }
  }
  public static void main(String[] args) {
    int[] test = new int[]{3,4,1,2,6,7,3};
    quickSort(test, 0, test.length - 1);
    for (int i = 0; i < test.length; i++) {
      System.out.print(test[i] + " ");
    }
    System.out.println("");
  }
}

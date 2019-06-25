import java.util.*;
/*
MergeSort: time: nlogn
           space: n
           stable,
           no inplace
*/
public class MergeSort {
  public static void merge(int[] array, int l, int m, int r) {
    int left_size = m - l + 1;
    int right_size = r - m;
    int[] left = new int[left_size];
    int[] right = new int[right_size];
    int left_index = 0;
    int right_index = 0;
    for (int i = l; i <= m; i++) {
      left[left_index] = array[i];
      left_index++;
    }
    for (int i = m + 1; i <= r; i++) {
      right[right_index] = array[i];
      right_index++;
    }
    int left_count = 0;
    int right_count = 0;
    int array_count = l;
    while (left_count != left_size && right_count != right_size) {
      if (right[right_count] > left[left_count]) {
        array[array_count] = left[left_count];
        left_count++;
      }
      else {
        array[array_count] = right[right_count];
        right_count++;
      }
      array_count++;
    }
    while (left_count != left_size) {
      array[array_count] = left[left_count];
      left_count++;
      array_count++;
    }
    while(right_count != right_size) {
      array[array_count] = right[right_count];
      right_count++;
      array_count++;
    }
  }
  public static void mergeSort(int[] array, int l, int r) {
    if (l < r) {
      int m = (l + r) /2;
      mergeSort(array, l, m);
      mergeSort(array, m  + 1, r);
      merge(array, l , m , r);
    }
  }
  public static void main(String[] args) {
    int[] test = new int[]{3,4,1,2,6,7,3};
    mergeSort(test, 0 , test.length - 1);
    for (int i = 0; i < test.length; i++) {
      System.out.print(test[i] + " ");
    }
    System.out.println("");
  }
}

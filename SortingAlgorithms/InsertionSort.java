import java.util.*;
public class InsertionSort {
  /*
  InsertionSort:: Best: n Worse: n^2, stable and inplace
  */
  public static void helper(int[] array, int index) {
    if (index > array.length - 1) {
      return;
    }
    for (int j = index; j - 1 > -1 && array[j] < array[j - 1]; j--) {
      int temp = array[j];
      array[j] = array[j - 1];
      array[j - 1] = temp;
    }
    helper(array, index + 1);
  }
  public static void rec_insertionSort(int[] array) {
    helper(array, 1);
  }
  public static void insertionSort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      for (int j = i; j - 1 > -1 && array[j] < array[j - 1]; j--) {
          int temp = array[j];
          array[j] = array[j - 1];
          array[j - 1] = temp;
      }
    }
  }
  public static void main(String[] args) {
    int[] test = new int[]{3,4,1,2,6,7,3};
    rec_insertionSort(test);
    for (int i = 0; i < test.length; i++) {
      System.out.print(test[i] + " ");
    }
    System.out.println("");
  }
}

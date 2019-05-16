import java.util.*;
public class SelectionSort {
  /*
  Selection Sort: 1/2n^2 for all the cases, in place but not stable
  */
  public static void helper(int[] array, int index) {
    if (index == array.length - 1) {
      return;
    }
    int smallest = index;
    for (int i = index + 1; i < array.length; i++) {
      if (array[i] < array[smallest]) {
        smallest = i;
      }
    }
    int temp = array[index];
    array[index] = array[smallest];
    array[smallest] = temp;
    helper(array, index + 1);
  }
  // recrusive
  public static void rec_selectionSort(int[] array) {
    helper(array, 0);
  }
  // iterative
  public static void selectionSort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      int smallest = i;
      for (int j = i  + 1; j < array.length; j++) {
        if (array[j] < array[smallest]) {
          smallest = j;
        }
      }
      int temp = array[i];
      array[i] = array[smallest];
      array[smallest] = temp;
    }
  }
  public static void main(String[] args) {
    int[] test = new int[]{3,4,1,2,6,7,3};
    rec_selectionSort(test);
    for (int i = 0; i < test.length; i++) {
      System.out.print(test[i] + " ");
    }
    System.out.println("");
  }
}

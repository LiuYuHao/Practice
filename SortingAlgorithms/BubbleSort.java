import java.lang.*;
import java.util.*;

public class BubbleSort {
  /*
  BubbleSort: best: n, worse n^2
  */
  public static void bubbleSort(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      int change = 0;
      for (int j = 1; j < array.length && array[j - 1] > array[j]; j++) {
        if (array[j - 1] > array[j]) {
          int temp = array[j- 1];
          array[j-1] = array[j];
          array[j] = temp;
          change++;
        }
      }
      if (change == 0) break;
    }
  }
  public static void main(String[] args) {
    int[] test = new int[]{3,4,1,2,6,7,3};
    bubbleSort(test);
    for (int i = 0; i < test.length; i++) {
      System.out.print(test[i] + " ");
    }
    System.out.println("");
  }
}

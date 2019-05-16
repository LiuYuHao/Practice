import java.util.*;
/*
CoutingSort: O(k+n) not inplace, stable, k = the max size of array that we need to create
*/
public class CountingSort {
  public static void countingSort(int[] array) {
    int max = array[0];
    for (int i = 1; i < array.length; i++) {
      if (array[i] > max) max = array[i];
    }
    int[] c = new int[max + 1];
    for (int i = 0; i <array.length; i++) {
      c[array[i]] += 1;
    }
    for (int i = 1; i < c.length; i++) {
      c[i] = c[i - 1] + c[i];
    }
    int[] b = new int[array.length];
    for (int i = array.length - 1; i > - 1; i--) {
      int index = c[array[i]] -= 1;
      b[index] = array[i];
    }
    for (int i = 0; i < array.length; i++) {
      array[i] = b[i];
    }
  }
  public static void main(String[] args) {
    int[] test = new int[]{3,4,1,2,6,7,3};
    countingSort(test);
    for (int i = 0; i < test.length; i++) {
      System.out.print(test[i] + " ");
    }
    System.out.println("");
  }
}

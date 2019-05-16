import java.util.*;
public class HeapSort {
  public static void heapify(int[] array, int  n, int i) {
    int left = 2*i + 1;
    int right = 2*i + 2;
    int max = i;
    if (left < n && array[left] > array[max]) { //for reverse > => <
      max = left;
    }
    if (right < n && array[right] > array[max]) { // for reverse > => < 
      max = right;
    }
    if (max != i) {
      int temp = array[i];
      array[i] = array[max];
      array[max] = temp;
      heapify(array, n, max);
    }
  }
  public static void HeapSort(int[] array) {
    // loop all the nodes
    for (int i = array.length/2 - 1; i >= 0; i--) {
      heapify(array, array.length, i);
    };
    for (int i = array.length - 1; i >= 0; i--) {
      int temp = array[0];
      array[0] = array[i];
      array[i] = temp;
      heapify(array, i, 0);
    }
  }
  public static void main(String[] args) {
    int[] test = new int[]{3,4,1,2,6,7,3};
    HeapSort(test);
    for (int i = 0; i < test.length; i++) {
      System.out.print(test[i] + " ");
    }
    System.out.println("");
  }
}

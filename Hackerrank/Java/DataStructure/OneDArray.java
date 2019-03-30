import java.util.*;

/*
Task: create a array to store the sequential input to corresponding position in the array
input: a size and a list of Integers
output: print all the list of Integer from the array
*/
public class OneDArray {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        int x = 0;
        while (scan.hasNext()) {
            int e = scan.nextInt();
            a[x] = e;
            x++;
        }
        scan.close();

        // Prints each sequential element in array a
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}

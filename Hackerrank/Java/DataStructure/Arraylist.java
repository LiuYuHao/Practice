import java.io.*;
import java.util.*;

/*
Task:   givn n lines and each line contain zero or more integer, then later there has x and y on each line, need to find the corresponding value to the postion x y
Input: size of line and each line containes numbers, and size of line of position and each line contain x and y
Output: output the correct value for each position.
*/
public class Arraylist {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        // get the size of lines
        int size_lines = scanner.nextInt();
        // remove /n
        scanner.nextLine();
        // for store the size of each line
        String[] size = new String[size_lines];
        // the container to store the data
        ArrayList<String> container = new ArrayList<>();
        // a loop for each line
        for (int i = 0; i < size_lines; i++) {
           // split the line into individual integer
            String[] line = scanner.nextLine().split(" ");
            // store the size into size array
            size[i] = line[0];
            // subarray without size
            String[] temp = Arrays.copyOfRange(line, 1, line.length);
            // put it into arrarylist
            Collections.addAll(container, temp);
        }
        // for size of responds
        int size_finds = scanner.nextInt();
        // remove /n
        scanner.nextLine();
        // loop the size of responds
        for (int j = 0; j < size_finds; j++) {
            // get the x and y
            String[] find_line = scanner.nextLine().split(" ");
            int x = Integer.parseInt(find_line[0]);
            int y = Integer.parseInt(find_line[1]);
            // make sure the x should be less than amount of size of line
            if (x <= size_lines) {
              // y should less than the size of that line that y is corresponding to
                if (y <= Integer.parseInt(size[x - 1])) {
                  // range: the sum of size that before the y
                    int range = 0;
                    // loop the size
                    for (int i = 1; i < x; i ++) {
                      // add all the size before y
                        range = range + Integer.parseInt(size[i - 1]);
                    }
                    // get the corresponding value
                    System.out.println(container.get(range + y - 1));
                }
                // if y is bigger than size of that line, it means it is out of boundary.
                else {
                    System.out.println("ERROR!");
                }
            }
            // if x is bigger than size of line, it mean it is out of boundary.
            else {
                System.out.println("ERROR!");
            }
        }
    }
}

import java.io.*;
import java.util.*;

/*
Task: use list operation to add element at index and delete element at index
input: a size of array -> data of array -> size of case -> operation -> the data that corresponding to operation
output: the data from the array where after the operations.
*/
public class listProblem {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        String[] array = scanner.nextLine().split(" ");
        List<String> list = new ArrayList<>();
        Collections.addAll(list,array);
        int cases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < cases; i++) {
            String operation = scanner.nextLine();
            if (operation.equals("Insert")) {
                String[] info = scanner.nextLine().split(" ");
                int index = Integer.parseInt(info[0]);
                String data = info[1];
                list.add(index, data);
            }
            else if (operation.equals("Delete")) {
                int index = Integer.parseInt(scanner.nextLine());
                list.remove(index);
            }
        }
        for (String x: list) {
            System.out.print(x);
            System.out.print(" ");
        }
    }
}

import java.util.*;
/*
Task: a game: 0 is valid position, 1 is invlaid postion, it can +1 move and - 1 and jump which is x + leap, the winning condition is it arrive to/over end of array
Input: size of case, each case include size of array, jump and the array.
Output: win print YES, cannot win print N0
*/
public class OneDArray2 {

    public static boolean canWin(int leap, int[] game) {
        // recusive way - better readable and solution
//         private static boolean solvable(int [] array, int m, int i) {
//        /* Base Cases */
//        if (i < 0 || array[i] == 1) {
//          return false;
//        } else if (i + 1 >= array.length || i + m >= array.length) {
//          return true;
//        }
//
//        array[i] = 1; // marks as visited
//
//        /* Recursive Cases */
//        return isSolvable(array, m, i + m) ||
//              isSolvable(array, m, i + 1) ||
//              isSolvable(array, m, i - 1);
// }
        // Return true if you can win the game; otherwise, return false.
        // My way, I choose the hard way, but I solved it.
        int zero_index = -1;
        for (int i = 0; i < game.length; i++) {
            if (game[i] != 0) {
                zero_index = i;
                break;
            }
        }
        if (zero_index == -1) {
            return true;
        }
        if (leap == 0) {
            return false;
        }
        ArrayList<Integer> container = new ArrayList<>();
        for (int x = 0; x < zero_index; x++) {
            if (x + 1 > game.length - 1 || x + leap > game.length - 1) {
                return true;
            }
            else {
                if (game[x + leap] == 0) {
                    container.add(x + leap);
                }
            }
        }
        for (int y = 0; y < container.size(); y++) {
            for (int z = container.get(y) + 1; z < game.length; z++) {
                if (game[z] == 0 && z > 0) {
                    if (!container.contains(z)) {
                        container.add(z);
                    }
                    if (z + 1 >= game.length) {
                        return true;
                    }
                }
                else {
                    break;
                }
            }
            for (int z = container.get(y) - 1; z > 0; z--) {
                if (game[z] == 0) {
                    if (!container.contains(z)) {
                        container.add(z);
                    }
                }
                else {
                    break;
                }
            }
        }
        for (int i = 0; i < game.length; i++) {
            if (container.isEmpty()) {
                return false;
            }
            for (int y = 0; y < container.size(); y++) {
                if (container.get(y) + 1 > game.length - 1 || container.get(y) + leap > game.length - 1) {
                    return true;
                }
                else {
                    if (game[container.get(y) + leap] == 0) {
                        if (!container.contains(container.get(y) + leap)) {
                            container.set(y, container.get(y) + leap);
                        }
                    }
                    else {
                        container.remove(y);
                        y = y - 1;
                    }
                }
            }
            for (int x = 0; x <container.size(); x++) {
                for (int z = container.get(x) + 1; z < game.length; z++) {
                    if (game[z] == 0) {
                        if (!container.contains(z)) {
                            container.add(z);
                        }
                        if (z + 1 >= game.length) {
                            return true;
                        }
                    }
                    else {
                        break;
                    }
                }
                for (int z = container.get(x) - 1; z > 0; z--) {
                    if (game[z] == 0) {
                        if (!container.contains(z)) {
                            container.add(z);
                        }
                    }
                    else {
                        break;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}

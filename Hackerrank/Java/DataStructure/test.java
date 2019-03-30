import java.util.*;
import java.io.*;
public class test {

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
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
        for (int i = 0; i < game.length/leap; i++) {
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

    public static void main(String[] args) throws IOException  {
        File Out_file = new File("Output.txt");
        File In_file = new File("Input.txt");
        BufferedReader out = new BufferedReader(new FileReader(Out_file));
        BufferedReader in = new BufferedReader(new FileReader(In_file));
        ArrayList<String> result = new ArrayList<>();
        int p = 5000;
        while(p-- > 0) {
          String[] infor = in.readLine().split(" ");
          String[] data = in.readLine().split(" ");
          int[] data_int = new int[data.length];
          int size = Integer.parseInt(infor[0]);
          int leap = Integer.parseInt(infor[1]);
          for (int x = 0; x < data.length; x++) {
            data_int[x] = Integer.parseInt(data[x]);
          }
          result.add((canWin(leap, data_int)) ? "YES" : "NO");
        }
        String[] check = new String[5000];
        p = 5000;
        int count = 0;
        while(p-- > 0) {
          String s = out.readLine();
          check[count] = s;
          count++;
        }
        for (int i = 0; i < result.size();i++) {
          if (!result.get(i).equals(check[i])) {
            System.out.println(i);
          }
        }
    }
}

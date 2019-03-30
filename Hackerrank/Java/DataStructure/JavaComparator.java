import java.util.*;
/*
Task: create a checker class for compare the player class such that from high to low if same score, alph order
input: a size of players, and the player name and score
Output: print the player with corresponding order
*/
/*
Note: Use Comparator for mutil compares, use comparable(a.compareTo(a)) for natural order
*/
// Write your Checker class here
class Checker implements Comparator<Player>{
    // Override the compare
    @Override
    public int compare(Player p1, Player p2) {
      // when score is the same
        if (p1.score == p2.score) {
          // compareto has alph natural order.
            return p1.name.compareTo(p2.name);
        }
        else {
            // since it is high to lower, we p2 - p1
            return p2.score - p1.score;
        }
    }
}
class Player{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class JavaComparator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}

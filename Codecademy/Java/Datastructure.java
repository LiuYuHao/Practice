// import the arraylist
import java.util.*;

class Datastructure {
  public static void main(String[] args) {
    // for loop
    for (int i = 0;i < 10;i++) {
      System.out.print(i);
    }
    // array declaraction
    int[] array  = {10,20,30,40,50,60,71,80,90,91};
    int[] array2;
    array2 = new int[] {10,20,30,40,50,60,71,80,90,91};
    // arraylist declaraction
    ArrayList<Integer> test= new ArrayList<Integer>();
    // add to arraylist
    test.add(13);
    // access to arraylist
    System.out.println(test.get(0));
    // insertion of arraylist
    test.add(0,12);
    // get the size of ArrayList
    int x = test.size();
    System.out.println(x);
    System.out.println(array2.length);
    // another way to for loop of ArrayList and array: for each
    for(Integer v: test) {
      System.out.println(v);
    }
    // hash map declaraction
    HashMap<String, Integer> myFriends = new HashMap<String, Integer>();
    // add a valriabel to hashmap
    myFriends.put("text", 1);
    // access
    System.out.println(myFriends.get("text"));
    // size and iteration same as arraylist(for each and size())
    // for iteration, remmeber to use keyset to return the key list of map
    for (String item: myFriends.keySet()) {
      System.out.println(myFriends.get(item));
    }
  }
}

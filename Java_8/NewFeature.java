// Interface can have static method and default method
import java.util.stream.*; // contains classes or processing sequences elements
import java.util.*;
interface Test {
  // since it is static, it cannot be overriden
  static void s_Test() {
    System.out.println("Static method");
  }
  // if a class implement the class without overriden the method, default will be called
  default void d_Test() {
    System.out.println("Default method");
  }
}
class Test_class implements Test {
}
public class NewFeature {
  public static <T> void stream_print(Stream<T> s, String function_name) {
    // all the ways of print the element in stream
    // forEach
    System.out.print(function_name + ": ");
    s.forEach(element -> System.out.print(element + " ")); // or stream().forEach(System.out::print)
    System.out.println("");
    // Collect -> turn into collection/List
    // System.out.print("collect as list: ");
    // System.out.print(al.stream().collect(Collectors.toList()));
    // System.out.println("");
  }
  public static void main(String[] args) {
    Test.s_Test();
    Test_class tc = new Test_class();
    tc.d_Test();
    // stream creation
    // default stream creation
    // Stream<String> stream = list.stream();
    String[] arr = new String[]{"a", "b", "c"};
    // use Object(Collection and list).stream()
    Stream<String> stream = Arrays.stream(arr);
    // Stream.of()
    stream = Stream.of("a", "b", "c");

    ArrayList<String> al = new ArrayList<>();
    al.add("x");
    al.add("y");
    al.add("y");
    stream_print(al.stream(), "forEach");
    // Multi-threading with stream
    System.out.print("parallelStream: ");
    al.parallelStream().forEach(elements -> System.out.print(elements + " "));
    System.out.println("");
    // there are a lot of operations -> Intermediate operation (return stream) or terminal operation -> return a result
    /* Intermediate operations */
    // distinct -> return a stream of distinct element
    Stream<String> distinct_stream = al.stream().distinct();
    stream_print(distinct_stream, "distinct");
    // Filter -> get the element that matched to the condition
    Stream<String> filter_stream = al.stream().filter(element -> element.equals("y"));
    stream_print(filter_stream, "filter");
    // Map -> apply a function to elements inside of stream
    Stream<String> map_stream = al.stream().map(element -> element + "Map");
    stream_print(map_stream, "map");
    /* terminal operation */
    // flatMap -> flat the 2d array into one d. Bring the nest stream to one stream
    ArrayList<ArrayList<String>> al_al = new ArrayList<>();
    al_al.add(al);
    al_al.add(al);
    Stream<String> flatMap_stream = al_al.stream().flatMap(element -> element.stream());
    stream_print(flatMap_stream, "flatMap");
    // count -> return amount of element inside
    long count = al.stream().count();
    System.out.println("count() function: " + count);
    // anyMatch -> return true or false based on the condition
    boolean any = al.stream().anyMatch(element -> element.contains("x"));
    System.out.println("anyMatch() function find x: " + any);
    // allMatch -> return true if all the element match to condition
    boolean all = al.stream().allMatch(element -> element instanceof String);
    System.out.println("allMatch instanceof String: " + all);
    // noMatch -> return true if no element match to condition
    boolean none = al.stream().noneMatch(element -> element.equals("a"));
    System.out.println("noneMatch equals a: " + none);
    // reduce -> reduce the stream to a value where based on the function
    String sum = al.stream().reduce("", (start, element) -> start + element);
    System.out.println("reduce add all the string: " + sum);
    //Collect -> convert stream to collection such as map, arraylist, list...
    List<String> list = al.stream().collect(Collectors.toList());
    list = (ArrayList<String>) list;
    System.out.println("collect to list: " + al);
    // Collectors -> use for stream.collect
    // Collectors.toList() -> convert to list see above
    // Collectors.toSet() -> convert to set -remove the duplicate
    // Collectors.toCollection() -> help to convert to another datastructure with specified implementation
    HashSet<String> hs = al.stream().collect(Collectors.toCollection(HashSet::new));
    System.out.println("toCollection to HashSet: " + hs);
    // collectors.toMap(key, value, collison handle) -> convert to map
    Map<String, Integer> map = al.stream().collect(Collectors.toMap(element -> element, element -> 1, (item1, item2) -> item1 + item2));
    System.out.println("ToMap to HashMap: " + map);
    // Collectors.collectingAndThen() -> do the stuff after the collect.
    int x = al.stream().collect(Collectors.collectingAndThen(Collectors.toSet(), Set::size));
    System.out.println("collectingAndThen() convert to set and get the size: " + x);
    //joining(seperate, pre,post) -> combine all the elements in the stream
    String join = al.stream().collect(Collectors.joining(":", "Pre ",  "Post "));
    System.out.println("Join combine all elements: " + join);
    // integer test
    // int[] int_test_join = new int[]{1,2,3,4,5};
    // int int_join = Arrays.stream(int_test_join).collect(Collectors.joining()); method collect cannot applied to intStream
    // Collectors.counting() - counting of all stream elements
    long count_all = al.stream().collect(Collectors.counting());
    System.out.println("Couting(): " + count_all);
    // Collectors.summarizingDouble/Long/Int() - return statistical 
  }
}

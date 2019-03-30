
import java.io.IOException;
import java.lang.reflect.Method;

/*
Task: create a generic function which can print any data type of array
input: a array
output: a array
*/
class Printer
{
   //Write your code here
   public <T> void printArray(T[] a) {
       for(T element: a) {
           System.out.println(element);
       }
   }

}

public class GenericFunction {


    public static void main( String args[] ) {
        Printer myPrinter = new Printer();
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
        int count = 0;

        for (Method method : Printer.class.getDeclaredMethods()) {
            String name = method.getName();

            if(name.equals("printArray"))
                count++;
        }

        if(count > 1)System.out.println("Method overloading is not allowed!");

    }
}

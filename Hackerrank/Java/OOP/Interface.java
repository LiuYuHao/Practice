import java.util.*;
interface AdvancedArithmetic{
  int divisor_sum(int n);
}

//Write your code here
/*
Task: create a class call MyCalculator and complete the function divisor_sum in interface AdvancedArithmetic
*/
class MyCalculator implements AdvancedArithmetic {
    @Override
    public int divisor_sum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                sum = sum + i;
            }
        }
        return sum;
    }
}
class interface{
    public static void main(String []args){
        MyCalculator my_calculator = new MyCalculator();
        System.out.print("I implemented: ");
        ImplementedInterfaceNames(my_calculator);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(my_calculator.divisor_sum(n) + "\n");
      	sc.close();
    }
    /*
     *  ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented
     */
    static void ImplementedInterfaceNames(Object o){
      // this is how to u get the interface from a object, since there will be mutil interface, it should be class[]
        Class[] theInterfaces = o.getClass().getInterfaces();
        for (int i = 0; i < theInterfaces.length; i++){
          // same getName() get the name of interface
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }
    }
}

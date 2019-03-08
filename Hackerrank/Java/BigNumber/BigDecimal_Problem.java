import java.math.BigDecimal;
import java.util.*;

/*
Task: use BigDecimal class to sort the number in String, if duplicate the order should be the same as when it is input and the result should be the same format.
Input: size of array and the elements
output: a big to small order println and format should be the same as when they are input.
*/
class BigDecimal_Problem{
    public static void main(String []args){
      Scanner sc= new Scanner(System.in);
              int n=sc.nextInt();
              String []s=new String[n+2];
              for(int i=0;i<n;i++){
                  s[i]=sc.next();
              }
              sc.close();
        //Write your code here
        // this will not work since it didn't fix the problem of position of same equal value number such as 0.12 and .12
        // BigDecimal[] result = new BigDecimal[n];
        // for (int i = 0; i < n; i++){
        //     result[i] = new BigDecimal(s[i]);
        // }
        // for (int x = 0; x < n; x++) {
        //   for (int y = x + 1; y < n; y++) {
        //     if (result[x].compareTo(result[y]) == -1) {
        //       BigDecimal temp = result[x];
        //       result[x] = result[y];
        //       result[y] = temp;
        //
        //       String temp_2 = s[x];
        //       s[x] = s[y];
        //       s[y] = temp_2;
        //     }
        //   }
        // }
        //Output
        // override compare function in Comparator
        Arrays.sort(s, new Comparator<String>() {
          @Override
          public int compare(String s1, String s2) {
            if (s1 == null || s2 == null) {
              return 0;
            }
            BigDecimal BD1 = new BigDecimal(s1);
            BigDecimal BD2 = new BigDecimal(s2);
            return BD2.compareTo(BD1);
          }

        });
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}

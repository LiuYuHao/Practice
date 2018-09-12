import java.util.*;
import java.io.*;



class datatype{
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
        /*
        n can be fitted in:
        * dataType
        A byte is an 8-bit signed integer.
        A short is a 16-bit signed integer.
        An int is a 32-bit signed integer.
        A long is a 64-bit signed integer.
        */
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            try
            {
              long l=sc.nextLong();
              System.out.println(l+" can be fitted in:");
              if(l <= 127 && l >= -128){
                  System.out.println("* byte \n* short \n* int \n* long");
              }else if( l <= 32767 && l >= -32768){
                  System.out.println("* short \n* int \n* long");
              }else if ( l <= 2147483647 && l >= -2147483648){
                  System.out.println("* int \n* long");
              }else if(l <= 9223372036854775807l && l >= -9223372036854775808l){
                  System.out.println("* long");
              }
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }

        }
    }
}

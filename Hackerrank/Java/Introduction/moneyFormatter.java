import java.util.*;
import java.text.*;
/*
Task given a input number and output differents country format of money to the given input
*/
public class moneyFormatter {
    public static void main(String[] args) {
        // get the input
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        // using the class of NumberFormat
        NumberFormat usF = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat cnF = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat frF = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        // we need to create india since it is not built-in
        NumberFormat inF = NumberFormat.getCurrencyInstance(new Locale("en", "in"));

        // use the built in formate method to store to each countries
        String us = usF.format(payment);
        String india = inF.format(payment);
        String france = frF.format(payment);
        String china = cnF.format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}

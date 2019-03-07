import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

/*
task: make a pattern for IP ddd.ddd.ddd.ddd; d = digit
input: a continously input of Ip
output: do they match to the pattern
*/
class IpRegex{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}


//Write your code here
class MyRegex {
    // this represent all the number from 000 to 250
    // \\d{1,2} gets all the one digit and two digtis since it represent 1 or 2 times
    // (0|1)\\d{2}, for leading zero. 100 to 199 or 000 to 099
    // 2[0-4]\\d: 2[0-4] = 20 to 24, with a digit mean 200 to 249
    // 25[0-5] = 250 to 255;
    String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
public String pattern = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;
}

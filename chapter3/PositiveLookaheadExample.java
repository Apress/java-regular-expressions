import java.util.regex.*;
/**
* Demonstrates usage of a positive look ahead
*
* @author M Habibi
* @version 1.0   2/22/04 7:46 PM
*/

public class PositiveLookaheadExample{
    public static void main(String args[]){
        //define the pattern
        String regex = "(?=^255).*";

        //compile the pattern
        Pattern pattern = Pattern.compile(regex);

        //define the candidate string
        String candidate = "255.0.0.1";

        //extract a matcher for the candidate string
        Matcher matcher = pattern.matcher(candidate);

        String ip ="not found";

        //if the ip starts with 255, then the ip
        //will be populated with the correct information.
        if (matcher.find())
            ip=matcher.group();

        String msg ="ip: " + ip;

        System.out.println(msg);
     }
}
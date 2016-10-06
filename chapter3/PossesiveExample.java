import java.util.regex.*;
/**
* Demonstrates usage of a possessive qualifier
*
* @author M Habibi
* @version 1.0   2/22/04 7:46 PM
*/

public class PossesiveExample{
    public static void main(String args[]){
        //define the pattern
        String regex = "(\\w++)(\\d\\d)(\\w+)";
        //compile the pattern
        Pattern pattern = Pattern.compile(regex);

        //define the candidate string
        String candidate = "X99SuperJava";

        //extract a matcher for the candidate string
        Matcher matcher = pattern.matcher(candidate);

        if (matcher.find()){
            System.out.println("GROUP 0:" +
            matcher.group(0));
            System.out.println("GROUP 1:" +
            matcher.group(1));
            System.out.println("GROUP 2:" + matcher.group(2));
            System.out.println("GROUP 3:" + matcher.group(3));
        }
        else{
           System.out.println("NO MATCHES" );
        }

        System.out.println("Done");
    }
}
import java.util.regex.*;
/**
* Demonstrates usage of a Reluctant qualifier
*
* @author M Habibi
* @version 1.0   2/22/04 7:46 PM
*/

public class ReluctantExample{
    public static void main(String args[]){
        //define the pattern
        String regex = "(\\d+?)";
        //compile the pattern
        Pattern pattern = Pattern.compile(regex);

        //define the candidate string
        String candidate = "1234";

        //extract a matcher for the candidate string
        Matcher matcher = pattern.matcher(candidate);

        while (matcher.find()){
            //matches once for each digit
            //if this were not an example of
            //reluctant qualifier, it would match
            //exactly once, and that match would
            //include every digit in the candidate
            //string "1234".
            System.out.println(matcher.group());

        }

        System.out.println("Done");
    }
}
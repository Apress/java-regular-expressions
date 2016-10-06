import java.util.regex.*;

/**
* Demonstrates replacing text using regex
*
* @author M Habibi
* @version 1.0   2/22/04 7:46 PM
*/

public class ReplaceExample{
    public static void main(String args[]){
        //define the pattern
        String regex = "(\\w)(\\d)(\\w+)";

        //compile the pattern
        Pattern pattern = Pattern.compile(regex);

        //define the candidate string
        String candidate = "W3C";

        //extract a matcher for the candidate string
        Matcher matcher = pattern.matcher(candidate);

        //return a new string that has replaced
        //every matching part of the candidate string
        //with whatever was found in the third group,
        //followed by the digit three
        String tmp = matcher.replaceAll("$33");

        System.out.println("REPLACEMENT: " + tmp);
        //notice that the original candidate string
        //is unchanged, as expected. After all, strings
        //are immutable objects in java.
        System.out.println("ORIGINAL: " + candidate);
    }
}
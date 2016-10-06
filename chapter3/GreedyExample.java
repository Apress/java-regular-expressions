import java.util.regex.*;


/**
* Demonstrates usage of a greedy qualifier
*
* @author M Habibi
* @version 1.0   2/22/04 7:46 PM
*/

public class GreedyExample{
    public static void main(String args[]){
        //define the pattern
        String regex = "(\\w+)(\\d\\d)(\\w+)";

        //compile the pattern
        Pattern pattern = Pattern.compile(regex);

        //define the candidate string
        String candidate = "X99SuperJava";

        //extract a matcher for the candidate string
        Matcher matcher = pattern.matcher(candidate);

        matcher.find();

        //extract the matching groups
        System.out.println(matcher.group(1));//returns 'X'
        System.out.println(matcher.group(2));//returns '99'
        System.out.println(matcher.group(3));//returns Superjava
    }
}
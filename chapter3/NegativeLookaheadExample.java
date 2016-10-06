import java.nio.channels.*;

import java.util.regex.*;


/**
* Demonstrates usage of a negative look ahead
*
* @author M Habibi
* @version 1.0   2/22/04 7:46 PM
*/
public class NegativeLookaheadExample{
    public static void main(String args[])
    throws Exception
    {
        //define the pattern
        String regex = "John (?!Smith)[A-Z]\\w+";

        //compile the pattern
        Pattern pattern = Pattern.compile(regex);

        String candidate = "I think that John Smith ";
        candidate +="is a fictional character. His real name ";
        candidate +="might be John Jackson, John Westling, ";
        candidate +="or John Holmes. It might ";
        candidate +="just be John for all we know. ";


        //extract a matcher for the candidate string
        Matcher matcher = pattern.matcher(candidate);

        String tmp=null;

        //extract the matching group. Notice that it's
        //the default group, since lookarounds are non
        //capturing
        while (matcher.find()){
            tmp=matcher.group();
            System.out.println("MATCH:" + tmp);
        }
     }
}

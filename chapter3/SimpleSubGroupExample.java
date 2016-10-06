import java.util.regex.*;
/**
* Demonstrates usage of a simple sub group
*
* @author M Habibi
* @version 1.0   2/22/04 7:46 PM
*/

public class SimpleSubGroupExample{
    public static void main(String args[]){
        //the original pattern is always group 0
        Pattern p = Pattern.compile("\\w(\\d)");
        String candidate = "A9 is my favorite";

        //if there is a match, extract that parts that
        //matches.
        Matcher matcher = p.matcher(candidate);
        if (matcher.find()){
            //Extract 'A9', which matches group(0), which is
            //always the entire pattern itself.
            String tmp = matcher.group(0);
            System.out.println(tmp);

            //extract part of the candidate string that matches
            //group(1): Namely, the '9' following the 'A'
            tmp = matcher.group(1);
            System.out.println(tmp);
        }
    }
}
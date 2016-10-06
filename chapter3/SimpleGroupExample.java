import java.util.regex.*;
/**
* Demonstrates working with simple groups
*
* @author M Habibi
* @version 1.0   2/22/04 7:46 PM
*/

public class SimpleGroupExample{
    public static void main(String args[]){
        //the original pattern is always group 0
        Pattern p = Pattern.compile("\\w\\d");
        String candidate = "A9 is my favorite";

        //if there is a match, extract that part of
        //the candidate string that matches group(0)
        Matcher matcher = p.matcher(candidate);

        //OUTPUT is 'A9'
        if (matcher.find()){
            String tmp = matcher.group(0);
            System.out.println(tmp);
        }
    }
}
import java.util.regex.*;


/**
* Demonstrates finding all words that start with an 'a'
*
* @author M Habibi
* @version 1.0   2/22/04 7:58 PM
*/

public class FindA{
  public static void main(String args[])
  throws Exception{

    String candidate =
     "A Matcher examines the results of applying a pattern.";

    //define the matching pattern as a
    //word boundry, a lowercase a, any
    //number of immedietly trailing letters
    //numbers, or underscores, followed by
    //a word boundary
    String regex = "\\ba\\w*\\b";
    Pattern p = Pattern.compile(regex);

   //extract the Matcher for the String text
    Matcher m = p.matcher(candidate);
    String val=null;

    //display the original input string
    System.out.println("INPUT: " + candidate);

    //display the search pattern
    System.out.println("REGEX: " + regex +"\r\n");

   //examine the Matcher, and extract all
   //words starting with a lowercase a
    while (m.find())
    {
      val =  m.group();
      System.out.println("MATCH: " + val);
    }

    //if there were no matches, say so
    if (val == null) {
      System.out.println("NO MATCHES: ");
    }
  }
}
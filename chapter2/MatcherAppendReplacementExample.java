import java.util.regex.*;
import java.util.*;
/**
 * Demonstrates usage of the
 * Matcher.appendReplacement method
 */
public class MatcherAppendReplacementExample{
  public static void main(String args[]){
      test();
  }
  public static void test(){
     //create a Pattern
      Pattern p = Pattern.compile("(\\w+) (\\w+)");
      //create a StringBuffer
      StringBuffer sb =new StringBuffer();

     //create the candidate Strings
     String candidateString =
     "James Bond";

     String replacement = "$2, $1";
     //Attempt to match the first candidate String
     Matcher matcher = p.matcher(candidateString);
     matcher.matches();

     //populate the StringBufffer
     matcher.appendReplacement(sb,replacement);

     //display the output for the candidate
     String msg = sb.toString();

     System.out.println( msg );
  }
}


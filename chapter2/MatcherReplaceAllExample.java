import java.util.regex.*;
import java.util.*;
/**
 * Demonstrates usage of the
 * Matcher.replaceAll method
 */
public class MatcherReplaceAllExample{
  public static void main(String args[]){
      test();
  }
  public static void test(){
     //create a Pattern
      Pattern p = Pattern.compile("(i|I)ce");

     //create the candidate String
     String candidateString =
     "I love ice. Ice's my favorite. Ice Ice Ice.";

     Matcher matcher = p.matcher(candidateString);
     String tmp = matcher.replaceAll("Java");

     System.out.println( tmp );
  }
}


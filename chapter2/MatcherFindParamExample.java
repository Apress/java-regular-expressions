import java.util.regex.*;
/**
 * Demonstrates the usage of the
 * Matcher.find(int) method
 */
public class MatcherFindParamExample{
  public static void main(String args[]){
      test();
  }
  public static void test(){
     //create a Pattern
      Pattern p = Pattern.compile("mice", Pattern.CASE_INSENSITIVE);

     //create the candidate String
     String candidateString =
      "I hate mice. I really hate MICE.";

     //Attempt to match the candidate String.
     Matcher matcher = p.matcher(candidateString);

     //display the latter match
     System.out.println(candidateString);
     matcher.find(11);
     System.out.println(matcher.group());

     //display the earlier match
     System.out.println(candidateString);
     matcher.find(0);
     System.out.println(matcher.group());
  }
}


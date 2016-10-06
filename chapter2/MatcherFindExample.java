import java.util.regex.*;
/**
 * Demonstrates the usage of the
 * Matcher.find method
 */
public class MatcherFindExample{
  public static void main(String args[]){
      test();
  }
  public static void test(){
     //create a Pattern
      Pattern p = Pattern.compile("Java");

     //create the candidate String
     String candidateString =
      "I love Java. Java's my favorite language. Java Java Java.";

     //Attempt to match the candidate String.
     Matcher matcher = p.matcher(candidateString);

     //loop though and display all matches
     while (matcher.find()){
        System.out.println(matcher.group());
     }
  }
}


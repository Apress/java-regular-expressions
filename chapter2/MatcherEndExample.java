import java.util.regex.*;
/**
 * Demonstrates the usage of the
 * Matcher.start() method
 */
public class MatcherEndExample{
  public static void main(String args[]){
      test();
  }
  public static void test(){
     //create a Matcher and use the Matcher.end() method
     String candidateString = "My name is Bond. James Bond.";
     String matchHelper[] =
      {"               ^","                           ^"};
     Pattern p = Pattern.compile("Bond");
     Matcher matcher = p.matcher(candidateString);

     //Find the end point of the first 'Bond'
      matcher.find();
      int endIndex = matcher.end();
      System.out.println(candidateString);
      System.out.println(matchHelper[0] + endIndex);

     //Find the end point of the second 'Bond'
      matcher.find();
      int nextIndex = matcher.end();
      System.out.println(candidateString);
      System.out.println(matchHelper[1] + nextIndex);
  }
}


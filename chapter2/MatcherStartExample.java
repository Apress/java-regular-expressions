import java.util.regex.*;
/**
 * Demonstrates the usage of the
 * Matcher.start() method
 */
public class MatcherStartExample{
  public static void main(String args[]){
      test();
  }
  public static void test(){
     //create a Matcher and use the Matcher.start() method
     String candidateString = "My name is Bond. James Bond.";
     String matchHelper[] =
      {"          ^","                      ^"};
     Pattern p = Pattern.compile("Bond");
     Matcher matcher = p.matcher(candidateString);

     //Find the starting point of the first 'Bond'
      matcher.find();
      int startIndex = matcher.start();
      System.out.println(candidateString);
      System.out.println(matchHelper[0] + startIndex);

     //Find the starting point of the second 'Bond'
      matcher.find();
      int nextIndex = matcher.start();
      System.out.println(candidateString);
      System.out.println(matchHelper[1] + nextIndex);
  }
}


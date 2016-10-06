import java.util.regex.*;
/**
 * Demonstrates the usage of the
 * Matcher.start(int) method
 */
public class MatcherStartParamExample{
  public static void main(String args[]){
      test();
  }
  public static void test(){
     //create a Pattern
      Pattern p = Pattern.compile("B(ond)");

     //create a Matcher and use the Matcher.start(int) method
     String candidateString = "My name is Bond. James Bond.";
     //create a helpful index for the sake of output
     String matchHelper[] =
                             {"          ^",
                              "           ^",
                              "                      ^",
                              "                       ^"};
     Matcher matcher = p.matcher(candidateString);
     //Find the starting point of the first 'B(ond)'
      matcher.find();
      int startIndex = matcher.start(0);
      System.out.println(candidateString);
      System.out.println(matchHelper[0] + startIndex);

      //find the starting point of the first sub group (ond)
      int nextIndex = matcher.start(1);
      System.out.println(candidateString);
      System.out.println(matchHelper[1] + nextIndex);

     //Find the starting point of the second 'B(ond)'
      matcher.find();
      startIndex = matcher.start(0);
      System.out.println(candidateString);
      System.out.println(matchHelper[2] + startIndex);

      //find the starting point of the second sub group (ond)
      nextIndex = matcher.start(1);
      System.out.println(candidateString);
      System.out.println(matchHelper[3] + nextIndex);
  }
}


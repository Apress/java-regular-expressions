import java.util.regex.*;
/**
 * Demonstrates the usage of the
 * Matcher.end(int) method
 */
public class MatcherEndParamExample{
  public static void main(String args[]){
      test();
  }
  public static void test(){
     //create a Pattern
      Pattern p = Pattern.compile("B(on)d");

     //create a Matcher and use the Matcher.start(int) method
     String candidateString = "My name is Bond. James Bond.";
     //create a helpful index for the sake of output
     String matchHelper[] =
                             {"               ^",
                              "              ^",
                              "                           ^",
                              "                          ^"};
     Matcher matcher = p.matcher(candidateString);
     //Find the end point of the first 'B(ond)'
      matcher.find();
      int endIndex = matcher.end(0);
      System.out.println(candidateString);
      System.out.println(matchHelper[0] + endIndex);

      //find the end point of the first sub group (ond)
      int nextIndex = matcher.end(1);
      System.out.println(candidateString);
      System.out.println(matchHelper[1] + nextIndex);

     //Find the end point of the second 'B(ond)'
      matcher.find();
      endIndex = matcher.end(0);
      System.out.println(candidateString);
      System.out.println(matchHelper[2] + endIndex);

      //find the end point of the second sub group (ond)
      nextIndex = matcher.end(1);
      System.out.println(candidateString);
      System.out.println(matchHelper[3] + nextIndex);
  }
}


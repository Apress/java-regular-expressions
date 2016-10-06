import java.util.regex.*;
/**
 * Demonstrates the usage of the
 * Matcher.group() method
 */
public class MatcherGroupExample{
  public static void main(String args[]){
      test();
  }
  public static void test(){
      //create a Pattern
      Pattern p = Pattern.compile("Bond");

      //create a Matcher and use the Matcher.group() method
      String candidateString = "My name is Bond. James Bond.";
      Matcher matcher = p.matcher(candidateString);
      //extract the group
      matcher.find();
      System.out.println(matcher.group());
  }
}


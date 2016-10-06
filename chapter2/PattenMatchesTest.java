import java.util.regex.*;

/**
 * Demonstrates usage of the
 * Pattern.matches method
 */
public class PattenMatchesTest{
  public static void main(String args[]){

      String regex = "ad*";
      String input = "add";

      boolean isMatch = Pattern.matches(regex,input);
      System.out.println(isMatch);
  }
}
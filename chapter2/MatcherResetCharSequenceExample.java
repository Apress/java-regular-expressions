import java.util.regex.*;
/**
 * Demonstrates the usage of the
 * Matcher.reset(CharSequence) method
 */
public class MatcherResetCharSequenceExample{
  public static void main(String args[]){
      test();
  }
  public static void test(){
     String output="";
     //create a pattern, and extract a matcher
     Pattern p = Pattern.compile("\\d");
     Matcher m1 = p.matcher("01234");

     //exhaust the matcher
     while (m1.find()){
      System.out.println("\t\t" + m1.group());
     }
     //now reset the matcher with new data
     m1.reset("56789");
     System.out.println("After resetting the Matcher");
     //iterate though the matcher again.
     //this would not be possible without
     while (m1.find()){
      System.out.println("\t\t" + m1.group());
     }
  }
}
import java.util.regex.*;
/**
 * Demonstrates the usage of the
 * Matcher.LookingAt method
 */
public class MatcherLookingAtExample{
  public static void main(String args[]){
      test();
  }
  public static void test(){
     //create a Pattern
      Pattern p = Pattern.compile("J2SE");

     //create the candidate Strings
     String candidateString_1 = "J2SE is the only one for me";
     String candidateString_2 =
      "For me, it's J2SE, or nothing at all";
     String candidateString_3 = "J2SEistheonlyoneforme";

     //Attempt to match the candidate Strings.
     Matcher matcher = p.matcher(candidateString_1);
     //display the output for the candidate
     String msg = ":" + candidateString_1 + ": matches?: ";
     System.out.println( msg + matcher.lookingAt());

     matcher.reset(candidateString_2);
     //display the output for the candidates
     msg = ":" + candidateString_2 + ": matches?: ";
     System.out.println( msg + matcher.lookingAt());

     matcher.reset(candidateString_3);
     //display the output for the candidate
     msg = ":" + candidateString_3 + ": matches?: ";
     System.out.println( msg + matcher.lookingAt());

     /*
     *returns
     *:J2SE is the only one for me: matches?: true
     *:For me, it's J2SE, or nothing at all: matches?: false
     *:J2SEistheonlyoneforme: matches?: true
     */
  }
}


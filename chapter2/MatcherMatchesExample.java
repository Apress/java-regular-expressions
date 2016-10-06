import java.util.regex.*;
/**
 * Demonstrates the usage of the
 * Matcher.matches method
 */
public class MatcherMatchesExample{
  public static void main(String args[]){
      test();
  }
  public static void test(){
     //create a Pattern
      Pattern p = Pattern.compile("J2SE");

     //create the candidate Strings
     String candidateString_1 = "j2se";
     String candidateString_2 = "J2SE ";
     String candidateString_3 = "J2SE";

     //Attempt to match the candidate Strings.
     Matcher matcher_1 = p.matcher(candidateString_1);
     Matcher matcher_2 = p.matcher(candidateString_2);
     Matcher matcher_3 = p.matcher(candidateString_3);

     //display the output for first candidate
     String msg = ":" + candidateString_1 + ": matches?: ";
     System.out.println( msg + matcher_1.matches());

     //display the output for second candidate
     msg = ":" + candidateString_2 + ": matches?: ";
     System.out.println(msg + matcher_2.matches());

     //display the output for third candidate
     msg = ":" + candidateString_3 + ": matches?: ";
     System.out.println(msg + matcher_3.matches());
  }
}


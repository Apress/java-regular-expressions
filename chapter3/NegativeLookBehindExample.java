import java.util.regex.*;
import java.util.logging.Logger;
/**
* Demonstrates usage of a negative behind ahead
*
* @author M Habibi
* @version 1.0   2/22/04 7:46 PM
*/

   public class NegativeLookBehindExample{

   public static Logger log = Logger.getAnonymousLogger();

   public static void main(String args[])
   throws Exception
   {


      String regex="(";

      //compile the pattern
      Pattern pattern = Pattern.compile(regex);

      //extract a matcher for the candidate string
      String candidate = "Smithson";
      Matcher matcher = pattern.matcher(candidate);

      //display output
      String msg="";
      int counter =0;
      String tmp =null;
      while (matcher.find())
      {
         int start = matcher.start();
         int end = matcher.end();

         tmp = ":"+matcher.group()+":";
         msg +=tmp ;
         System.out.println("counter = " + counter);
         counter++;

         System.out.println("start = " + start);
         System.out.println("end = " + end);
         System.out.println("tmp = " + tmp);
         System.out.println("candidate.length() = "
         + candidate.length()+"\n");
      }

      System.out.println("      MSG = :"+msg+":");
      System.out.println("candidate = :"+candidate+":");

      }
}

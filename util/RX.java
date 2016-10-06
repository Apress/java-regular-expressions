import java.util.regex.*;
import java.io.*;

/////////////////////////////////////////////////////////////////////////////////////////////////

public class RX{
   public static void main(String args[]){


      if (args.length == 2){
         match(args[0],args[1]);
      }else{
         System.out.println("usage: target string first, regex second");

      }

   }
/////////////////////////////////////////////////////////////////////////////////////////////////
   public static boolean match(String string, String regex){
      // Compile the pattern
      boolean retval = false;
      Pattern p = null;

      p = Pattern.compile(regex, Pattern.MULTILINE | Pattern.DOTALL);

      //count the number of matches.
      int matches = 0;

      //get the matcher
      Matcher m = p.matcher(string);
      String val=null;

      System.out.println(m.groupCount());

      //find all matching Strings
      while (m.find()){
        val =  ":" + m.group() +":";
        System.out.println(val);
        matches++;
      }

      //if there were no matches, then announce it.
      if (val == null){
         System.out.println("NO MATCH");
      }else{
    retval= true;
         System.out.println(matches + " found");
      }

      return retval;
   }
 }


import java.util.logging.*;
import java.util.regex.*;

/**
* A utility for Splitting some text, optionally read from
* a file, to be split based on the given regex pattern,
* @author M Habibi
* @version 1.0   2/22/04 6:17 PM
*/
public class Spliter
{
   private static Logger log = Logger.getAnonymousLogger();

    /**
    * A utility for Splitting some text, optionally read from
    * a file, to be split based on the given regex pattern,
    * @param the <code>String</code> args[]
    * @throws <code>Exception</code>
    *
    * @author M Habibi
    */
   public static void main(String args[])  throws Exception
   {

      if (args != null && args.length == 2)
      {
        int groupNum = Integer.parseInt(args[2]);

        String[] tmp = args[0].split(args[1]);
        display(tmp);

      }
      else if(args.length == 3 && args[0].equals("-f")){
         String inputString = RegexUtil.getFileContent(args[1]);
         String[] tmp = inputString.split(args[2]);
      }
      else
     {
      String msg = "usage: <text> <pattern>\n";
      msg += "usage:-f <file> <pattern>\n";
      System.out.println(msg);
     }
   }

   /**
   * Displays the given String array
   * @param the <code>String[]</code> in
   *
   * @author M Habibi
   */
   private static void display(String[] in)
   {
      if (in != null && in[0] != null)
      {

         for (int i=0; i <in.length; i++)
         {
            System.out.println(in[i]);

         }
      }
   }
}

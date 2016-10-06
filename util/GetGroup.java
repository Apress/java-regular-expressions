import java.util.logging.*;
import java.util.regex.*;


/**
* A utility for extracting a specific regex group
* from a given text which is either passed in or in a file.
* Thus, for <code>Java (\w)(\w)(\w).* 3 </code> <code>v</code> is returned.
* Alternately, the input
* <code>"-f" "GetGroup.java" " class\s+(.*)\s+\{" "1"</code>
* would return the name of this Class, "GetGroup"
* @param the <code>String</code> args[]
* @throws <code>Exception</code>
* @author M Habibi
* @version 1.0   2/22/04 6:17 PM
*/
public class GetGroup
{
   private static Logger log = Logger.getAnonymousLogger();

   /**
   * Extracts the indicated Group from the given
   * text. Thus, for <code>Java (\w)(\w)(\w).* 3 </code>
   * <code>v</code> is returned.
   * Alternately, the input
   * <code>"-f" "GetGroup.java" " class\s+(.*)\s+\{" "1"</code>
   * would return the name of this Class, "GetGroup"
   * @param the <code>String</code> args[]
   * @throws <code>Exception</code>
   *
   * @author M Habibi
   */
   public static void main(String args[])  throws Exception
   {

      if (args != null && args.length == 3)
      {
        int groupNum = Integer.parseInt(args[2]);

        findGroup(args[0],args[1],groupNum);

     }
      else if(args.length == 4 && args[0].equals("-f")){
         String inputString = RegexUtil.getFileContent(args[1]);
         int groupNum = Integer.parseInt(args[3]);

        findGroup(inputString,args[2],groupNum);

      }
      else
     {
      String msg = "usage: <text> <pattern> <groupNum>\n";
      msg += "usage: <text> -f <file> <pattern> <groupNum>";
      System.out.println(msg);

     }

   }

   /**
   * extracts the indicated Group from the given
   * text. Thus, for <code>"Java" "(\w)(\w)(\w).*" "3"</code>
   * <code>v</code> is returned.
   */
   private static void findGroup(String text, String regex, int groupNum)
   {
      Pattern p = Pattern.compile(regex, Pattern.MULTILINE);

      Matcher m = p.matcher(text);

      if (m.find())
      {
         String g = m.group(groupNum);

         System.out.println("group find =:"+ g+":");
      }

      else
      {
         log.info("regex=:"+ regex+":");
         log.info("groupNum=:"+ groupNum+":");
         System.out.println("no matches found");

      }




   }
}

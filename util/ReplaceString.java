import java.util.logging.*;
import java.util.regex.*;

/**
* A utility for replace a subsection of a String with another String
* from a given text which is either passed in or in a file.
* Thus, for <code>"hi Waldo" "hi" "hello"</code>,
* <code>hello Waldo</code> is returned.
* Alternately, the input
* <code>"-f" "ReplaceString.java" "ReplaceString" "NewClassName"</code>
* would return the text that makes up this class, but replaces
* all instances of ReplaceString with NewClassName
* @param the <code>String</code> args[]
* @throws <code>Exception</code>
* @author M Habibi
* @version 1.0   2/22/04 6:17 PM
*/
public class ReplaceString
{
   private static Logger log = Logger.getAnonymousLogger();

    /**
    * For <code>"hi Waldo" "hi" "hello"</code>,
    * <code>hello Waldo</code> is returned.
    * Alternately, the input
    * <code>"-f" "ReplaceString.java" "ReplaceString" "NewClassName"</code>
    * would return the text that makes up this class, but replaces
    * all instances of ReplaceString with NewClassName
    * @param the <code>String</code> args[]
    * @throws <code>Exception</code>
    *
    * @author M Habibi
    */
   public static void main(String args[]) throws Exception
   {

      if (args != null && args.length == 3)
      {
        replaceString(args[0],args[1],args[2]);

      }
      else if (args != null && args.length == 4 && args[0].equals("-f"))
      {
        String inputString = RegexUtil.getFileContent(args[1]);
        replaceString(inputString,args[2],args[3]);

      }
     else
     {
      String msg = "usage: <text> <pattern> <replacement>\n";
      msg += "usage: -f <content File> <pattern> <replacement>";
      System.out.println(msg);

     }
   }

    /**
    * For <code>"hi Waldo" "hi" "hello"</code>,
    * <code>hello Waldo</code> is returned.
    * Alternately, the input
    * <code>"-f" "ReplaceString.java" "ReplaceString" "NewClassName"</code>
    * would return the text that makes up this class, but replaces
    * all instances of ReplaceString with NewClassName
    * @param the <code>String</code> text
    * @param the <code>String</code> regex
    * @param the <code>String</code> replace
    * @return <code>String</code>
    *
    * @author M Habibi
    */
   private static String replaceString(String text, String regex, String replace)
   {
      String retval =null;
      Pattern p = Pattern.compile(regex);

      Matcher m = p.matcher(text);

      retval = m.replaceAll(replace);
      System.out.println("OUT=:"+ retval+":\n");

      return retval;
   }


}

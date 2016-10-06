import java.util.regex.*;
import java.util.logging.Logger;

/**
* Applies the given regex pattern to the text in the
* strictest possible way. The text can be optionally
* read in from a file.
*
* @author M Habibi
* @version 1.0   2/22/04 6:57 PM
*/
public class StrictRX{
  private static Logger log = Logger.getAnonymousLogger();


  /**
  * Reads the users' input.
  * usage: java StrictRX <target> <regex>
  * usage: java StrictRX target <regexFile> <key>
  * usage: java StrictRX -f <inputSourceFile> <regexFile> <key>
  * where <target> is the text
  * where <regex> is the pattern to apply
  * where <regexFile> is the name of the property file
  * which contains the regex we can to use
  * where <key> is the name of the property in that property file
  * where <inputSourceFile> is name of a file which contains
  * the text we want to apply the pattern to.
  *
  * @param the <code>String</code> args[]
  * @throws <code>Exception</code>
  *
  * @author M Habibi
  */
  public static void main(String args[]) throws Exception{
      if (args.length == 2){
         compare(args[0],args[1]);
      }

      else if(args.length == 3 ){

         log.info("args0=:"+ args[0]+":");
         log.info("args1=:"+ args[1]+":");
         log.info("args2=:"+ args[2]+":");

         String pattern = RegexUtil.getProperty(args[1],args[2]);
         compare(args[0],pattern);
      }
      else if(args.length == 4 && args[0].equals("-f")){

         log.info("args0=:"+ args[0]+":");
         log.info("args1=:"+ args[1]+":");
         log.info("args2=:"+ args[2]+":");
         log.info("args3=:"+ args[3]+":");

         String inputString = RegexUtil.getFileContent(args[1]);

         String pattern = RegexUtil.getProperty(args[2],args[3]);
         compare(inputString,pattern);
      }
      else{
         System.out.println("usage: java StrictRX target regex");
         System.out.println("usage: java StrictRX target <regexFile> <key>");
         System.out.println("usage: java StrictRX -f <inputSourceFile> <regexFile> <key>");

      }
  }

  /**
  * Strictly compares the regex pattern to the given text
  * @param the <code>String</code> text
  * @param the <code>String</code> regex
  *
  * @author M Habibi
  */
  public static void compare(String text, String regex){

     //display the original input string
    System.out.println("INPUT:" + text+":");
    //display the search pattern
    System.out.println("REGEX:" + regex +":\r\n");

     if (text.matches(regex)) System.out.println ("MATCH: " + text);
     else System.out.println("NO MATCH");
  }
}

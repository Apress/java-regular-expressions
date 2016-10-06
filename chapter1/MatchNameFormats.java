import java.util.regex.*;

/**
* Demonstrates very primitive Name validation
*
* @author M Habibi
* @version 1.0   2/22/04 7:58 PM
*/
public class MatchNameFormats{
   public static void main(String args[]){

      isNameValid(args[0]);
   }

    /**
    * Confirms that the format for the given name is valid.
    * @param name a String representing the name.
    * @returns true if the name format is acceptable.
    */
    public static boolean isNameValid(String name){
      boolean retval=false;

      String nameToken ="\\p{Upper}(\\p{Lower}+\\s?)";

      //String nameToken ="A\\s?";

      String namePattern = "("+nameToken+"){2,3}";

      retval = name.matches(namePattern);

      //prepare a message indicating success or failure
      String msg = "NO MATCH: pattern:" + name
           + "\r\n           regex :" + namePattern;

      if (retval){
      msg = "MATCH     pattern:"  + name
           + "\r\n           regex :" + namePattern;
      }

      System.out.println(msg +"\r\n");
      return retval;
      }
}
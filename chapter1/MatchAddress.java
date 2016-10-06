import java.util.regex.*;
import java.io.*;

/**
* Demonstrates very primitive address validation
*
* @author M Habibi
* @version 1.0   2/22/04 7:58 PM
*/

public class MatchAddress{
    public static void main(String args[]){
        isAddressValid(args[0]);
    }

    /**
    * Confirms that the format for the given address is valid.
    * @param addr a String representing the address
    * @returns true if the zip code format is acceptable.
    */
    public static boolean isAddressValid(String addr){
       boolean retval = false;

      //use the name patten created earlier.
      String namePattern =
      "([A-Za-z])+ (([A-Za-z])+\\.? )?([A-Za-z])+\\s*";

      //use the zip code patten created earlier.
      String zipCodePattern = "\\d{5}(-\\d{4})?";

      //contruct am address pattern,
      String addressPattern = "^" + namePattern
         + "\\w+ .*, \\w+ " + zipCodePattern +"$";

      retval= addr.matches(addressPattern);

      //prepare a message indicating success or failure
      String msg = "   NO MATCH: pattern:" + addr
         + "\r\n             regexLength: "
         + namePattern;

      if (retval){
      msg = "   MATCH   : pattern:" + addr
         + "\r\n             regexLength: "
         + namePattern;
      }

      System.out.println(msg +"\r\n");
      return retval;
    }
}
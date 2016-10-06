
/**
* Demonstrates very primitive zip code validation
*
* @author M Habibi
* @version 1.0   2/22/04 7:58 PM
*/
import java.util.regex.*;
import java.io.*;

public class MatchZipCodes{
   public static void main(String args[]){
      isZipValid(args[0]);
   }

   /**
   * Confirms that the format for the given zip code is valid.
   * @param zip a String representing the zip code.
   * @returns true if the zip code format is acceptable.
   */
   public static boolean isZipValid(String zip){
      boolean retval=false;

      String zipCodePattern = "\\d{5}(-\\d{4})?";
      retval = zip.matches(zipCodePattern);

      //prepare a message indicating success or failure
      String msg = "   NO MATCH: pattern:" + zip
             + "\r\n             regex: " + zipCodePattern;

      if (retval){
      msg = "   MATCH   : pattern:" + zip
          + "\r\n             regex: " + zipCodePattern;
      }

      System.out.println(msg +"\r\n");
      return retval;
   }
}
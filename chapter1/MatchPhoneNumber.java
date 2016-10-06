import java.util.regex.*;
/**
* Demonstrates very primitive phone number validation
*
* @author M Habibi
* @version 1.0   2/22/04 7:58 PM
*/
public class MatchPhoneNumber{
   public static void main(String args[]){
      isPhoneValid(args[0]);
   }

   /**
   * Confirms that the format for the given phone number is valid.
   * @param phone a String representing the phone number.
   * @returns true if the phone number format is acceptable.
   */
   public static boolean isPhoneValid(String phone){
      boolean retval=false;

      String phoneNumberPattern =
        "(\\d-)?(\\d{3}-)?\\d{3}-\\d{4}";

      retval= phone.matches(phoneNumberPattern);

      //prepare a message indicating success or failure
      String msg = "   NO MATCH: pattern:" + phone
             + "\r\n             regex: " + phoneNumberPattern;

      if (retval){
      msg = "   MATCH   : pattern:" + phone
          + "\r\n             regex: " + phoneNumberPattern;
      }

      System.out.println(msg +"\r\n");
      return retval;
   }
}
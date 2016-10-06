import java.util.regex.*;
import java.io.*;


/**
* Demonstrates very primitive date validation
*
* @author M Habibi
* @version 1.0   2/22/04 7:58 PM
*/
public class MatchDates{
   public static void main(String args[]){
      isDateValid(args[0]);
   }

   /**
   * Confirms that given date format consists of one or two digits
   * followed by a hyphen, followed by one or two digits, followed
   * by a hypen, followed by four digits
   * @param date a String representing the date.
   * @returns true if data format is acceptable.
   */
   public static boolean isDateValid(String date){
      boolean retval=false;

      String datePattern ="\\d{1,2}-\\d{1,2}-\\d{4}";
      retval = date.matches(datePattern);

      //prepare a message indicating success or failure
      String msg = "   NO MATCH: pattern:" + date
             + "\r\n             regexLength: " + datePattern;

      if (retval){
      msg = "   MATCH   : pattern:" + date
          + "\r\n             regexLength: " + datePattern;
      }

      System.out.println(msg +"\r\n");
      return retval;
   }
}
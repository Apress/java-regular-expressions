import java.util.regex.*;
import java.io.*;
import java.util.logging.Logger;
import java.util.GregorianCalendar;
import java.util.Calendar;

/**
*Matches dates
*/
public class MatchDates{
private static final String PROP_FILE = "../regex.properties";
private static Logger log = Logger.getAnonymousLogger();
public static int LOWER_YEAR_LIMIT = -120;

   public static void main(String args[]) throws Exception{
      if (args != null && args.length==1)
      {
        boolean b =isDateValid(args[0]);
        log.info(""+b);
      }
      else
      {
        System.out.println("usage: java MatchDates dd/dd/dddd");
      }
   }

   /**
   * Confirms that given date format consists of one or two digits
   * followed by a punctuation, followed by one or two digits
   * followed by a hypen, followed by two or four digits. Further,
   * it actually validates that the date is less then today, and
   * and not more then <CODE>LOWER_YEAR_LIMIT</CODE> =120 years in
   * the past. This method even takes leap years and such into account
   * @param date a String representing the date.
   * @returns true if data format is acceptable.
   */
   public static boolean isDateValid(String date)
   {
     boolean retval=false;

     String[] dateTokens = date.split("\\p{Punct}");

     if (dateTokens.length == 3)
     {
      //Java months are zero based, so subtract 1
      int month = Integer.parseInt(dateTokens[0]) -1;
      int day = Integer.parseInt(dateTokens[1]);
      int year = Integer.parseInt(dateTokens[2]);

      //in case a 2 digit year was entered
      if (year < 100)
        year += 2000;

      //get boundary years
      GregorianCalendar today = new GregorianCalendar();
      //get a lowerLimit that is LOWER_YEAR_LIMIT less then
      //today
      GregorianCalendar lowerLimit = new GregorianCalendar();
      lowerLimit.add(Calendar.YEAR, LOWER_YEAR_LIMIT);

      //create a candidate representing the proposed date.
      GregorianCalendar candidate =
      new GregorianCalendar(year, month,day);

      //check the validity of the date
      if
      (
       candidate.before(today)
       &&
       candidate.after(lowerLimit)
       &&//month could be off, say the user entered 55
       month == candidate.get(Calendar.MONTH)
       &&//day could be off, say the user entered 55
       day == candidate.get(Calendar.DAY_OF_MONTH)
      )
      {
          retval = true;
      }
     }
     return retval;
   }
}

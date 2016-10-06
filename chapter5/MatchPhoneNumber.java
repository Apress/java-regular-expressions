  import java.util.regex.*;
  import java.util.logging.Logger;


  /**
  * Matches phone numbers.
  *
  * @author M Habibi
  * @version 1.0   2/22/04 7:41 PM
  */
  public class MatchPhoneNumber{
     private static Logger log = Logger.getAnonymousLogger();
     private static final String   PHONE_NUMBER_KEY="phoneNumber";
     /**
     * Confirms that the format for the given phone number is valid.
     * @param phone a String representing the phone number.
     * @returns true if the phone number format is acceptable.
    */
    public static boolean isPhoneValid(String phone){
       boolean retval=false;
           String msg = "\r\nCANDIDATE:" + phone;


       //make sure the candidate has a shot of passing
       if (phone != null && phone.length() > 6)
       {
           //load the regex properties file
           RegexProperties rb = new RegexProperties();
           try
           {
             rb.load("../regex.properties");
           }
           catch(Exception e)
           {
                 e.printStackTrace();
           }

           //scrub the phone number, removing spaces
           //and punctuation. We could store this
           //pattern in the regex .property file as well,
           //but it's not really so complex that's
           //it's confusing when java-delimited
           String tmp = phone.replaceAll("\\p{Punct}|\\s","");

           //extract appropriate regex pattern and run check
           //in this case (\d{3})?\d{3}\d{4}
           String phoneNumberPattern=rb.getProperty(PHONE_NUMBER_KEY);

           //do the actual comparison
           retval= tmp.matches(phoneNumberPattern);

           //log for debug purposes
           msg += ":\r\nREGEX:" + phoneNumberPattern;
       }
       msg += "\r\nRESULT:" + retval +"\r\n";
       log.info(msg);
       return retval;
    }
   public static void main(String args[]) throws Exception{
     if (args != null && args.length == 1)
        System.out.println(isPhoneValid(args[0]));
     else
        System.out.println("usage: java MatchPhoneNumber <phoneNumber>");
    }
 }

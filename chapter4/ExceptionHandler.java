import java.util.logging.*;
import java.util.regex.*;
/**
 * Listens for exceptions in the log entries
 * @author M Habibi
 */
public class ExceptionHandler extends StreamHandler{

    /**
    * examines the record being logged, and checks to see if
    * it contains an exception
    * @param record the LogRecord about to be logged
    */
    public void publish(LogRecord record){
        //extract the message
        String msg = record.getMessage();

        //check to see the message contains an exception
        int exceptionIndex = msg.indexOf("Exception");

        //if the message didn't contains the String
        //'Exception', then don't bother compiling the regex
        if (exceptionIndex > -1){

            Pattern pattern =
              Pattern.compile("(.*Exception.*)");

            Matcher matcher = pattern.matcher(msg);

            if (matcher != null && matcher.find()){
                String err = "EXCEPTION FOUND " + matcher.group(1);
               System.out.println(err);
               //put emailer here
            }
        }
    }
}

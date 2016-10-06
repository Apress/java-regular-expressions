import java.util.logging.*;

/**
* Demonstrates the usage of the log listener
*/
public class LogDemo{
    public static void main(String args[]){
        Logger log = Logger.global;
        setLoggerhandler(log);

        //test the code. Do even finest grade entries get
        //logged?
        log.finest(new Exception().toString());
    }

    /**
    * Sets a logger handler for the given log.
    * @param log the logger which needs an listener
    * @version 1.0 5/12/2002
    */
    public static void setLoggerhandler(Logger logger){
        Handler handler = new ExceptionHandler();
        logger.addHandler(handler);

        //set to handle all errors, so that it will examine
        //all errors.
        logger.setLevel(Level.ALL);
    }
}

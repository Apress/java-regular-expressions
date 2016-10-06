import java.io.*;
import java.util.logging.Logger;
import java.util.regex.*;

/**
*Validates zip codes from the given country.
*@author M Habibi
*/
public class MatchZipCodes{
    private static Logger log = Logger.getAnonymousLogger();
    private static final String ZIP_PATTERN="zip";
    private static RegexProperties regexProperties;
    //load the regex properties file
    //do this at the class level
    static
    {
        try
        {
            regexProperties = new RegexProperties();
            regexProperties.load("../regex.properties");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        String msg = "usage: java MatchZipCodes countryCode Zip";

        if (args != null && args.length == 2)
            msg = ""+isZipValid(args[0],args[1]);

        //output either the usage message, or the results
        //of running the isZipValid method
        System.out.println(msg);
    }

    /**
    * Confirms that the format for the given zip code is valid.
    * @param the <code>String</code> countryCode
    * @param the <code>String</code> zip
    * @return <code>boolean</code>
    *
    * @author M Habibi
    */
    public static boolean isZipValid(String countryCode, String zip)
    {
        boolean retval=false;
        //use the country code for form a unique into the regex
        //properties file
        String zipPatternKey = ZIP_PATTERN + countryCode.toUpperCase();

        //extract the regex pattern for the given country code
        String zipPattern = regexProperties.getProperty(zipPatternKey);

        //if there was some sort of problem, don't bother trying
        //to execute the regex
        if (zipPattern != null)
            retval = zip.trim().matches(zipPattern);
        else
        {
            String msg = "regex for country code "+countryCode;
            msg+= " not found in property file ";
            log.warning(msg);
        }
        //create log report
        String msg = "regex="+zipPattern +
        "\nzip="+zip+"\nCountryCode="+
        countryCode+"\nmatch result="+retval;
        log.finest(msg);

        return retval;
    }
}
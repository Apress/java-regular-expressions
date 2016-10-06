
import java.util.Properties;
import java.util.regex.*;
import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.logging.Logger;


/**
* Provides a read-only extension of the java.util.properties file.
* This class is unique because it is especially designed to read in
* regular expressions which are not double delimited, as the String
* class requires. Thus, \s is the actual string used to represent a
* whitespace character, not \\s. Accordingly, this class does not allow
* the regex patterns to be modified programmatically, nor does it
* follow the normal <code>Property</code> file convention for \n,\t, etc.,
* or multiline properties. Please see the documentation for the
* load method.
*/
public class RegexProperties extends Properties{
    private static Logger log = Logger.getAnonymousLogger();
    private String fileContent=null;

    /**
    * loads the file. @See load(FileInputStream inStream)
    *
    * @param String the name of the file to load
    * @throws IOException if there's an IO problem
    * @throws  PatternSyntaxException if the File format isn't properly
    * formed, per the specification given above.
    */

    public void load(String inStream)
    throws IOException, PatternSyntaxException{
        load(new FileInputStream(inStream));
    }
    /**
    * Specialized property file for reading regular expressions
    * stored as properties. Reads a property list (key and
    * element pairs) from the input stream using a FileChannel,
    * thus allowing the usage of all characters. The stream is
    * assumed to be using the ISO 8859-1 character encoding.
    * Every property occupies one line of the input stream. Each
    * line is terminated by a line terminator (\n or \r or \r\n).
    * The entire contents of the file are read in.
    *
    A line that contains only whitespace or whose first
    * non-whitespace character is an ASCII # or ! is ignored
    * (thus, # or ! indicate comment lines).
    *
    * Every line other than a blank line or a comment line describes
    * one property to be added to the table. The key consists of
    * all the characters in the line starting with the first
    * non-whitespace character and up to, but not including,
    * the first ASCII =, :, or whitespace character. Any whitespace
    * after the key is skipped; if the first non-whitespace character
    * after the key is = or :, then it is ignored. White space character
    * after the = or ; are <B>not</B> skipped, and become part of the
    * value. This is a deliberate change from the default behavior of
    * the class, in order to support regular expressions, which may very
    * well need those characters. All remaining characters on the line
    * become part of the associated element string. If the last
    * character on the line is \, then the next line is <B>not </B>
    * treated as a continuation of the current line. Again, this is a
    * deliberate change from the default behavior of the class, in
    * order to support regular expressions.
    *
    * @param FileInputStream inStream the actual property file
    * @throws IOException if there's an IO problem
    * @throws  PatternSyntaxException if the File format isn't properly
    * formed, per the specification given above.
    */

   public void load(FileInputStream inStream) throws IOException, PatternSyntaxException{
    // load the contents of the file
    FileChannel fc = inStream.getChannel();

    ByteBuffer bb = ByteBuffer.allocate((int)fc.size());
    fc.read(bb);
    bb.flip();
    fileContent = new String(bb.array());

    //define a pattern that breaks the contents down line by line
    Pattern pattern = Pattern.compile("^(.*)$",Pattern.MULTILINE);
    Matcher matcher = pattern.matcher(fileContent);

    //iterate through the fileContent, line by line
    while (matcher.find()){
        //extract the relevant part of each file.
        //in this case, relevant means the characters
        //between the beginning of the line and it's end
        String line = matcher.group(1) ;

        //if the line is null or a comment, ignore it
        if (
            line != null &&
            !"".equals(line.trim()) &&
            !line.startsWith("#") &&
            !line.startsWith("!")
        )
        {
            String keyValue[] = null;

            //was the kay-value entry split with the '='
            //character or the ':' character? Both are legal.
            if (line.indexOf("=") > 0  )
              keyValue = line.split("=",2);
            else
              keyValue = line.split(":",2);

            //final check that keyValue isn't null, because we
            //are going to be entering into a map, and trimming it
            if (keyValue != null)
            {
                super.put(keyValue[0].trim(),keyValue[1]);
            }
        }
    }

    fc = null;
    bb = null;
   }
    /**
    * Not supported. This is designed to be read only class
    * Throws UnsupportedOperationException.
    * @param String the key to be placed into this property
    * list.
    * @param  String the value corresponding to key.
    * @throws UnsupportedOperationException
    *
    */
    public void store(FileOutputStream out, String header)
    throws UnsupportedOperationException
    {
        String msg = "unsupported for this class";
        throw new UnsupportedOperationException(msg);
    }
    /**
    * Not supported.
    * @param Object t - Mappings to be stored in this map.
    *
    * @returns nothing, since this call always throws an
    * UnsupportedOperationException.
    * @throws  UnsupportedOperationException
    */
    public void putAll(Map t)
   {
        String msg = "unsupported for this class";
        throw new UnsupportedOperationException(msg);
   }

}

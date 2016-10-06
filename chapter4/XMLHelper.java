import java.io.*;
import java.beans.*;

/**
* Helps persist an Serializable object to XML,
* and back again.
*/
public class XMLHelper{
    public static void main(String args[]){
        Regex regex = new Regex();
        regex.setRegex("<((?i)TITLE>)(.*?)</\\1");

        String desc =
        "extracts the title element from an html page";

        regex.setDescription(desc);

        saveXML(regex, "htmlTitle.xml");

    }

    /**
    * Saves the Serializable as an XML file
    * @param ser the object to persist
    * @param fileName the file to save it to.
    */
    public static void saveXML(Serializable ser, String fileName){

        try{
            XMLEncoder e = new XMLEncoder(
            new BufferedOutputStream(
            new FileOutputStream(fileName)));
            e.writeObject(ser);
            e.close();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }

    }
    /**
    * get the Serializable from XML file
    * @param fileName the file to get the data from.
    * @return ser the object to persist
    */
    public static Serializable getXML(String fileName){
    Serializable retval= null;
    try{
        XMLDecoder d = new XMLDecoder(
        new BufferedInputStream(
        new FileInputStream(fileName)));
        retval = (Serializable)d.readObject();
        d.close();

    }
    catch(IOException ioe){
        ioe.printStackTrace();
    }

    return retval;

    }
}

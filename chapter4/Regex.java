/**
* Holds a regex friendly object, so that we can try
* persisting regex patterns as XML
*/
public class Regex implements java.io.Serializable{

    /**
    * sets the String description
    *
    *@param String description
    */
    public void setDescription(String description){
        this.description = description;
    }

    /**
    * gets String description
    *
    *@return String description
    */
    public String getDescription(){
        return this.description;
    }

    /**
    * sets the String regex
    *
    *@param String regex
    */
    public void setRegex(String regex){
        this.regex = regex;
    }

    /**
    * gets String regex
    *
    *@return String regex
    */
    public String getRegex(){
        return this.regex;
    }

    private String regex;
    private String description;
}

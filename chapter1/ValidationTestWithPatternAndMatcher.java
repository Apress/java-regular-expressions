    import java.util.regex.*;


    /**
    * Demonstrates very simple validation using the
    * Patten and Matcher objects.
    *
    * @author M Habibi
    * @version 1.0   2/22/04 7:57 PM
    */
    public class ValidationTestWithPatternAndMatcher{
       public static void main(String args[]){

        // Compile the pattern
        Pattern p = null;
        try{
          p = Pattern.compile("Java \\d");
        }
        catch (PatternSyntaxException pex){
           pex.printStackTrace();
           System.exit(0);
        }

        //define the matcher string

        String candidate = "I love Java 4";
        //get the matcher
        Matcher m = p.matcher(candidate);

        if (m!=null) System.out.println(m.find());
       }
    }

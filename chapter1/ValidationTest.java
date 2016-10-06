import java.util.regex.*;
/**
* Demonstrates very simple validation
*
* @author M Habibi
* @version 1.0   2/22/04 7:57 PM
*/

public class ValidationTest{
   public static void main(String args[]){
        String candidate = "I love Java 4";
        String  pattern = "Java \\d";
        System.out.println(candidate.matches(pattern));
   }
}

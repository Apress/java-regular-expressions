import java.util.regex.*;



/**
* Demonstrates usage of the Pattern split method
*
* @author M Habibi
* @version 1.0   2/22/04 7:56 PM
*/
public class PatternSplit{
    public static void main(String args[])
    {
        String statement = "I will not compromise. I will not "+
        "cooperate. There will be no concession, no conciliation, no "+
        "finding the middle ground, and no give and take.";

        String splitPattern = "compromise|cooperate|concession|"+
        "conciliation|(finding the middle ground)|(give and take)";

        Pattern p = Pattern.compile(splitPattern);

        String[] tokens = p.split(statement);

        System.out.println("REGEX PATTERN:\n"+splitPattern+"\n");
        System.out.println("STATEMENT:\n"+statement+"\n");

        System.out.println("TOKENS:");

        for (int i=0; i < tokens.length;i++)
        {
            System.out.println(tokens[i]);

        }

    }

}
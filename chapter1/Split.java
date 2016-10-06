/**
* Demonstrates very simple String manipulation using
* English synonyms.
*
* @author M Habibi
* @version 1.0   2/22/04 7:58 PM
*/

public class Split{
   public static void main(String args[]){

      /*String statement = "I will not compromise. I will not "+
      "cooperate. There will be no concession, no conciliation, no "+
      "finding the middle group, and no give and take.";*/

      String statement = "DOG";

      String tokens[]  =null;

      String splitPattern= "compromise|cooperate|concession|"+
      "conciliation|(finding the middle group)|(give and take)";

      tokens=statement.split(splitPattern);

      System.out.println("REGEX PATTERN:\n"+splitPattern + "\n");

      System.out.println("STATEMENT:\n"+statement + "\n");


      System.out.println("TOKENS:");
      for (int i=0; i < tokens.length; i++){
      System.out.println(tokens[i]);
      }
   }
}


/**
* Demonstrates very simple String manipulation using
* English synonyms.
*
* @author M Habibi
* @version 1.0   2/22/04 7:58 PM
*/
public class StyleSplitExample{
   public static void main(String args[]){
      String phrase1= "but simple justice, not charity";
      strengthenSentence(phrase1);

      String phrase2=
       "but that I love Rome more, not that I love Ceaser less";
      strengthenSentence(phrase2);

      String phrase3=
      "ask what you can do for your country, ask not what your "
      + "country can do for you";
      strengthenSentence(phrase3);
   }

   /**
   * Splits and rearranges the given String, hopefully to a more
   * powerful effect.
   * @param sentence a String representing the phrase we want to
   * strengthen.
   * @returns a String representing the modified phrase.
   */
   public static String strengthenSentence(String sentence){
      String retval=null;

      String[] tokens = null;

      String splitPattern =
        ",";

      tokens= sentence.split(splitPattern);

      if (tokens==null){
         String msg = "   NO MATCH: pattern:" + sentence
             + "\r\n             regex: " + splitPattern;
      }
      else{
         retval = tokens[1] + ", " + tokens[0];
         System.out.println("BEFORE: " + sentence);
         System.out.println("AFTER : " + retval +"\n");
      }
      return retval;
   }
}
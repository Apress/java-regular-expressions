/**
* Demonstrates very simple String manipulation using
* English synonyms.
*
* @author M Habibi
* @version 1.0   2/22/04 7:58 PM
*/

public class StyleSearchAndReplace{
  public static void main(String args[]){

    String statement = "The question as to whether the jab is"+
    " superior to the cross has been debated for some time in"+
    " boxing circles. However, it is my opinion that this"+
    " false dichotomy misses the point. I call your attention"+
    " to the fact that the best boxers often use a combination of"+
    " the two. I call your attention to the fact that Mohammed"+
    " Ali,the Greatest of the sport of boxing, used both. He had"+
    " a tremendous jab, yet used his cross effectively, often, and"+
    " well";

    String newStmt=
    statement.replaceAll("The question as to whether","Whether");

    newStmt= newStmt.replaceAll(" of the sport of boxing","");
    newStmt=newStmt.replaceAll("amount of success","success");
    newStmt=
     newStmt.replaceAll("However, it is my opinion that this","This");

    newStmt= newStmt.replaceAll("a combination of the two","both");
    newStmt= newStmt.replaceAll("This is in spite of the fact that"
     +" the", "The");
    newStmt=
     newStmt.replaceAll("I call your attention to the fact that","");

   System.out.println("BEFORE:\n"+statement + "\n");
   System.out.println("AFTER:\n"+newStmt);
  }
}
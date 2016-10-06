import java.util.regex.*;

/**
 * Demonstrates usage of the
 * Pattern.compile method
 */
public class PatternMethodExample{
  public static void main(String args[]){
      reusePatternMethodExample();
  }

   public static void reusePatternMethodExample(){
      //match a single digit
      Pattern p = Pattern.compile("\\d");
      Matcher matcher = p.matcher("5");
      boolean isOk = matcher.matches();
      System.out.println("original pattern matches " + isOk);

      //recycle the pattern
      String tmp = p.pattern();
      Pattern p2 =  Pattern.compile(tmp);
      matcher = p.matcher("5");
      isOk = matcher.matches();
      System.out.println("second pattern matches " + isOk);
   }
}
import java.util.regex.*;

/**
 * Demonstrates usage of the
 * Matcher.pattern method
 */
public class MatcherPatternExample{
  public static void main(String args[]){
      test();
  }

  public static void test(){
     Pattern p = Pattern.compile("\\d");
     Matcher m1 = p.matcher("55");
     Matcher m2 = p.matcher("fdshfdgdfh");

     System.out.println(m1.pattern() == m2.pattern());
  }

}
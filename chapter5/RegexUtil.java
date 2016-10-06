
import java.util.Properties;
import java.util.regex.*;
import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.logging.Logger;
import java.nio.charset.Charset;


/**
* Provides general File regex Utilities. Allows clients to
* search and update files.
* @author M Habibi
*/
public class RegexUtil{
   public static void main(String args[]) throws Exception
   {
      System.out.println(searchFile(args[0],args[1],-1));
   }

   RegexUtil(){

   }

    private static Logger log = Logger.getLogger("com.influxs.util");

   /**
    * Searches the specified File, and returns substrings
    * that match the given pattern as an Map. if the pattern
    * doesn't have any punctuation in it, then it's assumed that
    * the user intended to capture the entire line of that match
    * @param String fileName the name of the file to search
    * @param  String searchPattern the pattern to apply in
    * the search
    * @param flags. The regex flags the client wants applied to this
    * pattern. A negative number means no flags.
    * @throws IOException if there's an IO error
    *
    * @return Map of found Strings. The key to the map is the
    * position at which the element was found(as a String).
    * the value is the actual text. If there are no matches,
    * an empty Map is returned.
    */
    public static Map searchFile(
        String file,
        String searchPattern,
        int flags
    ) throws IOException
    {

       String fileContent = getFileContent(file);
       log.finest("file=:"+ file+":");
       log.finest("searchPattern=:"+ searchPattern+":");

       //if the search pattern doesn't have any punctuation
       //then assume it's not a regular expression, and extract
       //the entire line on which it was found
        String[] regexTokens = searchPattern.split("\\p{Punct}");

        if (regexTokens.length == 1)
        {
            searchPattern  = "^.*"+ searchPattern+".*?$";
        }

       Map retval = searchString(
          fileContent,searchPattern,
          Pattern.MULTILINE);

       return retval;
    }
    /**
    * Search down through the given directory, and finds
    * the specified Files, based the searchPattern, which describes
    * it's content. Returns matching Files in an ArrayList. This
    * methods searches reclusively through the file system.
    * @param the File currentFile the directory, or file, to start
    * searching in
    * @param the String fileExtension, if any, of the file
    * @param the String searchPattern, the regex that describes
    * what the file content we're looking for
    * @param the min flags we want to apply to the regex
    * pattern. -1 for no flags
    * @param searchSubDirectories true if sub directories should be
    * searched
    * @throws IOException if there's an IO problem
    *
    * @return ArrayList containing <code>File</code> objects,
    * or an empty ArrayList, if no matches are found
    */
    public static Collection searchDirs(
        File currentFile,
        String fileExtension,
        String searchPattern,
        int regexFlags,
        boolean searchSubDirectories
    ) throws IOException
    {

       Collection retval = searchDirs(
          currentFile,
          fileExtension,
          searchSubDirectories
       );

       //make sure the client actually wanted to search
       //inside the file
       if (searchPattern != null)
       {
          Iterator it = retval.iterator();

          while(it.hasNext())
          {
             File targetFile = (File)it.next();
             Map tmp = searchFile(
                targetFile.getPath(),
                searchPattern,regexFlags
                );

             if (tmp.size() ==0) it.remove();
          }
      }

       return retval;
    }

    /**
    * Search through the down the given directory, and finds
    * the specified Files, based the searchPattern, which describes
    * it's content. Returns matching Files in an ArrayList. This
    * methods searches reclusively through the file system.
    * @param the File currentFile the directory, or file, to start
    * searching in
    * @param the String filePattern describing the file
    * @throws IOException if there's an IO problem
    *
    * @return ArrayList containing <code>File</code> objects,
    * or an empty ArrayList, if no matches are found
    */
    public static Collection searchDirs(
        File currentFile,
        String filePattern,
        boolean searchSubDirectories) throws IOException

     {
       return searchDirs(currentFile,filePattern,searchSubDirectories, false);

     }

    public static Collection searchDirs(
        File currentFile,
        String filePattern,
        boolean searchSubDirectories,
        boolean isRegex
    ) throws IOException
    {

      HashSet retval = new HashSet();
      //step through sub directories
      File subs[]  =
       currentFile.listFiles(new LocalFileFilter(filePattern,isRegex));

       log.finest("current path " + currentFile.getAbsolutePath());
       log.finest("filePattern " + filePattern);
       //System.out.println("isRegex = :" + isRegex +":");
      if (subs != null)

      {
       //if the recursive search found anything, add it on
       for (int i=0; i < subs.length; i++)
       {
          log.finest("current sub path " + subs[i]);
          Collection tmp =null;
         if (subs[i].isDirectory() && searchSubDirectories == true)
         {
           tmp = searchDirs(subs[i],filePattern, searchSubDirectories);
           if (tmp.size() > 0) retval.addAll(tmp);
         }
         else if (!subs[i].isDirectory())
         {
           log.finest("adding FILE " + subs[i]);
           retval.add(subs[i]);
         }
      }
      }
      return retval;
     }


   /**
   *private filtering class, so that File searches can be more
   *efficient
   */
   private static class LocalFileFilter implements FileFilter{
       private String extention;
       boolean isRegex =false;
       LocalFileFilter()
       {
           this(null,false);
       }

       LocalFileFilter(String extention,boolean isRegex)
       {
           this.extention = extention;
           this.isRegex = isRegex;
       }

       /**
       * tells the client if the current file meets the criteria
       * @param the File pathname pattern to check for qualification
       *
       * @return true if the file has the extension, or a extension,
       * is null or the file is a directory. Else, returns false.
       */
       public boolean accept(File pathname){

         boolean retval = false;
         String fileName = pathname.getName();

         if (isRegex && fileName.matches(extention) )
         {
            retval =  true;
            log.finest("returning true for path " + pathname +" ext = " + extention);
         }
         else if (isRegex)
         {
            retval =  false;
         }
         if (extention == null) retval =  true;
         if (pathname.isDirectory() ) retval =  true;

         //never accept any compressed types
         if (
            /*fileName.endsWith(".jar")
            || fileName.endsWith(".zip")
            || */fileName.endsWith(".tar")
            || fileName.endsWith(".gzip")
            || fileName.endsWith(".gunzip")
         )  retval = false;

         log.finest("fileName CANDIDATE=:"+ fileName+":");
         log.finest("fileName EXTENTION =:"+extention+":" );

         if (retval) log.finest("fileName ACCEPTED=:"+ fileName+":");
         else log.finest("fileName REJECTED=:"+ fileName+":");
         return retval;
      }
   }

    /**
    * Searches the specified String, and returns substrings
    * that match the given pattern as an Map. The key to the map
    * is the position at which the element was found(as a String).
    * the value is the actual text. If there are no matches, an
    * empty Map is returned.
    * @param String string the String to search
    * @param  String searchPattern the pattern to apply in
    * the search
    * @param flags. The flags the client wants applied to this
    * pattern. A negative number means no flags.
    *
    * @return Map of found Strings. Empty if no matches
    * are found.
    */
    public static Map searchString(
        String content,
        String searchPattern,
        int flags
    )

    {
        Map retval = new LinkedHashMap();
        Pattern pattern = null;

        //compile the pattern
        if (flags > -1 )
        {
            pattern = Pattern.compile(searchPattern, flags);
        }
        else
        {
            pattern = Pattern.compile(searchPattern);
        }

        //extract the matcher for the pattern
        Matcher matcher = pattern.matcher(content);

        //iterate through all of the matches, and add
        //all relevent ones to the arrayList

        while (matcher.find())
        {
            //extract the match and it's position
            int position = matcher.start();
            String tmp = matcher.group();
            //insert the matching string and position
            //into the map.
            retval.put(position+"",tmp);
        }

        return retval;
    }


    /**
    * updates the content of the file. By default, the
    * Pattern.MULTILINE is used. Also supports the
    * $d notation in the replacement string, per the
    * Matcher.replaceAll method
    * @param the String fileName is the name and file path
    * @param the String regex pattern to look for
    * @param the String replacement for the regex
    * @throws IOException if there is an IO error
    *
    * @return boolean true if the file was updated
    */
    public static boolean updateFileContent
    (
        String fileName,
        String regex,
        String replacement
    ) throws IOException
    {
        boolean retval = false;

        RandomAccessFile raf =
            new RandomAccessFile(fileName,"rwd");
        FileChannel fc = raf.getChannel();

        String fileContent = getFileContent(fc);
        //Activiate the MULTILINE flag for this regex
        regex = "(?m)"+regex;

        String newFileContent =
            fileContent.replaceAll(regex,replacement);

        //if nothing changed, then don't update the file
        if (!newFileContent.equals(fileContent))
        {
           setFileContent(newFileContent,fc);
           retval = true;
        }

        //close up shop
        fc.close();
        fc = null;
        raf = null;

        return retval;
    }

    /**
    * sets the content of a file. Completely
    * overwrites previous file content, and truncates
    * file to the length of the new content.
    * @param the <code>String</code> newContent
    * @param the <code>FileChannel</code> fc
    * @throws <code>IOException</code>
    *
    * @author M Habibi
    */
    private static void setFileContent(
        String newContent, FileChannel fc
    )
    throws IOException{
        //write out the content to the file
        ByteBuffer bb = ByteBuffer.wrap(newContent.getBytes());
        //truncate the size of the file, in case the
        //original file content was longer the new
        //content
        fc.truncate(newContent.length());

        //start writing as position 0
        fc.position(0);
        fc.write(bb);

        fc.close();
        fc = null;
    }

    /**
    * extracts the content of a file
    * @param String fileName the name of the file to extract
    * @throws IOException
    *
    * @return String representing the contents of the file
    */
    public static String getFileContent(String fileName)
    throws IOException{
       log.finest(":"+fileName+":");
        String retval = null;

        //get access to the FileChannel
        FileInputStream fis =
          new FileInputStream(fileName);
        FileChannel fc = fis.getChannel();

        //get the file content
        retval = getFileContent(fc);
        //close up shop
        fc.close();
        fc = null;

        return retval;
    }
    /**
    * extracts the content of a file
    * @param FileChannel fc the file to extract from
    * @throws IOException
    *
    * @return String representing the contents of the file
    */
    private static String getFileContent(FileChannel fc)
    throws IOException{
        String retval = null;
       //read the contents of the FileChannel
        ByteBuffer bb = ByteBuffer.allocate((int)fc.size());
        fc.read(bb);

        //save the contents as a string
        bb.flip();
        retval = new String(bb.array());
        bb = null;

        return retval;
    }



    /**
    * general debug facility
    * @param the ArrayList al
    */
    private static void debug(Map map)
    {
      Iterator it = map.keySet().iterator();

      while (it.hasNext())
      {
          String pos = (String)it.next();
          String val = (String)map.get(pos);
          log.finest( val);
      }
    }

    /**
    * extracts the given property from the regex file
    * @param the String the regex file name(and path)
    * @param the String key to the property
    *
    * @return String the key, or null if the file is not found.
    * or if the key was empty.
    */
   public static String getProperty(String regexFile, String key)
   {
      String retval = null;
      //load the regex properties file
      RegexProperties rb = new RegexProperties();
      try
      {
        rb.load(regexFile);
        retval = rb.getProperty(key);
      }
      catch(Exception e)
      {
        e.printStackTrace();
        log.severe(e.getMessage() +"\n file =  "+ regexFile + " key = " + key);
      }

      return retval;
   }

    /**
    * Recusivly steps through the given directory to find the
    * specified file. returns null if the file is not found
    * @param the <code>File</code> dir to start searching in
    * @param the <code>String</code> fName the name of the file
    * we want.
    * @return <code>File</code> if found, or null
    *
    * @author M Habibi
    */
    public static File findSpecificFile(File dir, String fName)
    {
      File retval = new File(dir,fName);
      ArrayList al = new ArrayList();

      if (!retval.exists() )
      {
         retval = null;
         File[] subDirs = dir.listFiles();

         for (int i=0; i < subDirs.length; i++)
         {
            if (subDirs[i].isDirectory())
            {
               retval = findSpecificFile(subDirs[i],fName);
               if (retval != null && retval.exists()) break;
               else  retval = null;
            }
         }

      }
      return retval;
    }
}

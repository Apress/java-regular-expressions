import java.io.*;
import java.nio.*;
import java.nio.channels.*;

/**
* Provides an easy mechinism for extracting the regex contents
* of a file
*/
public class FileChannelExample{
    public static void main(String args[]) throws IOException{

        String targetFile = "FileChannelExample.java";

        //if the user passed in a file to read, then use
        //that file instead
        if (args != null && args.length ==1)
            targetFile = args[0];

        //getDataUsingFileChannel(targetFile);
        //getDataUsingInputStream(targetFile);
       getDataUsingMappedFileChannel(targetFile);

    }

    /**
    * Extracts data from a file by using FileChannels
    * @param targetFile the name and path of the file to read
    * @throws IOException if anything goes wrong
    */
    public static void getDataUsingFileChannel(String targetFile)
    throws IOException{
        //open a connection to the source code for this
        //class


        //measure how long this process takes,
        //so take the start time
        long startTime = System.currentTimeMillis();

        FileInputStream fis =
        new FileInputStream(targetFile);

        //get a file channel
        FileChannel fc = fis.getChannel();

        //create a ByteBuffer that is large enough
        //and read the contents of the file into it
        ByteBuffer bb = ByteBuffer.allocate((int)fc.size());

        fc.read(bb);

        //set the ByteBuffer's position it it's begining
        bb.flip();

        //save the content of the file as a String
        String  fileContent= new String(bb.array());

        //so take the end time
        long endTime = System.currentTimeMillis();

        long totalTime = (endTime - startTime);

        //release the FileChannel
            fc.close();
            fc = null;
            bb = null;

        //write out the contents of this file
        System.out.println("--getDataUsingFileChannel ");

        System.out.println("targetFile = " + targetFile);

        System.out.println("totalTime = " + totalTime);
    }

    /**
    * Extracts data from a file by using FileChannels
    * @param targetFile the name and path of the file to read
    * @throws IOException if anything goes wrong
    */
    public static void getDataUsingMappedFileChannel(String targetFile)
    throws IOException{
        //open a connection to the source code for this
        //class


        //measure how long this process takes,
        //so take the start time
        long startTime = System.currentTimeMillis();

        FileInputStream fis =
        new FileInputStream(targetFile);

        //get a file channel
        FileChannel fc = fis.getChannel();

        //map the byte buffer directly into memory
        fc.map(FileChannel.MapMode.READ_ONLY,0,(int)fc.size());

        //create a ByteBuffer that is large enough
        //and read the contents of the file into it
        ByteBuffer bb = ByteBuffer.allocate((int)fc.size());

        fc.read(bb);

        //set the ByteBuffer's position it it's begining
        bb.flip();

        //save the content of the file as a String
        String  fileContent= new String(bb.array());

        //so take the end time
        long endTime = System.currentTimeMillis();

        long totalTime = (endTime - startTime);

        //release the FileChannel
            fc.close();
            fc = null;

        //write out the contents of this file
        System.out.println("--getDataUsingMappedFileChannel ");

        System.out.println("targetFile = " + targetFile);

        System.out.println("totalTime = " + totalTime);
    }

    /**
    * Extracts data from a file by using an InputStream
    * @param targetFile the name and path of the file to read
    * @throws IOException if anything goes wrong
    */
    public static void getDataUsingInputStream(String targetFile)
    throws IOException{
        //open a connection to the source code for this
        //class

        //measure how long this process takes,
        //so take the start time
        long startTime = System.currentTimeMillis();

        File file = new File(targetFile);

        //get the size of the file
        int fileSize = (int)file.length();

        FileInputStream fis =
        new FileInputStream(file);

        //create a byte[] that is large enough
        //and read the contents of the file into it
        byte[] byteArray = new byte[fileSize];

        fis.read(byteArray);


        //save the content of the file as a String
        String  fileContent= new String(byteArray);

        //so take the end time
        long endTime = System.currentTimeMillis();

        long totalTime = (endTime - startTime);

        //release the file and stream
        fis.close();
        fis = null;
        file = null;

        //write out the contents of this file
        System.out.println("--getDataUsingInputStream");

        System.out.println("targetFile = " + targetFile);
        System.out.println("totalTime = " + totalTime);
    }
}

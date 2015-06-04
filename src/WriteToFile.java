/**
 * Created by tonytan on 4/6/15.
 * @author tonytan
 *
 * This writes to a file using try-with-resource and a postponed catch.
 */
import java.io.*;

public class WriteToFile {
    public int write(String filename, String text) throws IOException{
        try(PrintWriter fileOut = new PrintWriter(filename)){
            fileOut.println(text);
            return text.length();
        }
    }

    public static void main(String[] args){
        String filename = "Feyman.txt";
        String text = "It is fundamentally impossible to make"+
                "a precise predicton\n of exactly what will happen"+
                "in a given experiment";
        int length = 0;
        WriteToFile writer = new WriteToFile();

        try {
            length = writer.write(filename, text);
            System.out.println("written string length = "+ length);
        }
        catch (Exception e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        }
    }
}

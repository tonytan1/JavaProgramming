package FileBufferChannelPath;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by tonytan on 13/6/15.
 *
 * This reads strings through a buffer from a text file.
 */
public class BufferedReaderFromFile {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        String fileName;

        System.out.print("Enter filename: ");
        fileName = stdIn.nextLine();
        try (BufferedReader fileIn = Files.newBufferedReader(
                Paths.get(fileName),
                Charset.defaultCharset()
        )){
            while (fileIn.ready()){
                System.out.println(fileIn.readLine());
            }
        }
        catch (Exception e){
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
}

//

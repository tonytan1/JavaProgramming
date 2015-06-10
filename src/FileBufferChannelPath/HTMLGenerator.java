package FileBufferChannelPath;

/**
 * Created by tonytan on 10/6/15.
 *
 * This program copies the contents of a user-specified
 * file and pastes it into a newly generated HTML file.
 */

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.PipedWriter;
import java.nio.file.Path;

public class HTMLGenerator {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        String filenameIn;
        int dotIndex;
        String filenameOut;
        String line;

        System.out.print("Enter file's name: ");
        filenameIn = stdIn.nextLine();

        //compose the new filename
        dotIndex = filenameIn.lastIndexOf(".");//return the last position of string.
        if(dotIndex == -1){
            filenameOut = filenameIn + ".html";
        }
        else {
            filenameOut =
                    filenameIn.substring(0, dotIndex) + ".html";
        }

        try (
                Scanner fileIn = new Scanner(Paths.get(filenameIn));
                PrintWriter fileOut = new PrintWriter(filenameOut))
        {
            line = fileIn.nextLine();
            if (line == null){
                System.out.println(filenameIn + " is empty.");
            }
            else {
                //write the top of the HTML page
                fileOut.println("<!DOCTYPE html>");
                fileOut.println("<html>");
                fileOut.println("<head>");
                fileOut.println("<title>"+line+"</title>");
                fileOut.println("</head>");
                fileOut.println("body");
                fileOut.println("<h1>"+line+"</h1>");
            }
            while (fileIn.hasNextLine()){
                line = fileIn.nextLine();

                //blank lines generate p tags
                if(line.isEmpty()){
                    fileOut.println("<p>");
                }
                else {
                    fileOut.println(line);
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }

    }
}

package FileBufferChannelPath;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

/**
 * Created by tonytan on 16/6/15.
 *
 * This searches the directory tree for files matching a pattern.
 */
public class FindFiles {
    public static void main(String[] args){
        Path startDir;
        Scanner stdIn = new Scanner(System.in);
        String Pattern;
        FileVisitor visitor;

        System.out.println("Enter absolute path to starting directory: ");
        startDir = Paths.get(stdIn.nextLine());
        System.out.print("Enter filename search pattern: ");
        Pattern = stdIn.nextLine();

        visitor = new FileVisitor("glob:"+ Pattern);


        try {
            Files.walkFileTree(startDir, visitor);
        }
        catch (IOException e){
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
}

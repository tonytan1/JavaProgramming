package FileBufferChannelPath;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by tonytan on 16/6/15.
 *
 * This describes files in the current directory.
 */
public class DirectoryDescription {
    public static void main(String[] args){
        Path pathToDirectory = Paths.get(".");

        try (DirectoryStream<Path> paths =
                     Files.newDirectoryStream(pathToDirectory))
        {
            for(Path path: paths){
                System.out.printf("%-30s%6d bytes\n",
                        path.getFileName(), Files.size(path));
            }
        }
        catch (Exception e){
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
}

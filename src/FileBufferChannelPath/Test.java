package FileBufferChannelPath;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tonytan on 16/6/15.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("");
        System.out.println(path.toAbsolutePath());
        String regex = "^.+?\\.(?:(?:java)||(?:class))$";
        final Pattern pattern = Pattern.compile(regex);
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            public FileVisitResult visitFile(Path file,
                                             BasicFileAttributes attrs) throws IOException {
                String f = file.toString();
                Matcher m = pattern.matcher(f);
                if (m.matches()) {
                    System.out.println(f);
                }
                return FileVisitResult.CONTINUE;
            }
        });

    }
}

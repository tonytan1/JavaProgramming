package FileBufferChannelPath;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by tonytan on 16/6/15.
 *
 * This displays a glob filtered file in a file sysytem.
 */
public class FileVisitor extends SimpleFileVisitor<Path>{
    private PathMatcher matcher;
    private int tab = 0;

    public FileVisitor(String syntaxAndPattern){
        FileSystem system = FileSystems.getDefault();

        this.matcher = system.getPathMatcher(syntaxAndPattern);
    }//end constructor
}

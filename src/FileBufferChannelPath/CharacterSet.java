package FileBufferChannelPath;

/**
 * Created by tonytan on 12/6/15.
 */
import java.nio.charset.Charset;
import java.nio.file.StandardOpenOption;

public class CharacterSet {
    public static void main(String[] args){
        System.out.println(Charset.defaultCharset());

        for(String s: Charset.availableCharsets().keySet()){
            System.out.println("> "+ s);
        }

        for(StandardOpenOption opt : StandardOpenOption.values()){
            System.out.println(opt);
        }

    }
}

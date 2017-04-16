package DesignPattern.AdaptorPattern;

import java.io.IOException;

/**
 * Target
 * Created by tonytan on 11/4/2017.
 */
public interface FileIO {
    public void readFromFile(String filename) throws IOException;
    public void writeToFile(String filename) throws IOException;
    public void setValue(String key, String value) throws IOException;
    public String getValue(String key);

}

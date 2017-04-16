package DesignPattern.AdaptorPattern;

import java.io.*;
import java.util.Properties;

/**
 * Adaptor, java.util.Properties is adaptee.
 * Created by tonytan on 11/4/2017.
 */
public class FileProperties implements FileIO {

    Properties properties = new Properties();
    String header = "tony tan ";

    @Override
    public void readFromFile(String filename) throws IOException {
        InputStream is;
        try {
            is = new FileInputStream(filename);
            properties.load(is);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        OutputStream os;
        try {
            os = new FileOutputStream(filename);
            properties.store(os, header);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setValue(String key, String value) throws IOException {
        properties.setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return properties.get(key).toString();
    }
}

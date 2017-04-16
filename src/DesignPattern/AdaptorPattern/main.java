package DesignPattern.AdaptorPattern;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by tonytan on 11/4/2017.
 */
public class main {

    public static void main(String[] args){
        FileIO f = new FileProperties();
        try {
            f.setValue("test","test value");
            f.readFromFile("./input.txt");
            f.setValue("year", "2018");
            f.setValue("month", "jan");
            f.writeToFile("./output.txt");
            byte[] encoded = Files.readAllBytes(Paths.get("./output.txt"));
            System.out.print(new String(encoded, "UTF-8"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

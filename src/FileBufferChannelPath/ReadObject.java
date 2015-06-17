package FileBufferChannelPath;

/**
 * Created by tonytan on 12/6/15.
 *
 * this reads all objects in an onject file.
 */

import java.io.*;
import java.util.Scanner;

public class ReadObject {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        TestObject testObject;

        System.out.print("ENTER FILE NAME: ");
        try (ObjectInputStream fileIn = new ObjectInputStream(
                new FileInputStream(stdIn.nextLine())))
        {
            while (true){
                testObject = (TestObject) fileIn.readObject();
                testObject.display();
            }

        }
        catch (EOFException e){

        }//end-of-file exception terminate the infinite loop.
        catch (Exception e){
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
}

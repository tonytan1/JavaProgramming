package FileBufferChannelPath;

/**
 * Created by tonytan on 12/6/15.
 *
 * this writes two distinct objects to an object file.
 */
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;
import java.io.*;

public class WriteObject {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        TestObject testObject;

        System.out.print("Enter file name: ");
        try (ObjectOutputStream fileOut = new ObjectOutputStream(
                new FileOutputStream(stdIn.nextLine())))
        {
            testObject = new TestObject(1, "first", 1.0);
            fileOut.writeObject(testObject);
            //testObject = new TestObject(2, "second", 2.0);
            fileOut.reset();
            testObject.number *=1.1;
            fileOut.writeObject(testObject);
        }
        catch (Exception e){
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
}

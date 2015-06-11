package FileBufferChannelPath;

/**
 * Created by tony.tan on 6/11/2015.
 *
 * this reads a web page.
 */

import java.util.Scanner;
import java.net.*;
import java.io.InputStream;
//import org.htmlparser.Node;

public class WebPageReader {
    public static void main(String[] args){
        Scanner stdIn =  new Scanner(System.in);
        Scanner webIn;
        URL url;
        URLConnection connection;
        InputStream inStream;
        int i = 0, maxI;

        try{
            System.out.print("Enter a full URL address: ");
            url = new URL("http://"+ stdIn.nextLine());
            connection = url.openConnection();
            inStream = connection.getInputStream();
            webIn = new Scanner(inStream);
            System.out.print("Enter number of lines: ");
            maxI = stdIn.nextInt();
            while (i < maxI && webIn.hasNext()){
                System.out.println(webIn.nextLine());
                i++;
            }
        }
        catch (Exception e){
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
}

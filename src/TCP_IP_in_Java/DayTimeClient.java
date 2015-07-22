package TCP_IP_in_Java;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by tonytan on 5/7/15.
 *
 * use inputstream returned by getInputStream() to
 * read the time sent by the daytime server.
 */
public class DayTimeClient {
    public static void main(String[] args){
        String[] hostname = {"localhost"};

        for (int i=0; i<hostname.length; i++){
            try {
                Socket theSocket = new Socket(hostname[i], 2335);
                InputStream timeStream = theSocket.getInputStream();
                StringBuffer time = new StringBuffer();
                int c;
                while ((c=timeStream.read())!=-1) time.append((char)c);
                String timeString = time.toString().trim();
                System.out.println("It is "+timeString+" at "+hostname);
            }catch (UnknownHostException e){
                e.printStackTrace();
            }catch (IOException E){
                E.printStackTrace();
            }
        }
    }
}

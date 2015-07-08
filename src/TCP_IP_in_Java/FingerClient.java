package TCP_IP_in_Java;

import Concurrency.Writer;

import java.io.*;
import java.net.*;

/**
 * Created by tonytan on 6/7/15.
 */
public class FingerClient {
    public final static int DEFAULT_PORT = 79;

    public static void main(String[] args){
        String hostname = "cityu.edu.edu";

        Socket connection = null;
        try {
            connection = new Socket(hostname, DEFAULT_PORT);
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "8859_1");
            out.write(hostname);
            out.write("\r\n");
            out.flush();

            InputStream raw = connection.getInputStream();
            BufferedInputStream buffer = new BufferedInputStream(raw);
            InputStreamReader in = new InputStreamReader(buffer, "8859_1");

            int c;
            while ((c=in.read())!=-1){
                if ((c>32&&c<127)){
                    System.out.write(c);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (connection != null) connection.close();
            }catch (IOException e){
                //
            }
        }
    }
}

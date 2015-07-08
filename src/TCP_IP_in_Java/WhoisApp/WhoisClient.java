package TCP_IP_in_Java.WhoisApp;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by tonytan on 6/7/15.
 */
public class WhoisClient {
    public final static int DEFAULT_PORT = 43;
    public final static String DEFAULT_HOST = "whois.icann.org";

    public static void main(String[] args){
        String serverName = System.getProperty("WHOIS_SERVER", DEFAULT_HOST);

        InetAddress server = null;
        try {
            server = InetAddress.getByName(serverName);
        }catch (UnknownHostException e){
            e.printStackTrace();
            return;
        }

        try {
            Socket theSocket = new Socket(server, DEFAULT_PORT);
            OutputStreamWriter out = new OutputStreamWriter(theSocket.getOutputStream(),
                    "8859_1");
            out.write(DEFAULT_HOST);
            out.write("\r\n");
            InputStream raw = theSocket.getInputStream();
            InputStream in = new BufferedInputStream(theSocket.getInputStream());
            int c;
            while ((c=in.read())!=-1) System.out.write(c);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

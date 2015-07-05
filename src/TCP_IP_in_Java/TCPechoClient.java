package TCP_IP_in_Java;

/**
 * Created by tonytan on 4/7/15.
 *
 * An echo sever repeats whatever it receives back to the client.
 */

import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.SocketException;

public class TCPechoClient {
    public static void main(String[] args) throws IOException{

        if ((args.length)<2 || (args.length)>3){
            throw new IllegalArgumentException("Parameter(s): <sever><word>[<port>]");
        }

        String server = "169.1.1.1";//server name or IP address
        //convert input string to bytes using the default character encoding
        byte[] byteBuffer = args[1].getBytes();

        int servPort = (args.length == 3)? Integer.parseInt(args[2]): 7;

        //create socket that is connected too server on specified port
        Socket socket = new Socket(server, servPort);
        System.out.println("Connect to sever .... sending echo string");

        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();



        out.write(byteBuffer);//send the encode string to the sever.

        //receive the same string back form the sever
        int totalByteRcvd = 0;
        int byteRcvd;

        while (totalByteRcvd < byteBuffer.length){
            if ((byteRcvd = in.read(byteBuffer, totalByteRcvd,
                    byteBuffer.length-totalByteRcvd))==-1)
                throw new SocketException("Connection closed prematurely");
            totalByteRcvd += byteRcvd;
        }

        System.out.println("Received: "+ new String(byteBuffer));

        socket.close();
    }
}

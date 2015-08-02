package TCP_IP_in_Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Created by tonytan on 2/8/15.
 *
 *
 */
public class UDPDiscardClient {
    public final static int DEFAULT_PORT = 9;

    public static void main(String[] args){

        String hostname = "localhost";
        int port = DEFAULT_PORT;

        try {
            InetAddress server = InetAddress.getByName(hostname);
         // or   InetSocketAddress server = InetSocketAddress(hostname, port);

            BufferedReader userInput =
                    new BufferedReader(new InputStreamReader(System.in));
            DatagramSocket theSocket = new DatagramSocket();

            while (true){
                String theLine = userInput.readLine();
                if (theLine.equals(".")) break;
                byte[] data = theLine.getBytes();
                DatagramPacket theOutput =
                        new DatagramPacket(data, data.length, server, port);
            // or: new DatagramPacket(data, data.length, server);

                theSocket.send(theOutput);
            }
        }catch (SocketException e){
            System.err.println(e);
        }catch (IOException e){
            System.err.println(e);
        }

    }
}

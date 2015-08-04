package TCP_IP_in_Java.UDPServer;

import java.net.DatagramPacket;
import java.net.SocketException;

/**
 * Created by tonytan on 4/8/15.
 *
 * extend udpserver and discard the rcv msg directly.
 */
public class FastUDPDiscardServer extends UDPServer{
    public final static int DEFAULT_PORT = 9;

    public FastUDPDiscardServer() throws SocketException{
        super(DEFAULT_PORT);
    }

    public void respond(DatagramPacket packet){}

    public static void main(String[] args){
        try {
            FastUDPDiscardServer server = new FastUDPDiscardServer();
            Thread serverThread = new Thread(server);
            serverThread.start();
        }catch (SocketException e){
         e.printStackTrace();
        }
    }
}

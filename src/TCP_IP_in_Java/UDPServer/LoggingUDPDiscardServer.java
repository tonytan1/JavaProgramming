package TCP_IP_in_Java.UDPServer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by tonytan on 4/8/15.
 *
 * discard the msg and print log.
 */
public class LoggingUDPDiscardServer extends UDPServer{
    public final static int DEFAULT_PORT = 9999;

    public LoggingUDPDiscardServer() throws SocketException {
        super(DEFAULT_PORT);
    }

    public void respond(DatagramPacket packet){
        byte[] data = new byte[packet.getLength()];
        System.arraycopy(packet.getData(), 0, data, 0, packet.getLength());
        try {
            String s = new String(data, "ASCII");
            System.out.println(packet.getAddress()+" at port "
            + packet.getPort()+" says "+ s);
        }catch (java.io.UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }

    public void main(String[] args){
        try {
            LoggingUDPDiscardServer server = new LoggingUDPDiscardServer();
            Thread serverThread = new Thread(server);
            serverThread.start();
        }catch (SocketException e){
            e.printStackTrace();
        }
    }
}

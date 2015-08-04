package TCP_IP_in_Java.UDPServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.util.Date;

/**
 * Created by tonytan on 4/8/15.
 *
 * receive server time and send local time.
 */
public class UDPDaytimeServer extends UDPServer{

    public final static int DEFAULT_PORT = 13;

    public UDPDaytimeServer() throws SocketException{
        super(DEFAULT_PORT);
    }

    public void respond(DatagramPacket packet){

        try {
            Date now = new Date();
            String response = now.toString()+"\r\n";
            byte[] data = response.getBytes("ASCII");
            DatagramPacket outgoing = new DatagramPacket(data,
                    data.length, packet.getAddress(), packet.getPort());
            ds.send(outgoing);
        }catch (IOException e){
            System.err.println(e);
        }
    }

    public static void main(String[] args){
        try {
            UDPDaytimeServer server = new UDPDaytimeServer();
            Thread serverThread = new Thread(server);
            serverThread.start();
        }catch (SocketException e){
            System.err.println(e);
        }
    }
}

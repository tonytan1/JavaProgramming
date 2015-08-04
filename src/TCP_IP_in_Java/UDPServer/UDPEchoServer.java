package TCP_IP_in_Java.UDPServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.SocketException;

/**
 * Created by tonytan on 4/8/15.
 */
public class UDPEchoServer extends UDPServer{
    public final static int DEFAULT_PORT = 7;

    public UDPEchoServer() throws SocketException {
        super(DEFAULT_PORT);
    }

    public UDPEchoServer(int port) throws SocketException {
        super(port);
        ds.setReceiveBufferSize(32768);
    }

    public void respond(DatagramPacket incoming){

        try {
            DatagramPacket outgoing = new DatagramPacket(incoming.getData(),
                    incoming.getLength(), incoming.getAddress(), incoming.getPort());
            ds.send(outgoing);
            System.out.println(incoming.getLength());
        }catch (IOException e){
            System.err.println(e);
        }
    }

    public static void main(String[] args){
        try {
            UDPEchoServer server = new UDPEchoServer();
            Thread serverThread = new Thread(server);
            serverThread.start();
        }catch (SocketException e){
            System.err.println(e);
        }
    }
}

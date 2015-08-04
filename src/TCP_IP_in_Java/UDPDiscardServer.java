package TCP_IP_in_Java;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by tonytan on 2/8/15.
 *
 *
 */
public class UDPDiscardServer {
    public final static int DEFAULT_PORT = 9;
    public final static int MAX_PACKET_SIZE = 65507;

    public static void main(String[] args){
        int port = DEFAULT_PORT;
        byte[] buffer = new byte[MAX_PACKET_SIZE];

        try {
            DatagramSocket server = new DatagramSocket(port);
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            while (true){
                try {
                    server.receive(packet);//seems like accept() method in socket
                    String s = new String(packet.getData(), 0, packet.getLength());
                    System.out.println(packet.getAddress()+" at port "
                    + packet.getPort()+" says "+s);

                    //reset the length for the next packet
                    packet.setLength(buffer.length);
                }catch (IOException e){
                    System.err.println(e);
                }
            }
        }catch (SocketException se){
            System.out.println(se);
        }
    }
}

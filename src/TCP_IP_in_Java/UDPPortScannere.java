package TCP_IP_in_Java;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by tonytan on 2/8/15.
 *
 *
 */
public class UDPPortScannere {
    public static void main(String[] args){
        for (int port = 1024; port <=65535; port++){

            try {
                DatagramSocket server = new DatagramSocket(port);
                server.close();
            }catch (SocketException e){
                System.out.println("There is a server on port "+port);
            }
        }
    }
}

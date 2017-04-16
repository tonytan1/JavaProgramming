package TCP_IP_in_Java;

import java.net.*;

/**
 * Created by tonytan on 2/8/15.
 *
 */
public class DatagramExample {
    public static void main(String[] args){
        String s = "This is a test.";
        byte[] data = s.getBytes();

        try {
            InetAddress ia = InetAddress.getByName("metalab.unc.edu");
            int port = 7;

            DatagramPacket dp = new DatagramPacket(data, data.length,
                    new InetSocketAddress("metalab.unc.edu", 7));
            System.out.println("This package is addressed to "+
            dp.getAddress()+" on port "+dp.getPort());
            System.out.println("This package is addressed to "+
            dp.getSocketAddress());
            System.out.println("There are "+dp.getLength()+
            " bytes of data in the packet");
            System.out.println(new String(dp.getData(), dp.getOffset(), dp.getLength()));
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

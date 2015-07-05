package TCP_IP_in_Java;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by tonytan on 5/7/15.
 *
 * look for ports with socket closing.
 */
public class PortScanner {
    public static void main(String[] args){
        String host = "time.nist.gov";

        try {
            InetAddress theAddress = InetAddress.getByName(host);
            for (int i=1; i<65536; i++){
                Socket connection = null;
                try {
                    connection = new Socket(host, i);
                    System.out.println("There is a server on port "+
                            i+" of "+host);
                }catch (IOException e){
                    //e.printStackTrace();
                    System.out.println("unable to access");
                }finally {
                    try {
                        if (connection != null) connection.close();
                    }catch (IOException e){
                        //e.printStackTrace();
                        System.out.println("unable to access");
                    }
                }
            }
        }catch (UnknownHostException e){
            System.out.println("unable to access");
        }
    }
}

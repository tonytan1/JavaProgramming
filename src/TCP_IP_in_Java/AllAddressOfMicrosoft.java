package TCP_IP_in_Java;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by tonytan on 5/7/15.
 *
 * return a complete list of IP address for www.microsoft.com
 */
public class AllAddressOfMicrosoft {
    public static void main(String[] args){
        try {
            //InetAddress addresses = InetAddress.getLocalHost();
            InetAddress[] addresses =
                    InetAddress.getAllByName("www.microsoft.com");
            for (int i=0; i<addresses.length; i++){
            System.out.println(addresses[i]);//including IPv4 and hexadecimal IPv6 address.
            }
        }catch (UnknownHostException ex){
            System.out.println("cannot find microsoft.com");
        }
    }
}

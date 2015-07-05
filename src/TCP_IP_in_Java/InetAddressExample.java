package TCP_IP_in_Java;

/**
 * Created by tonytan on 4/7/15.
 *
 * a program to test socket address
 */

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {
    public static void main(String[] args){
        //get name and ip address of the local host
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.printf("LocalHost: %s %s",address.getHostName(), address.getHostAddress());
        }catch (UnknownHostException e){
            System.out.println("Unable to determine this host's address");
        }

        for (int i=0;i<args.length;i++){
            //get name/address of hosts given on command line
            try {
                InetAddress[] addressList = InetAddress.getAllByName(args[i]);
                System.out.printf(args[i]+": %s", addressList[0].getHostName());
                for (int j=0;j<addressList.length;j++){
                    System.out.printf(": %s", addressList[j].getHostName());
                }
            }catch (UnknownHostException e){
                System.out.println("Unable to determine this host's address");
            }
        }
    }
}

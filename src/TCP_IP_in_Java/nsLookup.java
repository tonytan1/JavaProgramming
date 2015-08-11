package TCP_IP_in_Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by tonytan on 10/8/15.
 *
 * find and print the host ip and hostname.
 */
public class nsLookup {

    public static void main(String[] args){

        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Enter name or IP address. Enter\"exit\" to quit.");

        try {
            while (true){
                String host = in.readLine();
                if (host.equals("exit")) break;
                System.out.println(lookup(host));
                System.out.println("Enter name or IP address. Enter\"exit\" to quit.");
            }
        }catch (IOException e){
            System.err.println(e);
        }
    }

    private static String lookup(String host){
        InetAddress thisComputer;
        byte[] address;

        //get byte of the IP address
        try {
            thisComputer = InetAddress.getByName(host);
            address = thisComputer.getAddress();
        }catch (UnknownHostException e){
            return "Cannot find host"+host;
        }

        if (isHostName(host)) {
            String dottedQuad="";
            for (int i=0; i<address.length;i++){
                int unsignedByte = address[i]<0? address[i]+256:address[i];
                dottedQuad += unsignedByte;
                if (i!=address.length-1) dottedQuad += ".";
            }
            return dottedQuad;
        }
        else{
            return thisComputer.getHostName();
        }
    }

    private static boolean isHostName(String host){
        char[] ca = host.toCharArray();
        for (int i=0; i<ca.length; i++){
            if (!Character.isDigit(ca[i])){
                if(ca[i] != '.') return true;
            }
        }
        return false;
    }
}

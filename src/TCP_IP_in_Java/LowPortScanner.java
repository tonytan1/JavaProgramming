package TCP_IP_in_Java;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by tonytan on 5/7/15.
 *
 * find out which of the first 1024 ports seem to be hosting TCP servers on a specified host.
 */
public class LowPortScanner {
    public static void main(String[] args){
        String host = "localhost";

        if (args.length  > 0){
            host = args[0];
        }

        for (int i=1; i<1024; i++){
            try {
                Socket s = new Socket(host,i);
                System.out.println("There is a server on port "+i+" of "+host);
            }catch (UnknownHostException e){
                System.err.println(e);
                break;
            }catch (IOException e){
                //MUST not a server on this port
            }
        }
    }
}

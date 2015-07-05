package TCP_IP_in_Java;

import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by tonytan on 5/7/15.
 *
 * read the hostname from command-line,
 * print the remote host, remote port, local host, local port.
 */
public class SocketInfo {
    public static void main(String[] args){
        //args[0] = "www.google.com";
        for (int i=0; i<args.length; i++){
            try {
                Socket theSocket = new Socket(args[i],80);
                System.out.println("connect to " + theSocket.getInetAddress()+
                " on port "+ theSocket.getPort() + " from port" +theSocket.getLocalPort()+
                " of "+ theSocket.getLocalAddress());
            }catch (UnknownHostException e){
                System.err.println("cannot find "+args[i]);
            }catch (IOException e){
                System.err.println(e);
            }

        }
    }
}

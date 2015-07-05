package TCP_IP_in_Java;

import sun.dc.pr.PRError;

import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * Created by tonytan on 5/7/15.
 *
 * send string to server, block on receive() for three seconds.
 * starting over(up to five times) if the reply is not received before the timeout.
 */
public class UDPEchoClientTimeout {
    private static final int TIMEOUT = 3000;//resend timeout(milliseconds)
    private static final int MAXRIES = 5;// max retransmissions

    public static void main(String[] args) throws IOException{
        System.out.println("Enter the server adress: ");
        Scanner stdIn = new Scanner(System.in);
        byte input = stdIn.nextByte();
        //InetAddress severAddress = InetAddress.getByAddress(input);

    }
}

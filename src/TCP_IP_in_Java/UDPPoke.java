package TCP_IP_in_Java;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;

/**
 * Created by tonytan on 4/8/15.
 */
public class UDPPoke {

    private int bufferSize;
    private DatagramSocket ds;
    private DatagramPacket outgoing;

    public UDPPoke(InetAddress host, int port, int bufferSize, int timeout)
    throws SocketException{
        outgoing = new DatagramPacket(new byte[1], 1, host, port);
        this.bufferSize = bufferSize;
        ds = new DatagramSocket(0);
        ds.connect(host, port);
        ds.setSoTimeout(timeout);
    }

    public UDPPoke(InetAddress host, int port, int bufferSize)
        throws SocketException{
        this(host, port, bufferSize, 30000);
    }

    public UDPPoke(InetAddress host, int port)
        throws SocketException{
        this(host, port, 8192, 30000);
    }

    public byte[] poke() throws IOException {
        byte[] response = null;
        try {
            ds.send(outgoing);
            DatagramPacket incoming =
                    new DatagramPacket(new byte[bufferSize], bufferSize);
            // next line blocks until the response is received
            ds.receive(incoming);
            int numBytes = incoming.getLength();
            response = new byte[numBytes];
            System.arraycopy(incoming.getData(), 0, response, 0, numBytes);
        }catch (IOException e){
            //
        }
        return response;
    }

    public static void main(String[] args){
        try {
            InetAddress host = InetAddress.getByName("nist1-lnk.binary.ne");
            int port = 13;

            UDPPoke poker = new UDPPoke(host, port);
            byte[] response = poker.poke();

            if (response == null){
                System.out.println("no response within allotted time");
                return;
            }
            String result = "";
            try {
                result = new String(response, "ASCII");
            }catch (UnsupportedEncodingException e){
                result = new String(response, "8859_1");
            }
            System.out.println(result);
        }catch (Exception e){
            System.err.println(e);
            e.printStackTrace();
        }

    }
}

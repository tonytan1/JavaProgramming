package TCP_IP_in_Java.UDPServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by tonytan on 4/8/15.
 */
public abstract class UDPServer implements Runnable{
    private int bufferSize;
    protected DatagramSocket ds;

    public UDPServer(int port, int bufferSize) throws SocketException{
        this.bufferSize = bufferSize;
        this.ds = new DatagramSocket(port);
    }

    public UDPServer(int port) throws SocketException{
        this(port, 8192);
    }

    @Override
    public void run() {
        byte[] buffer = new byte[bufferSize];
        while (true){
            DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
            try {
                ds.receive(incoming);
                this.respond(incoming);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public abstract void respond(DatagramPacket request);
}

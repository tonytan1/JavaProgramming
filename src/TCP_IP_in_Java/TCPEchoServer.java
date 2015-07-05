package TCP_IP_in_Java;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by tonytan on 4/7/15.
 *
 * sever run forever and repeated accepting a connection.
 */
public class TCPEchoServer {
    private static final int BUFSIZE = 32;//size of reveive buffer

    public static void main(String[] args) throws IOException {
        if (args.length != 1)
            throw new IllegalArgumentException("Parameters: <Port>");

        int servPort = Integer.parseInt(args[0]);

        //create a sever socket to accept client connection requests
        ServerSocket servSocket = new ServerSocket(servPort);

        int recvMsgSize;// size of received message
        byte[] byteBuffer = new byte[BUFSIZE];// receive buffer

        for (;;){// run forever, accepting and servicing connections.
            Socket clntSocket = servSocket.accept();//get client connection.

            System.out.println("Handling client at"+
            clntSocket.getInetAddress().getHostAddress()+" on port" +
            clntSocket.getPort());

            InputStream in = clntSocket.getInputStream();
            OutputStream out = clntSocket.getOutputStream();

            //receive until client closes connection, indicated by -1 return
            while ((recvMsgSize = in.read(byteBuffer)) != -1){
                out.write(byteBuffer, 0, recvMsgSize);
            }

            clntSocket.close();

        }
    }
}

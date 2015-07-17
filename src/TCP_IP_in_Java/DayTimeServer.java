package TCP_IP_in_Java;

import org.omg.PortableServer.POA;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by tonytan on 17/7/15.
 *
 * a daytime server using seversocket.
 */
public class DayTimeServer {
    public final static int DEFAULT_PORT = 2333;

    public static void main(String[] args){
        int port = DEFAULT_PORT;
        try {
            if (port>=65536){
                System.out.println("Port must between 0 and 65535");
            }
        }catch (NumberFormatException e){
            //use default port
        }

        try {
            ServerSocket sever = new ServerSocket(port);

            Socket connection = null;
            while (true){
                try {
                    connection = sever.accept();
                    OutputStreamWriter out = new OutputStreamWriter(
                            connection.getOutputStream());
                    Date now = new Date();
                    out.write(now.toString()+"\r\n");
                    out.flush();
                    connection.close();
                }catch (IOException e){
                    //
                }finally {
                    try {
                        if (connection != null) connection.close();
                    }catch (IOException e){
                        //
                    }
                }

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

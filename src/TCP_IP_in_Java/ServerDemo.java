package TCP_IP_in_Java;
import java.io.*;
import java.net.*;
/**
 * Created by tonytan on 5/7/15.
 */
public class ServerDemo {
        public static void main(String args[]) throws IOException {
            ServerSocket ss = new ServerSocket(12345);//端口号12345
            while(true) {
                Socket socket = ss.accept();
                OutputStream out = socket.getOutputStream();
                BufferedReader br = new BufferedReader(new FileReader("Feyman.txt"));
                out.write("HTTP/1.0 200 \n".getBytes());
                out.write("Content-Type: text/html\n".getBytes());
                out.write("\n".getBytes());
                out.flush();
                //socket.shutdownOutput();
                String line=null;
                while((line = br.readLine()) != null) {
                    out.write(line.getBytes());
                }
                socket.close();
                br.close();
                out.close();
            }
        }
}


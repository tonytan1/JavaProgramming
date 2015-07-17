package TCP_IP_in_Java;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by tonytan on 18/7/15.
 *
 * This program use two threads: one to handle input from the client
 * and the other to send output from the server.
 */
public class ClientTester {
    public static void main(String[] args){
        int port = 2335;

        try {
            ServerSocket server = new ServerSocket(port,1);
            System.out.println("Listening for connections on port"
            + server.getLocalPort());

            while (true){
                Socket connection = server.accept();
                try {
                    System.out.println("Connection established with" + connection);
                    Thread input = new InputThread(connection.getInputStream());
                    input.start();
                    Thread output = new OutputThread(connection.getOutputStream());
                    output.start();
                    try {
                        input.join();
                        output.join();
                    }catch (InterruptedException e){
                        System.out.println("Error in thread");
                    }
                }catch (IOException e){
                    System.err.println(e);
                }
            }
        }catch (IOException e){
            //
        }
    }

    static class InputThread extends Thread{
        InputStream in;

        public InputThread(InputStream in){
            this.in = in;
        }

        @Override
        public void run() {
            try {
                while (true){
                    int i = in.read();
                    if (i == -1) break;
                    System.out.write(i);
                }
            }catch (SocketException e){
                //
            }catch (IOException e){
                //
            }
            try {
                in.close();
            }catch (IOException e){
                //
            }
        }
    }

    static class OutputThread extends Thread{
        private OutputStreamWriter out;

        public OutputThread(OutputStream out){
            this.out = new OutputStreamWriter(out);
        }

        @Override
        public void run() {
            String line;

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(System.in));
            try {
                while (true){
                    line = in.readLine();
                    if (line.equals(".")) break;
                    out.write("HTTP/1.0 200 \n");
                    out.write("Content-Type: text/html\n");
                    out.write("\n");
                    out.write(line+"\r\n");
                    out.flush();
                }
            }catch (IOException e){
            }try {
                out.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

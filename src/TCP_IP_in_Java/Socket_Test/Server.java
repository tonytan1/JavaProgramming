package TCP_IP_in_Java.Socket_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by tony.tan on 7/23/2015.
 *
 * a simply server
 */
public class Server implements Runnable{
    private ServerSocket ss;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public Server() {
        try {
            ss = new ServerSocket(9998);
            while (true) {
                socket = ss.accept();
                String RemoteIP = socket.getInetAddress().getHostAddress();
                String RemmotePort = ":" + socket.getLocalPort();
                System.out.println("A client comes IP:" + RemoteIP + RemmotePort);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line = in.readLine();
                System.out.println("Client send is:" + line);
                out = new PrintWriter(socket.getOutputStream(), true);
                System.out.println("your msg received!");
                out.flush();
                out.close();
                socket.close();
            }
        } catch (IOException e) {
            System.err.print("wrong!");
        }
    }

    @Override
    public void run() {
        new Server();
    }

    public static void main(String[] args){

        Server server = new Server();
        Thread serverThread = new Thread(server);
        serverThread.start();

        Client client = new Client();
        Thread clientThread = new Thread(client);
        clientThread.start();
    }
}


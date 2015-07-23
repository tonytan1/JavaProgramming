package TCP_IP_in_Java.Socket_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by tony.tan on 7/23/2015.
 *
 * a simply client.
 */
public class Client implements Runnable {
    Socket socket;
    BufferedReader in;
    PrintWriter out;

    public Client(){
        try {
            System.out.println("Try to connect to localhost");
            socket = new Socket("192.168.1.195", 9999);
            System.out.print("The server connected!");
            System.out.print("Pls enter some characters!");
            BufferedReader line = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println(line.readLine());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(in.readLine());
            out.flush();
            out.close();
            in.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        new Client();
    }

    public static void main(String[] args){
        Client client = new Client();
        Thread clientThread = new Thread(client);
        clientThread.start();
    }
}

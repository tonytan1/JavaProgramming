package TCP_IP_in_Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by tonytan on 5/7/15.
 *
 * getOutputStream
 */
public class EchoClient {
    public static void main(String[] args){
        String hostname = "localhost";
        System.out.println("input your hostname: ");

        Scanner stdin = new Scanner(System.in);
        hostname = stdin.next();

        PrintWriter out = null;
        BufferedReader netWorkIn = null;
        try {
            Socket theSocket = new Socket(hostname, 7);
            netWorkIn = new BufferedReader(
                    new InputStreamReader(theSocket.getInputStream()));
            BufferedReader userIn = new BufferedReader(
                    new InputStreamReader(System.in));
            out = new PrintWriter(theSocket.getOutputStream());
            System.out.println("connect to server");

            while (true){
                String theLine = userIn.readLine();
                if (theLine.equals(".")) break;
                out.println(theLine);
                out.flush();//write to file of OS
                System.out.println(netWorkIn.readLine());
            }
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (netWorkIn != null) netWorkIn.close();
                if (out != null) out.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

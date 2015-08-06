package TCP_IP_in_Java.UDPServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Created by tonytan on 6/8/15.
 *
 *
 */


public  class UDPEchoClient {

    public static int DEFAULT_PORT = 7;

    public static void main(String[] args){

        String hostname = "localhost";
        int port = DEFAULT_PORT;

        try {
            InetAddress ia = InetAddress.getByName(hostname);
            SenderThread sender = new SenderThread(ia, DEFAULT_PORT);
            sender.start();
            ReceiveThread receiver =  new ReceiveThread(sender.getSocket());
            receiver.start();
        }catch (UnknownHostException e){
            System.err.println(e);
        }catch (SocketException e1){
            System.err.println(e1);
        }
    }

    static class SenderThread extends Thread{

        private InetAddress server;
        private DatagramSocket socket;
        private boolean stopped = false;
        private int port;

        public SenderThread(InetAddress ia, int port) throws SocketException{
            this.server = ia;
            this.socket = new DatagramSocket();
            this.port = port;
        }

        public void halt(){
            this.stopped = true;
        }

        public DatagramSocket getSocket(){
            return this.socket;
        }

        @Override
        public void run() {

            try {
                BufferedReader userInput =
                        new BufferedReader(new InputStreamReader(System.in));
                while(true){
                    if (stopped) return;
                    String theLine = userInput.readLine();
                    if (theLine.equals(".")) break;
                    byte data[] = theLine.getBytes();
                    DatagramPacket output =
                            new DatagramPacket(data, data.length, server, port);
                    socket.send(output);
                    Thread.yield();
                }
            }catch (IOException e){
                System.err.println(e);
            }
        }
    }

    static class ReceiveThread extends Thread{

        DatagramSocket socket;
        private boolean stopped = false;

        public ReceiveThread(DatagramSocket ds) throws SocketException{
            this.socket = ds;
        }

        public void halt(){
            this.stopped = true;
        }

        @Override
        public void run() {

            byte[] buffer = new byte[65507];
            while (true){
                if (stopped) return;
                DatagramPacket dp =
                        new DatagramPacket(buffer, buffer.length);
                try {
                    socket.receive(dp);
                    String s = new String(dp.getData(), 0, dp.getLength());
                    System.out.println(s);
                    Thread.yield();// free the CPU
                }catch (IOException e){
                    System.err.println(e);
                }
            }
        }
    }
}

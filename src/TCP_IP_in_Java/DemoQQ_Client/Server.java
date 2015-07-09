package TCP_IP_in_Java.DemoQQ_Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by tonytan on 9/7/15.
 */
public class Server {
    public static void main(String[] args){
        Server server = new Server();
    }

    public Server(){
        //interface initialization, multi-thread begin
        MyPanel myPanel;
        myPanel = new MyPanel();

        Thread t1 = new Thread(myPanel);
        t1.start();

        MyServer myServer = new MyServer();
        Thread t2 = new Thread(myServer);
        t2.start();

        MyServer_writer myServer_writer = new MyServer_writer();
        Thread t3 = new Thread(myServer_writer);
        t3.start();
    }

    //define the shared data
    class BaseServer{
         Socket socket;
         ServerSocket serverSocket;
         String sendMsg, receiveMsg;
    }

    class MyServer_writer extends BaseServer implements Runnable{
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                sendMsg();
                sendMsg = null;
            }
        }

        public void sendMsg(){
            if (sendMsg == null){
                //no action
            }
            try {
                // send data
                PrintWriter printWriter = new PrintWriter(
                        socket.getOutputStream(), true);
                printWriter.println(sendMsg);
                sendMsg = "Client :"+sendMsg+"\n";
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    class MyServer extends BaseServer implements Runnable{
        public MyServer(){
            try {
                receiveMsg = "Welcome to simplied QQ\n";
                serverSocket = new ServerSocket(9999);
                socket = serverSocket.accept();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        public void receiveMsg(){
            if (receiveMsg == null){
                //
            }
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(
                        socket.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                receiveMsg = "Client :"+bufferedReader.readLine()+"\n";
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                receiveMsg();
            }
        }
    }

    class MyPanel extends JFrame implements Runnable, ActionListener{
        //define parameter
        String sendMsg, receiveMsg;
        BaseServer baseServer = new BaseServer();

        JPanel panel;
        JTextArea textArea;
        JButton button;
        JTextField textField;
        JScrollPane scrollPane;

        public MyPanel(){
            panel = new JPanel();
            textArea = new JTextArea();
            button = new JButton("Send");
            textField = new JTextField();
            scrollPane = new JScrollPane(textArea);

            textField.setCaretColor(Color.RED);
            textField.setForeground(Color.red);

            textArea.setEditable(false);
            textArea.setVisible(true);

            button.setActionCommand("send");
            button.addActionListener(this);

            panel.setLayout(new GridLayout(2, 1));
            panel.add(textField);
            panel.add(button);

            this.setLayout(new GridLayout(2, 1));
            this.add(scrollPane);
            this.add(panel);

            this.setSize(400, 400);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("QQ Server");
            this.setVisible(true);

        }

        public void paint(Graphics g){
            super.paint(g);
        }

        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                sendMsg = this.textField.getText();
                receiveMsg = baseServer.receiveMsg;

                if (sendMsg == null){
                    continue;
                }
                if (baseServer.receiveMsg != null){
                    String strBoard = this.textArea.getText()+receiveMsg;
                    this.textArea.setText(strBoard);
                    baseServer.receiveMsg = null;
                }
                this.repaint();
            }
        }

        @Override
        public void actionPerformed(ActionEvent e){
            if (e.getActionCommand().equals("send")){
                baseServer.sendMsg = sendMsg;
                String strBoard = this.textArea.getText()+
                        "Client :"+sendMsg+"\n";

                this.textArea.setText(strBoard);
                textField.setText(null);
                this.repaint();
            }
        }
    }
}

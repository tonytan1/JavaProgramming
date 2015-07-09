package TCP_IP_in_Java.DemoQQ_Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by tonytan on 8/7/15.
 *
 * simply demo of QQ client.
 */
public class Client {
    public static void main(String[] args){
        Client client = new Client();
    }

    public Client(){
        // UI initialization, multi-thread for interface.
        MyPanel myPanel;
        myPanel = new MyPanel();

        Thread t1 = new Thread(myPanel);
        t1.start();

        //server receive info
        myClient mClient = new myClient();
        Thread t2 = new Thread(mClient);
        t2.start();

        //server sender
        Client_writer myClient_writer = new Client_writer();
        Thread t3 = new Thread(myClient_writer);
        t3.start();

        //thread for test
        /*MyTest mytest = new Mytest();
        Thread t4 = new Thread(mytest);
        t4.start();*/
    }
}

class BaseClient {
    // define parameters, make sure
    // the data sharing with sending and receiving.
    static Socket socket;
    static String sendMsg, receiveMsg;
}

class Client_writer extends BaseClient implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sendInfo();
            sendMsg = null;
        }
    }

    public void sendInfo() {
        if (sendMsg == null) {
            return;
        }
        try {
            //sending data
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            //acquire sending info
            pw.println(sendMsg);
            sendMsg = "Client :" + sendMsg + "\n";
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class myClient extends BaseClient implements Runnable {
    public myClient() {
        try {
            socket = new Socket("192.168.0.101", 9999);
            receiveMsg = "Welcome to Simplied QQ\n";
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getMsg() {
        try {
            InputStreamReader inReader = new InputStreamReader(socket.getInputStream());
            BufferedReader bf = new BufferedReader(inReader);
            receiveMsg = "Server :" + bf.readLine() + "\n";
        } catch (IOException e) {
            System.out.println("get info error!");
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            getMsg();
        }
    }
}

class MyPanel extends JFrame implements Runnable, ActionListener{
    //define parameter
    String sendMsg, receiveMsg;
    BaseClient baseClient = new BaseClient();
    //define sub-unit
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

        textField.setCaretColor(Color.green);//
        textField.setForeground(Color.green);// green font

        //message area is readable only
        textArea.setEditable(false);
        //add listener
        button.setActionCommand("send");
        button.addActionListener(this);

        //add sub-unit
        panel.setLayout(new GridLayout(2,1));
        panel.add(textField);
        panel.add(button);

        this.setLayout(new GridLayout(2, 1));
        this.add(scrollPane);
        this.add(panel);

        this.setSize(400, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("QQ Client");
    }

    @Override
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
            receiveMsg = baseClient.receiveMsg;

            if (sendMsg == null){
                continue;
            }
            if (baseClient.receiveMsg != null){
                String strBoard = this.textArea.getText() + receiveMsg;
                this.textArea.setText(strBoard);
                baseClient.receiveMsg = null;
            }
            this.repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand() == "send"){
            //send information
            baseClient.sendMsg = sendMsg; //refresh cache
            String strBoard = this.textArea + "Client :"+sendMsg+"\n";

            this.textArea.setText(strBoard);
            textField.setText(null);// clear
            this.repaint();
        }
    }
}


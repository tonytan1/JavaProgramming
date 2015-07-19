package TCP_IP_in_Java;

import org.omg.CORBA.TRANSACTION_MODE;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.UnrecoverableEntryException;

/**
 * Created by tonytan on 18/7/15.
 *
 * A server that always sends out the same file, no matter what the request.
 */
public class SingleFileHTTPServer extends Thread {
    private byte[] content;
    private byte[] header;
    private int port = 2336;

    public SingleFileHTTPServer(String data, String encoding, String MIMEType, int port)
            throws UnsupportedEncodingException {
        this(data.getBytes(encoding), encoding, MIMEType, port);
    }

    public SingleFileHTTPServer(byte[] data, String encoding, String MIMEType, int port)
            throws UnsupportedEncodingException {
        this.content = data;
        this.port = port;
        String header = "HTTP/1.0 200 OK\r\n"
                + "Server: oneFile 1.0\r\n"
                + "Content-length: " + this.content.length + "\r\n"
                + "Content-type: " + MIMEType + "\r\n\r\n";
        this.header = header.getBytes("ASCII");
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(this.port);
            System.out.println("Accepting connections on port" + server.getLocalPort());
            System.out.println("Data to be sent: ");
            System.out.write(this.content);

            while (true) {
                Socket connection = null;

                try {
                    connection = server.accept();
                    OutputStream out = new BufferedOutputStream(connection.getOutputStream());
                    InputStream in = new BufferedInputStream(connection.getInputStream());

                    //read first line only; that's all we need.
                    StringBuffer request = new StringBuffer(2336);
                    while (true) {
                        int c = in.read();
                        if (c == '\r' || c == '\n' || c == -1) break;
                        request.append((char) c);
                    }
                    //if this is HTTP/1.0 or later send a MIME header
                    if (request.toString().indexOf("HTTP/") != -1) {
                        out.write(this.header);
                    }
                    out.write(this.content);
                    out.flush();
                } catch (IOException e) {
                } finally {
                    if (connection != null) connection.close();
                }
            }
        } catch (IOException e) {
            System.err.println("cannot start server. Port Occupied");
        }
    }

    public static void main(String[] args){
        String contentType = "text/html";

        try {
            InputStream in = new FileInputStream("/Users/tonytan/Desktop/sina.html");
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            int b;
            while ((b = in.read()) != -1) out.write(b);
            byte[] data = out.toByteArray();

            //set the port to listen on
            int port = 2336;
            String encoding = "ASCII";
            try {
                Thread t = new SingleFileHTTPServer(data, encoding, contentType, port);
                t.start();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}


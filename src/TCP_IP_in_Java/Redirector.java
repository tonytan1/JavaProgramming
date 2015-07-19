package TCP_IP_in_Java;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.io.*;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by tonytan on 18/7/15.
 *
 * Read a url and port number, open a server socket on the port,
 * and redirects all requests that it receives to the site indicated
 * by the new URL using 302 FOUND code.
 */
public class Redirector implements Runnable{
    private int port;
    private String newSite;

    public Redirector(String site, int port){
        this.port = port;
        this.newSite = site;
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(this.port);
            System.out.println("Redirecting connections on port : "
            + server.getLocalPort() + " to "+newSite);

            while (true){
                try {
                    Socket s = server.accept();
                    Thread thread = new RedirectThread(s);
                    thread.start();
                }catch (IOException e){
                    //e.printStackTrace();
                }
            }
        }catch (BindException e){
            System.out.println("cannot start the server. PORT OCCUPIED");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    class RedirectThread extends Thread{
        private  Socket connection;

        RedirectThread(Socket s){
            this.connection = s;
        }

        @Override
        public void run() {
            try {
                Writer out = new BufferedWriter(
                        new OutputStreamWriter(
                                connection.getOutputStream(),"ASCII"));
                Reader in = new InputStreamReader(
                        new BufferedInputStream(
                                connection.getInputStream()));

                StringBuffer request = new StringBuffer(8180);
                while (true){
                    int c = in.read();
                    if (c=='\\'||c=='\n'||c ==-1) break;
                    request.append((char)c);
                }
                // if this is HTTP/1.O or later send a MIME header
                String get = request.toString();
                int firstSpace = get.indexOf(' ');
                int secondSpace = get.indexOf(' ', firstSpace+1);
                String theFile = get.substring(firstSpace+1, secondSpace);

                if (get.contains("HTTP")){
                    out.write("HTTP/1.0 302 FOUND\r\n");
                    Date now = new Date();
                    out.write("Date: "+now+"\r\n");
                    out.write("Server: Redirector 1.0\r\n");
                    out.write("Location: "+newSite+theFile+"\r\n");
                    out.write("Content-Type: text/html\r\n\r\n");
                    out.flush();
                }
                // not all browser support redirection so we need to
                // produce HTML that says where the doc has moved to.
                out.write("<HTML><HEAD><TITLE>Document Moved</TITLE></HEAD>\r\n");
                out.write("<BODY><H1>Document moved</H1>\r\n");
                out.write("The document"+theFile+"has moved to \r\n<A HREF=\""
                        +newSite+theFile+"</A>\r\nPlease update your bookmarks");
                out.write("</BODY></HTML>\r\n");
                out.flush();
            }catch (IOException e){}
            finally {
                try {
                    if (connection!=null) connection.close();
                }catch (IOException e){
                    //
                }
            }
        }
    }

    public static void main(String[] args){
        int thePort;
        String theSite;

        theSite = "www.baidu.com";
        thePort = 8180;

        Thread t = new Thread(new Redirector(theSite, thePort));
        t.start();
    }
}



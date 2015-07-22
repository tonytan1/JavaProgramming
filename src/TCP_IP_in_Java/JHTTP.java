package TCP_IP_in_Java;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by tonytan on 19/7/15.
 *
 *
 */
public class JHTTP extends Thread{
    private File documentRootDirectory;
    private String indexFileName = "index.html";
    private ServerSocket server;
    private int numThreads = 58;

    public JHTTP(File documentRootDirectory, int port,
                 String indexFileName) throws IOException{
        if (!documentRootDirectory.isDirectory()){
            throw new IOException(documentRootDirectory+
             "does not exist as a directory");
        }
        this.documentRootDirectory = documentRootDirectory;
        this.indexFileName = indexFileName;
        this.server = new ServerSocket(port);
    }

    public JHTTP(File documentRootDirectory, int port)
    throws IOException{
        this(documentRootDirectory, port, "index.html");
    }

    public JHTTP(File documentRootDirectory) throws IOException{
        this(documentRootDirectory, 2339, "index.html");
    }

    @Override
    public void run() {
        for (int i=0; i<numThreads;i++){
            Thread t = new Thread(
                 new RequestProcessor(documentRootDirectory,indexFileName));
            t.start();
        }
        System.out.println("Accepting connections on port"+
         server.getLocalPort());
        System.out.println("Document Root: " + documentRootDirectory);
        while (true){
            try {
                Socket request = server.accept();
                RequestProcessor.processRequest(request);
            }catch (IOException e){
            }
        }
    }

    public static void main(String[] args){
        //get the Document root
        File docroot;
        try {
            docroot = new File("/Users/tonytan/Desktop");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Usage: java JHTTP docroot port indexfile");
            return;
        }

        //set the port to listen on
        int port;
        try {
           //port = Integer.parseInt()
            port = 2339;
        }catch (Exception e){
            port = 2339;
        }

        try {
            JHTTP webserver = new JHTTP(docroot, port);
            webserver.start();
        }catch (IOException e){
            System.out.println("Server could not start bcz of an "
             + e.getClass());
            System.out.println(e);
        }
    }
}

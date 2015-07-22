package TCP_IP_in_Java;

import java.io.*;
import java.io.StreamTokenizer;
import java.net.Socket;
import java.util.Date;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by tonytan on 22/7/15.
 *
 *
 */
public class RequestProcessor implements Runnable{

    private static LinkedList pool = new LinkedList<>();
    private File documentRootDirectory;
    private String indexFileName = "index.html";

    public RequestProcessor(File documentRootDirectory,
                            String indexFileName){
        if (documentRootDirectory.isFile()){
            throw new IllegalArgumentException(
                    "documentRootDirectory must be a directory, not a file");
        }
        this.documentRootDirectory = documentRootDirectory;
        try {
            this.documentRootDirectory
                    = documentRootDirectory.getCanonicalFile();
        }catch (IOException e){
        }
        if (indexFileName != null) this.indexFileName = indexFileName;
    }

    public static void processRequest(Socket request){

        synchronized (pool){
            pool.add(pool.size(), request);
            pool.notifyAll();
        }
    }

    @Override
    public void run() {

        //for security checks
        String root = documentRootDirectory.getPath();

        while (true){
            Socket connection;
            synchronized (pool){
                while (pool.isEmpty()){
                    try {
                        pool.wait();
                    }catch (InterruptedException e){
                    }
                }
                connection = (Socket)pool.remove(0);
            }

            try {
                String filename;
                String contentType;
                OutputStream raw = new BufferedOutputStream(
                        connection.getOutputStream());
                Writer out = new OutputStreamWriter(raw);
                Reader in = new InputStreamReader(new BufferedInputStream(
                        connection.getInputStream()),"ASCII");
                StringBuffer requestLine = new StringBuffer();
                int c;
                while (true){
                    c = in.read();
                    if (c =='\r'||c=='\n') break;
                    requestLine.append((char)c);
                }

                String get = requestLine.toString();

                //log the request
                System.out.println(get);

                StringTokenizer st = new StringTokenizer(get);
                String method = st.nextToken();
                String version = "";
                if (method.equals("GET")){
                    filename = st.nextToken();
                    if (filename.endsWith("/")) filename+=indexFileName;
                    contentType = guessContentTypeFromName(filename);
                    if (st.hasMoreTokens()){
                        version = st.nextToken();
                    }

                    File theFile = new File(documentRootDirectory,
                            filename.substring(1,filename.length()));
                    if (theFile.canRead()
                            // don't let client outside the document root
                            && theFile.getCanonicalPath().startsWith(root)){
                        DataInputStream fis = new DataInputStream(
                                new BufferedInputStream(
                                        new FileInputStream(theFile)));
                        byte[] theData = new byte[(int)theFile.length()];
                        fis.readFully(theData);
                        fis.close();
                        if (version.startsWith("HTTP ")){
                            //send a MIME header
                            out.write("HTTP/1.0 200 OK\r\n");
                            Date now = new Date();
                            out.write("Date: "+now+"\r\n");
                            out.write("Server: JHTTP/1.0\r\n");
                            out.write("Content-length: "+theData.length+"\r\n");
                            out.write("Content-type: "+contentType+"\r\n\r\n");
                            out.flush();
                        }
                        // Send the file; it may be an image or other binary data;
                        // so use the underlying output stream
                        // instead of the writer.
                        raw.write(theData);
                        raw.flush();
                    }
                    else {
                        // cannot find the file
                        if (version.startsWith("HTTP ")){
                            //send a MIME header
                            out.write("HTTP/1.0 404 Not Found\r\n");
                            Date now = new Date();
                            out.write("Date: "+now+"\r\n");
                            out.write("Server: JHTTP/1.0\r\n");
                            out.write("Content-type: "+contentType+"\r\n\r\n");
                            out.flush();
                        }
                        out.write("<HTML>\r\n");
                        out.write("<HEAD><TITTLE>File Not Found</TITLE>\r\n");
                        out.write("</HEAD>\r\n");
                        out.write("<BODY>");
                        out.write("<H1>HTTP Error 404: FILE Not Found</H1>\r\n");
                        out.write("</BODY></HTML>\r\n");
                        out.flush();
                    }
                }
                else {
                    // method does not equal "GET"
                    if (version.startsWith("HTTP ")){
                        //send a MIME header
                        out.write("HTTP/1.0 501 Not Implemented\r\n");
                        Date now = new Date();
                        out.write("Date: "+now+"\r\n");
                        out.write("Server: JHTTP/1.0\r\n");
                        out.flush();
                    }
                    out.write("<HTML>\r\n");
                    out.write("<HEAD><TITTLE>501 Not Implemented</TITLE>\r\n");
                    out.write("</HEAD>\r\n");
                    out.write("<BODY>");
                    out.write("<H1>HTTP Error 501: Not Implemented</H1>\r\n");
                    out.write("</BODY></HTML>\r\n");
                    out.flush();
                }
            }catch (IOException e){
            }
            finally {
                try {
                    connection.close();
                }catch (IOException e){
                }
            }
        }
    }

    public static String guessContentTypeFromName(String name){
        if (name.endsWith(".html")||name.endsWith(".htm")){
            return "text/html";
        }
        else if (name.endsWith(".txt")||name.endsWith(".java")){
            return "text/plain";
        }
        else if (name.endsWith(".gif")){
            return "image/gif";
        }
        else if (name.endsWith(".class")){
            return "application/octet-stream";
        }
        else if (name.endsWith(".jpg")||name.endsWith(".jepg")){
            return "image/jpeg";
        }
        else return "text/plain";
    }


}

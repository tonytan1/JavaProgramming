package TCP_IP_in_Java.WhoisApp;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Locale;

/**
 * Created by tonytan on 6/7/15.
 */
public class Whois {
    public final static int DEFAULT_PORT = 43;
    public final static String DEFAULT_HOST = "whois.internic.net";

    private int port = DEFAULT_PORT;
    private InetAddress host;

    public Whois(InetAddress host, int port){
        this.port = port;
        this.host = host;
    }

    public Whois(InetAddress host){
        this.host = host;
    }

    public Whois(String hostname, int port) throws UnknownHostException{
        this(InetAddress.getByName(hostname));
    }

    public Whois(String hostname) throws  UnknownHostException{
        this(InetAddress.getByName(hostname),DEFAULT_PORT);
    }

    public Whois() throws UnknownHostException {
        this(DEFAULT_HOST, DEFAULT_PORT);
    }

    public static class SearchFor{

        public static SearchFor ANY = new SearchFor();
        public static SearchFor NETWORK = new SearchFor();
        public static SearchFor PERSON = new SearchFor();
        public static SearchFor HOST = new SearchFor();
        public static SearchFor DOMAIN = new SearchFor();
        public static SearchFor ORGANIZATION = new SearchFor();
        public static SearchFor GROUP = new SearchFor();
        public static SearchFor GATEWAY = new SearchFor();
        public static SearchFor ASN = new SearchFor();

        private SearchFor(){}
    }

    public static class SearchIn{
        public static SearchIn ALL = new SearchIn();
        public static SearchIn NAME = new SearchIn();
        public static SearchIn MAILBOX = new SearchIn();
        public static SearchIn HANDLE = new SearchIn();

        private SearchIn(){}

    }

    public String lookUpNames(String target, SearchFor category,
                              SearchIn group, boolean exactMatch) throws IOException{
        String suffix = "";
        if (!exactMatch) suffix = ".";

        String searchInLabel = "";
        String searchForLabel = "";

        if (group == SearchIn.ALL) searchInLabel = "";
        else if (group == SearchIn.NAME) searchInLabel = "Name ";
        else if (group == SearchIn.MAILBOX) searchInLabel = "Mailbox ";
        else if (group == SearchIn.HANDLE) searchInLabel = "!";

        if (category == SearchFor.ANY) searchForLabel = "";
        else if (category == SearchFor.NETWORK) searchForLabel = "Network ";
        else if (category ==SearchFor.PERSON) searchForLabel = "Person ";
        else if (category ==SearchFor.HOST) searchForLabel = "Host ";
        else if (category ==SearchFor.DOMAIN) searchForLabel = "Domain ";
        else if (category ==SearchFor.ORGANIZATION) searchForLabel = "Organization ";
        else if (category ==SearchFor.GROUP) searchForLabel = "Group ";
        else if (category ==SearchFor.GATEWAY) searchForLabel = "Gateway ";
        else if (category ==SearchFor.ASN) searchForLabel = "ASN ";

        String prefix = searchForLabel + searchInLabel;
        String query = prefix + target + suffix;

        Socket theSocket = new Socket(host, port);
        OutputStreamWriter out = new OutputStreamWriter(theSocket.getOutputStream(), "ASCII");
        BufferedReader in = new BufferedReader(new InputStreamReader(
                theSocket.getInputStream(),"ASCII"));
        out.write(query + "\r\n");
        out.flush();
        StringBuffer response = new StringBuffer();
        String theLine = null;
        while ((theLine = in.readLine())!=null){
            response.append(theLine);
            response.append("\r\n");
        }
        theSocket.close();

        return response.toString();
    }

    public InetAddress getHost(){
        return this.host;
    }

    public void setHost(String host) throws UnknownHostException{
        this.host = InetAddress.getByName(host);
    }
}

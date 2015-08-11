package TCP_IP_in_Java.Applet;

import java.applet.Applet;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by tonytan on 10/8/15.
 *
 *
 */
public class ProtocolTesterApplet extends Applet {

    TextArea results = new TextArea();

    @Override
    public void init() {
        this.setLayout(new BorderLayout());
        this.add("Center", results);
    }

    public void start(){

        String host = "www.peacefire.org";
        String file = "/Users/tonytan/Desktop/index.html";

        String[] schemes = {
                "http", "https", "ftp", "mailto",
                "telnet", "file", "ldap", "gopher",
                "jdbc", "rmi", "jndi", "jar",
                "doc", "netdoc", "nfs", "verbatim",
                "finger", "daytime", "systemresource"
        };

        for (int i=0; i<schemes.length; i++){
            try {
                URL u = new URL(schemes[i], host, file);
                results.append(schemes[i]+" is supported\r\n");
            }catch (MalformedURLException e){
                results.append(schemes[i]+" is not supported\r\n");
            }
        }
    }
}

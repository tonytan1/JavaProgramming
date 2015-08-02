package TCP_IP_in_Java;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.*;

/**
 * Created by tonytan on 2/8/15.
 *
 *
 */
public class SecureOrderTaker {
    public final static int DEFAULT_PORT = 7000;
    public final static String algorithm = "SSLv3";

    public static void main(String[] args){
        int port = DEFAULT_PORT;

        try {
            SSLContext context = SSLContext.getInstance("SSL");

            //the reference implementation only support X.509 keys
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");

            //Sun's default kind of key store
            KeyStore ks = KeyStore.getInstance("JKS");

            char[] password = "2andnotafnord".toCharArray();
            ks.load(new FileInputStream("jnp2e19.keys"), password);
            kmf.init(ks, password);

            context.init(kmf.getKeyManagers(), null, null);

            SSLServerSocketFactory factory = context.getServerSocketFactory();

            SSLServerSocket server = (SSLServerSocket)factory.createServerSocket(port);

            try {
                while (true){
                    Socket theConnection = server.accept();
                    InputStream in = theConnection.getInputStream();
                    int c;
                    while ((c=in.read())!=-1){
                        System.out.write(c);
                    }
                    theConnection.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        catch (KeyManagementException e){
            e.printStackTrace();
        }
        catch (KeyStoreException e){
            e.printStackTrace();
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        catch (UnrecoverableKeyException e){
            e.printStackTrace();
        }
        catch (java.security.cert.CertificateException e){
            e.printStackTrace();
        }
    }
}

package TCP_IP_in_Java;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

/**
 * Created by tonytan on 10/8/15.
 *
 *
 */
public class LookupThread extends Thread{

    private List entries;
    PooledWebLog log;

    public LookupThread(List entries, PooledWebLog log){
        this.entries = entries;
        this.log = log;
    }

    @Override
    public void run() {
        String entry;

        while (true){

            synchronized (entries){
                while (entries.size() == 0){
                    if (log.isFinished()) return;
                    try {
                        entries.wait();
                    }catch (InterruptedException e){
                        //
                    }
                }
                entry = (String) entries.remove(entries.size()-1);
            }

            int index = entry.indexOf(' ', 0);
            String remoteHost = entry.substring(0, index);
            String theRest = entry.substring(index, entry.length());

            try {
                remoteHost = InetAddress.getByName(remoteHost).getHostName();
            }catch (Exception e){
                //
            }
            try {
                log.log(remoteHost+theRest);
            }catch (IOException e){
                //
            }
            this.yield();
        }
    }
}

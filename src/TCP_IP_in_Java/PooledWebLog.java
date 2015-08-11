package TCP_IP_in_Java;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tonytan on 10/8/15.
 *
 *
 */
public class PooledWebLog {

    private BufferedReader in;
    private BufferedWriter out;
    private int numberOfThread;
    private List entries = Collections.synchronizedList(new LinkedList<Object>());
    private boolean finished = false;
    private int test = 0;

    public PooledWebLog(InputStream in, OutputStream out, int numberOfThread){
        this.in = new BufferedReader(new InputStreamReader(in));
        this.out = new BufferedWriter(new OutputStreamWriter(out));
        this.numberOfThread = numberOfThread;
    }

    public boolean isFinished(){
        return this.finished;
    }

    public int getNumberOfThread(){
        return numberOfThread;
    }

    public void processLogFile(){

        for (int i=0; i<numberOfThread; i++){
            Thread t = new LookupThread(entries, this);
            t.start();
        }

        try {
            String entry = null;
            while (entries.size() != numberOfThread){

                if (entries.size() > numberOfThread){
                    try {
                        Thread.sleep((long) (1000.0/numberOfThread));
                    }catch (InterruptedException e){
                        continue;
                    }
                }

                synchronized (entries){
                    entries.add(0, entry);
                    entries.notifyAll();
                }

                Thread.yield();
            }
        }catch (Exception e){
            System.out.println("Exception: "+e);
        }

        this.finished = true;

        synchronized (entries){
            entries.notifyAll();
        }
    }

    public void log(String entry) throws IOException {
        out.write(entry+System.getProperty("line.seperator", "\r\n"));
        out.flush();
    }

    public static void main(String[] args){

        try {
            PooledWebLog tw = new PooledWebLog(new FileInputStream(args[0]),
                    System.out, 100);
            tw.processLogFile();
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Usage: java PooledWeblog loggile_name");
        }catch (IOException e){
            System.err.println(e);
            e.printStackTrace();
        }
    }
}

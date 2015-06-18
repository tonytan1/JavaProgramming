package Concurrency;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by tony.tan on 6/18/2015.
 *
 * sleeping and resuming a thread.
 */
public class FileClock implements Runnable {
    @Override
    public void run() {
        for (int i=0; i<10; i++){
            System.out.printf("%s\n", new Date());
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            System.out.printf("The FileClock has been interrupted.");
        }
    }

    public static void main(String[] args){
        FileClock clock = new FileClock();
        Thread thread = new Thread(clock);
        thread.start();

        try{
            TimeUnit.SECONDS.sleep(5);
            System.out.println(new Date());
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        thread.interrupt();
    }

}

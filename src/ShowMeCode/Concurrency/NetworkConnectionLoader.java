package ShowMeCode.Concurrency;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by tony.tan on 6/18/2015.
 *
 * F
 */
public class NetworkConnectionLoader implements Runnable {
    @Override
    public void run() {
        System.out.printf("Beginning data sources loading: %s\n",
                new Date());
        try {
            TimeUnit.SECONDS.sleep(6);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.printf("Data source loading has been finished: %s\n", new Date());
    }

    public static void main(String[] args){
        DataSourceLoader dsLoader = new DataSourceLoader();
        Thread thread1 = new Thread(dsLoader, "DataSourceThread");

        NetworkConnectionLoader ncLoader = new NetworkConnectionLoader();
        Thread thread2 = new Thread(ncLoader, "NetworkConnectionLoader");

        thread1.start();
        thread2.start();

        try{
            thread1.join();// wait for the execution of thread1 finishing.
            thread2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.printf("Main: configuration has been loaded: " +
                "%s\n", new Date());
    }
}

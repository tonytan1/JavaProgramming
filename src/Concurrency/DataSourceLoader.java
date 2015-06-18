package Concurrency;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by tony.tan on 6/18/2015.
 *
 * Waiting for the finalization fo a thread.
 */
public class DataSourceLoader implements Runnable{
    @Override
    public void run() {
        System.out.printf("Beginning data sources loading: %s\n",
                new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.printf("Data source loading has been finished: %s\n", new Date());
    }
}

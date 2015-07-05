package Concurrency;

import java.util.concurrent.Semaphore;

/**
 * Created by tonytan on 24/6/15.
 */
public class PrintQueue1 {
    private final Semaphore semaphore;

    public PrintQueue1(){
        semaphore=new Semaphore(1, true);
    }

    public void printJob(Object document){
        try {
            semaphore.acquire();
            long duration = (long)(Math.random()*10);
            System.out.printf("%s: PrintQueue: Printing a Job during %d " +
                    "seconds\n", Thread.currentThread().getName(), duration);
            Thread.sleep(duration);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

}

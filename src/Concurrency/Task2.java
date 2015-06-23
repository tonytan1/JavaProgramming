package Concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by tonytan on 21/6/15.
 */
public class Task2 implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
        Task2 task = new Task2();
        
        Thread thread;
        System.out.printf("Starting the Threads\n");

        for (int i=0; i<10; i++){
            thread = factory.newThread(task);
            thread.start();
        }

        System.out.printf("Factory status:\n");
        System.out.printf("%s\n", factory.getStats());
    }
}

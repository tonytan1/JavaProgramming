package Concurrency;

import java.util.Random;

/**
 * Created by tonytan on 20/6/15.
 */
public class Task1 implements Runnable {
    @Override
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());
        while (true) {
            result = 1000 / (int) (random.nextDouble() * 1000);
            System.out.printf("%s : %d\n",
                    Thread.currentThread().getId(), result);
            if (Thread.currentThread().isInterrupted()) {
                System.out.printf("%d : Interrupted\n",
                        Thread.currentThread().getId());
                return;
            }
        }
    }

    public static void main(String[] args){
        MyThreadGroup threadGroup = new MyThreadGroup("");
        Task1 task1 = new Task1();

        for (int i=0; i<2; i++){
            Thread t = new Thread(threadGroup, task1);
            t.start();
        }
    }
}

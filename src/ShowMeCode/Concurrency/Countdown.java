package ShowMeCode.Concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * Created by tonytan on 16/10/2016.
 */
public class Countdown {
    static final CountDownLatch latch = new CountDownLatch(2);

    public static void main(String[] args){

        for(int i=0; i<3;i++){
            new Thread(){
                public void run() {
                    try {
                        System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                        Thread.sleep(3000);
                        System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                        latch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }


        try {
            System.out.println("等待2个子线程执行完毕...");
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

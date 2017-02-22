package Concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by tonytan on 16/10/2016.
 */
public class Cyclicbarrier {

    static final int N = 4;


    public static void main(String[] args) {
        CyclicBarrier barrier  = new CyclicBarrier(N);

        for(int i=0;i<N;i++) {
            new Writer(barrier).start();
        }

        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("CyclicBarrier重用");

        for(int i=0;i<N-1;i++) {
            new Writer(barrier).start();
        }
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            System.out.print("time out error");
        }
        new Writer(barrier).start();

    }

    static class Writer extends Thread{
        private CyclicBarrier cyclicBarrier;
        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");
            try {
                Thread.sleep(5000);      //以睡眠来模拟写入数据操作
                System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");

                cyclicBarrier.await(2000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch(BrokenBarrierException e){
                e.printStackTrace();
            }catch (TimeoutException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"所有线程写入完毕，继续处理其他任务...");
        }
    }
}

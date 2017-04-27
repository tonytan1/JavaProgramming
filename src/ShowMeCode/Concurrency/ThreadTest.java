package ShowMeCode.Concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tony.tan on 7/23/2015.
 *
 * http://tntxia.iteye.com/blog/545989
 * http://www.journaldev.com/1095/java-atomic-operations-atomicinteger-example
 *
 * among four thread, two thread do j++, the other do j--.
 * it is also considered that the atomic operation: int getAndAdd(int delta)
 * and int getAndDecrement(int delta).
 */
public class ThreadTest {
    //private int j;
    AtomicInteger j = new AtomicInteger();

    public static void main(String[] args){
        ThreadTest thread = new ThreadTest();
        Inc inc = thread.new Inc();
        Dec dec = thread.new Dec();

        for (int i=0; i<2; i++){
            Thread t = new Thread(inc);
            t.start();
            t = new Thread(dec);
            t.start();
        }
    }

    class Inc implements Runnable{
        private void inc(){
            j.getAndAdd(1);
            System.out.println(
                    Thread.currentThread().getName()+"-inc: "+j);
        }

        @Override
        public void run() {//synchronized j++
            for (int i=0; i<100; i++){
                inc();
            }
        }
    }

    class Dec implements Runnable{
        private void dec(){//synchronized j--
            j.getAndDecrement();
            System.out.println(
                    Thread.currentThread().getName()+"-dec: "+j);
        }

        @Override
        public void run() {
            for (int i=0;i<100;i++){
                dec();
            }
        }
    }
}



package Concurrency;

/**
 * Created by tony.tan on 7/23/2015.
 * http://tntxia.iteye.com/blog/545989
 * among four thread, two thread do j++, the other do j--.
 */
public class ThreadTest {
    private int j;

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
        private synchronized void inc(){
            j++;
            System.out.println(
                    Thread.currentThread().getName()+"-inc: "+j);
        }

        @Override
        public void run() {
            for (int i=0; i<100; i++){
                inc();
            }
        }
    }

    class Dec implements Runnable{
        private synchronized void dec(){
            j--;
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



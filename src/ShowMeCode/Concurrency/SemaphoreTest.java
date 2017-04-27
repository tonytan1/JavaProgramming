package ShowMeCode.Concurrency;

import java.util.concurrent.Semaphore;

/**
 * Created by tonytan on 16/10/2016.
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        int N = 20;            //工人数
        Semaphore semaphore = new Semaphore(5); //机器数目
        for(int i=0;i<N;i++)
            new Worker(i,semaphore).start();
    }

    static class Worker extends Thread{
        private int num;
        private Semaphore semaphore;
        public Worker(int num,Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
//                System.out.println("还有"+ semaphore.availablePermits()+"机器可用...");

//                if (semaphore.tryAcquire(3000, TimeUnit.MILLISECONDS)){
                    semaphore.acquire();
                    System.out.println("工人"+this.num+"占用一个机器在生产...");
                    Thread.sleep(10000);
                    System.out.println("工人"+this.num+"释放出机器");
                    semaphore.release();
//                }else {
//                    System.out.println("工人" + this.num + "获取机器失败");
//                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

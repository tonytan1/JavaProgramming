package Concurrency;

import java.util.Random;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by tony.tan on 6/24/2015.
 */
public class Consumer1 implements Runnable{
    private Buffer buffer;

    public Consumer1 (Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (buffer.hasPendingLines()){
            String line = buffer.get();
            processLine(line);
        }
    }

    private void processLine(String line){
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(100));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        FileMock mock = new FileMock(100, 10);
        Buffer buffer = new Buffer(20);

        Producer1 producer = new Producer1(mock, buffer);
        Thread threadProducer = new Thread(producer, "producer");

        Consumer1 consumers[] = new Consumer1[3];
        Thread threadConsumers[] = new Thread[3];

        for (int i=0; i<3; i++){
            consumers[i] = new Consumer1(buffer);
            threadConsumers[i]=new Thread(consumers[i], "Consumer "+i);
        }

        threadProducer.start();
        for (int i=0; i<3; i++){
            threadConsumers[i].start();
        }
    }
}

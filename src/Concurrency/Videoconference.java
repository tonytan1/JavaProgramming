package Concurrency;

import sun.jvm.hotspot.debugger.ThreadContext;

import java.util.concurrent.CountDownLatch;

/**
 * Created by tonytan on 28/6/15.
 *
 * Implement the video-conference system.
 */
public class Videoconference implements Runnable {
    private final CountDownLatch controller;

    public Videoconference(int number){
        controller = new CountDownLatch(number);
    }

    public void arrive(String name){
        System.out.printf("%s has arrived\n", name);
        controller.countDown();
        System.out.printf("VideoConference: Waiting for %d participants.\n",
                controller.getCount());
    }

    @Override
    public void run() {
        System.out.printf("VideoConference: Initialization: %d participants.\n",
                controller.getCount());

        try {
            controller.await();
            System.out.printf("VideoConference: All the participants have come\n");
            System.out.printf("VideoConference: Let's start...\n");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}

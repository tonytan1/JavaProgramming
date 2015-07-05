package Concurrency;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by tonytan on 28/6/15.
 */
public class Participant implements Runnable {
    private Videoconference conference;
    private String name;

    public Participant(Videoconference conference, String name){
        this.conference = conference;
        this.name = name;
    }

    @Override
    public void run() {
        long duration=(long)(Math.random()*10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        conference.arrive(name);// use arrive to count down
    }


    public static void main(String[] args){
        Videoconference conference = new Videoconference(10);
        Thread threadConference = new Thread(conference);
        threadConference.start();

        for (int i=0; i<10; i++){
            Participant p = new Participant(conference, "Participant"+i);
            Thread t = new Thread(p);
            t.start();
        }
    }
}

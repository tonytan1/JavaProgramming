package ShowMeCode.Concurrency;

/**
 * Created by tonytan on 23/6/15.
 */
public class Producer implements Runnable {
    private EventStorage storage;

    public Producer(EventStorage storage){
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i=0; i<100; i++){
            storage.set();
        }
    }
}

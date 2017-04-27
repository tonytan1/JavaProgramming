package ShowMeCode.Concurrency;

/**
 * Created by tonytan on 24/6/15.
 */
public class Writer implements Runnable {
    private PriceInfo priceInfo;

    public Writer(PriceInfo priceInfo){
        this.priceInfo = priceInfo;
    }

    @Override
    public void run() {
        for (int i=0; i<3; i++){
            System.out.printf("Writer: Attempt to modify the price.\n");
            priceInfo.setPrice(Math.random() * 10, Math.random() * 8);
            System.out.printf("Writer: Prices have been modified.\n");
            try {
                Thread.sleep(2);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        PriceInfo priceInfo = new PriceInfo();

        Reader reader[] = new Reader[5];
        Thread threadReader[] = new Thread[5];

        for (int i=0; i<5; i++){
            reader[i] = new Reader(priceInfo);
            threadReader[i]=new Thread(reader[i]);
        }

        Writer writer = new Writer(priceInfo);
        Thread threadWriter = new Thread(writer);

        for (int i=0; i<5; i++){
            threadReader[i].start();
        }
        threadWriter.start();
    }
}

package DesignPattern.Singleton;

/**
 * singleton
 * Created by tonytan on 17/4/2017.
 */
public class TicketMaker {
    private static int ticketNum = 1000;
    private static TicketMaker instance = new TicketMaker();
    private TicketMaker(){};

    public TicketMaker getInstance(){
        return instance;
    }
    public static synchronized int getNextTicketNum(){
        return ticketNum++;
    }
}

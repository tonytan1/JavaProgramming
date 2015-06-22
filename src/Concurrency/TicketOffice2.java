package Concurrency;

/**
 * Created by tonytan on 22/6/15.
 *
 * In this example, we have an object that controls access
 * to the vacanciesCinema1 attribute, so only one thread can
 * modify this attribute each time, and another object controls
 * access to the vacanciesCinema2 attribute, so only one thread
 * can modify this attribute each time.
 * But there may be two threads running simultaneously,
 * one modifying the vacancesCinema1 attribute and the other one
 * modifying the vacanciesCinema2 attribute.
 *
 *
 *
 */
public class TicketOffice2 implements Runnable {
    private Cinema cinema;

    public TicketOffice2(Cinema cinema){
        this.cinema = cinema;
    }

    @Override
    public void run() {
        cinema.sellTickets1(3);
        cinema.sellTickets1(2);
        cinema.sellTickets2(2);
        cinema.returnTickets1(3);
        cinema.sellTickets1(5);
        cinema.sellTickets2(2);
        cinema.sellTickets2(2);
        cinema.sellTickets2(2);
    }

    public static void main(String[] args){
        Cinema cinema = new Cinema();

        TicketOffice1 ticketOffice1 = new TicketOffice1(cinema);
        Thread thread1 = new Thread(ticketOffice1, "TicketOffice1");

        TicketOffice2 ticketOffice2 = new TicketOffice2(cinema);
        Thread thread2 = new Thread(ticketOffice2, "TicketOffice2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.printf("Room1 Vacancies: %d\n",cinema.getVacanciesCinema1());
        System.out.printf("Room2 Vacancies: %d\n", cinema.getVacanciesCinema2());
    }
}

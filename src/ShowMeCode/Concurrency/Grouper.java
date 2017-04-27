package ShowMeCode.Concurrency;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by tonytan on 28/6/15.
 */
public class Grouper implements Runnable {
    private Results results;

    public Grouper(Results results){
        this.results = results;
    }

    @Override
    public void run() {
        int finalResult = 0 ;
        System.out.printf("Grouper: Processing results....\n");

        int data[] = results.getData();
        for (int number:data){
            finalResult += number;
        }
        System.out.printf("Grouper: total result: %d.\n", finalResult);
    }

    public static void main(String[] args){
        final int ROWS = 10000;
        final int NUMBERS=1000;
        final int SEARCH=5;
        final int PARTICIPANTS=5;
        final int LINES_PARTICIPANT=2000;

        MatrixMock mock = new MatrixMock(ROWS, NUMBERS,SEARCH);
        Results results = new Results(ROWS);
        Grouper grouper = new Grouper(results);
        CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS,grouper);

        Searcher searchers[] = new Searcher[PARTICIPANTS];
        for (int i=0; i<PARTICIPANTS; i++){
            searchers[i]=new Searcher(i*LINES_PARTICIPANT,
                    (i*LINES_PARTICIPANT)+LINES_PARTICIPANT, mock, results, 5, barrier);
            Thread thread = new Thread(searchers[i]);
            thread.start();
        }
        System.out.printf("The main thread has finished\n");
    }

}

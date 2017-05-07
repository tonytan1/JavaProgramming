package DesignPattern.StrategyPattern;

/**
 * Created by tonytan on 7/5/2017.
 */
public class Maintest {
    public static void main(String[] args){
        int seed1 = 0;
        int seed2 = 1;

        Player player1 = new Player("TT", new WinningStrategy(seed1));
        Player player2 = new Player("ww", new ProbStrategy(seed2));

        for (int i = 0; i < 100; i++) {
            Hand nextHand1 = player1.nextHand();
            Hand nextHand2 = player2.nextHand();
            if (nextHand1.isStrongThan(nextHand2)){
                System.out.println("Winner: " + player1.name);
                player1.win();
                player2.lose();
            } else if (nextHand2.isStrongThan(nextHand1)){
                System.out.println("Winner: " + player2.name);
                player2.win();
                player1.lose();
            } else {
                System.out.println("EVEN ...." );
                player1.even();
                player2.even();
            }
        }

        System.out.println("Total result: ");
        System.out.println(player1.toString());
        System.out.println(player2.toString());
    }
}

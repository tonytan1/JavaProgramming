package DesignPattern.StrategyPattern;

import java.util.Random;

/**
 * If win, then same hand; If fail, change hand randomly.
 * Created by tonytan on 7/5/2017.
 */
public class WinningStrategy implements Strategy{
    private Random random;
    private boolean won = false;
    private Hand prevHand;

    public WinningStrategy(int seed){
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        if (!won) {
            prevHand = Hand.getHand(random.nextInt(3));
        }
        return prevHand;
    }

    @Override
    public void study(boolean win) {
        won = win;
    }
}

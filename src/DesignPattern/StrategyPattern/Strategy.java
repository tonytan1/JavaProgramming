package DesignPattern.StrategyPattern;

/**
 * strategy interface
 * Created by tonytan on 7/5/2017.
 */
public interface Strategy {
    public abstract Hand nextHand();
    public abstract void study(boolean win);
}

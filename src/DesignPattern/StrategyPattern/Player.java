package DesignPattern.StrategyPattern;

/**
 *  player that use strategy to play game.
 *  Created by tonytan on 7/5/2017.
 */
public class Player {
    public String name;
    private Strategy strategy;
    private int wincount;
    private int losecount;
    private int gamecount;

    public Player(String name, Strategy strategy){
        this.name = name;
        this.strategy = strategy;
    }

    public Hand nextHand(){
        return strategy.nextHand();
    }

    public void win(){
        strategy.study(true);
        wincount++;
        gamecount++;
    }

    public void lose(){
        strategy.study(false);
        gamecount++;
    }

    public void even(){
        gamecount++;
    }
}

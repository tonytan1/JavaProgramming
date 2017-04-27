package DesignPattern.BridgePattern;

import java.util.Random;

/**
 * Created by tonytan on 25/4/2017.
 */
public class StarDisplayImpl extends DisplayImpl {
    private String star;

    public StarDisplayImpl(String star) {
        this.star = star;
    }

    @Override
    public void rawOpen() {
    }

    @Override
    public void rawPrint() {
        printLine(star);
    }

    @Override
    public void rawClose() {

    }

    private void printLine(String star){
        Random random = new Random();
        for (int i = 0; i < random.nextInt(10); i++) {
            System.out.print("|");
            for (int j = 0; j < i; j++) {
                System.out.print(star);
            }
            System.out.println("-");
        }
    }
}

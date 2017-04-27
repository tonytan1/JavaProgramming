package DesignPattern.BridgePattern;

import java.util.Random;

/**
 * Created by tonytan on 25/4/2017.
 */
public class RandomDisplay extends Display {
    public RandomDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void multiDisplay(){
        open();
        Random random = new Random();
        for (int i = 0; i <  random.nextInt(5); i++) {
            print();
        }
        close();
    }
}

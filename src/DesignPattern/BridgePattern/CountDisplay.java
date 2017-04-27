package DesignPattern.BridgePattern;

/**
 * Created by tonytan on 25/4/2017.
 */
public class CountDisplay extends Display{
    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void multiDisplay(int times){
        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}

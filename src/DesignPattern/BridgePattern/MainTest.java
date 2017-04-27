package DesignPattern.BridgePattern;

/**
 * Created by tonytan on 25/4/2017.
 */
public class MainTest {
    public static void main(String[] args){
        Display d1 = new Display(new StringDisplayImpl("hello, world."));
        CountDisplay d2 = new CountDisplay(new StringDisplayImpl("hello, china."));
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("hello, taiwan."));
        RandomDisplay d4 = new RandomDisplay(new StringDisplayImpl("hello, taiwan"));

        Display d5 = new Display(new StarDisplayImpl("*"));
        d5.display();

        d1.display();
        d2.display();
        d3.display();
        d2.multiDisplay(5);
        d4.multiDisplay();
    }
}

package DesignPattern.AbstractFactory;

import java.util.ArrayList;

/**
 *
 * Created by tonytan on 20/4/2017.
 */
public abstract class Tray extends Item {
    protected ArrayList tray = new ArrayList();
    public Tray(String caption){
        super(caption);
    }

    public void add(Item item) {
        tray.add(item);
    }

}

package DesignPattern.BridgePattern;

/**
 * Created by tonytan on 25/4/2017.
 */
public class Display {
    private DisplayImpl impl;
    public Display(DisplayImpl impl) {//Delegation pattern
        this.impl = impl;
    }

    public void open(){
        impl.rawOpen();
    }

    public void print(){
        impl.rawPrint();
    }

    public void close(){
        impl.rawClose();
    }

    public final void display(){
        open();
        print();
        close();
    }

}

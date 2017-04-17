package DesignPattern.FactoryMethodPattern;

/**
 * main program for factory method
 * Created by tonytan on 16/4/2017.
 */
public class main {

    public static void main(String[] args){
        Factory factory = new IDCardFactory();
        Product p1 = factory.create("andy");
        Product p2 = factory.create("billy");
        Product p3 = factory.create("cooler");

        p1.use();
        p2.use();
        p3.use();
    }
}

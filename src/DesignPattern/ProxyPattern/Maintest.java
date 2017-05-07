package DesignPattern.ProxyPattern;

/**
 * Created by tonytan on 7/5/2017.
 */
public class Maintest {
    public static void main(String[] args){
        Printable p = new PrintProxy("Alice");
        System.out.println("current name: "+p.getPrinterName());
        p.setPrinterName("Bob");
        System.out.println("Current name: "+p.getPrinterName());
        p.print("HELLO WORLD!");
    }
}

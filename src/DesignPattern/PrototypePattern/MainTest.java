package DesignPattern.PrototypePattern;

/**
 * main test for prototype pattern
 * Created by tonytan on 17/4/2017.
 */
public class MainTest {

    public static void main(String[] args) {

        //init
        Manager manager = new Manager();
        UnderLinePen upen = new UnderLinePen('~');
        MessageBox msgbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');

        manager.register("underline pen", upen);
        manager.register("warning message", msgbox);
        manager.register("slash message", sbox);

        //create
        Product p1 = manager.create("underline pen");
        p1.use("Hello world");
        Product p2 = manager.create("warning message");
        p2.use("Hello world");
        Product p3 = manager.create("slash message");
        p3.use("Hello world");
    }

}

package DesignPattern.Singleton;

/**
 * Suggested singleton method
 * Created by tonytan on 14/5/2017.
 */
public class Singleton1 {
    private Singleton1(){
        // private
    }
    private static Singleton1 Instance = new Singleton1(); // create before use, eager initialization

    public static Singleton1 getInstance(){
        return Instance;
    }
}

package DesignPattern.BuilderPattern;

/**
 * abstract class for building
 * Created by tonytan on 17/4/2017.
 */
public abstract class Buidler {
    public abstract void makeTitle(String title);
    public abstract void makeString(String str);
    public abstract void makeItems(String[] items);
    public abstract void close();
}

package DesignPattern.PrototypePattern;

/**
 * The interface that contains clone function.
 * Created by tonytan on 17/4/2017.
 */
public interface Product  extends Cloneable{
    public abstract void use(String s);
    public abstract Product createClone();
}

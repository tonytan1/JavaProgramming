package DesignPattern.ProxyPattern;

/**
 * interface for print
 * Created by tonytan on 7/5/2017.
 */
public interface Printable {
    public abstract void setPrinterName(String name);
    public abstract String getPrinterName();
    public abstract void print(String string);// heavy job, cost lots of time
}

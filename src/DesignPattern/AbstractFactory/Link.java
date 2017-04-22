package DesignPattern.AbstractFactory;

/**
 *
 * Created by tonytan on 20/4/2017.
 */
public abstract class Link extends Item {
    protected String url;
    public Link(String caption, String url) {
        super(caption);
        this.url = url;
    }
}

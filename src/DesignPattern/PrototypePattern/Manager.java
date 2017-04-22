package DesignPattern.PrototypePattern;


import java.util.HashMap;

/**
 * use Product interface to clone object
 * Created by tonytan on 17/4/2017.
 */
public class Manager {
    private HashMap showCase = new HashMap();

    public void register(String name, Product proto) {
        showCase.put(name, proto);
    }

    public Product create(String protoname) {
        Product p = (Product) showCase.get(protoname);
        return p.createClone();
    }
}

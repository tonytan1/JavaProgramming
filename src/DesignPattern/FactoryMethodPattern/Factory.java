package DesignPattern.FactoryMethodPattern;

/**
 * abstract class of factory
 * Created by tonytan on 16/4/2017.
 */
public abstract class Factory {
    public final Product create(String owner){
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product product);

}

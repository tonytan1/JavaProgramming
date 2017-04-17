package DesignPattern.FactoryMethodPattern;

import java.util.Hashtable;

/**
 * inherit class : factory of making id card
 * Created by tonytan on 16/4/2017.
 */
public class IDCardFactory extends Factory {
    private Hashtable<Double, String> owners = new Hashtable<>();

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        owners.put(((IDCard)product).getId(), ((IDCard)product).getOwner());
    }
}

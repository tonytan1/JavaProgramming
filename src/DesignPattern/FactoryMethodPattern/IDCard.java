package DesignPattern.FactoryMethodPattern;

import java.util.Random;

/**
 * id card object
 * Created by tonytan on 16/4/2017.
 */
public class IDCard extends Product {
    private String owner;
    private Double id;

    IDCard(String owner){
        System.out.println("making id card for: "+owner);
        this.owner = owner;
        this.id = new Random().nextDouble();
        System.out.println("id card for "+owner + ": "+id.toString());
    }

    @Override
    public void use() {
        System.out.println("id card is used: "+owner + " " + id.toString());
    }

    public String getOwner(){
        return owner;
    }

    public Double getId(){
        return id;
    }
}

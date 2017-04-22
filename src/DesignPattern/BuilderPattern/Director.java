package DesignPattern.BuilderPattern;

/**
 * use methods of Builder to implement function
 * Created by tonytan on 17/4/2017.
 */
public class Director {
    private Buidler builder;

    public Director(Buidler builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.makeTitle("Greeting");
        builder.makeString("from morning to night");
        builder.makeItems(new String[]{
                "good morning",
                "good afternoon",
                "good night"
        });
        builder.close();

    }
}
package DesignPattern.Singleton;

/**
 * make three instance of singleton object
 * Created by tonytan on 17/4/2017.
 */
public class Triple {
    private int id;

    private static Triple[] triples = new Triple[] {
            new Triple(0),
            new Triple(1),
            new Triple(2)
    };

    private Triple(int id){
        System.out.println("making new instance: "+id);
    }

    public static Triple getInstance(int id){
        return triples[id];
    }
}

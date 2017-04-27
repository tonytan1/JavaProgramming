package ShowMeCode.Concurrency;

/**
 * Created by tonytan on 20/6/15.
 *
 * store name of Thread that finishes first.
 */
public class Result {
    private String name;

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

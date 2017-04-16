package DesignPattern.TemplatePattern;

/**
 * 具体实现
 * Created by tonytan on 16/4/2017.
 */
public class StringDisplay implements AbstractDisplay {
    private String string;


    public StringDisplay(String string){
        this.string = string;
    }

    @Override
    public void display() {
        for (int i = 0; i < 5; i++) {
            System.out.println(string);
        }
    }
}

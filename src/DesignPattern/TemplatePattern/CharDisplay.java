package DesignPattern.TemplatePattern;

/**
 * Created by tonytan on 16/4/2017.
 */
public class CharDisplay implements AbstractDisplay {

    private char ch ;

    public CharDisplay(char ch){
        this.ch = ch;
    }

    @Override
    public void display() {
        for (int i = 0; i < 5; i++) {
            System.out.println(ch);
        }
    }
}

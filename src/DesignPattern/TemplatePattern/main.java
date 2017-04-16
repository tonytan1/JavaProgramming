package DesignPattern.TemplatePattern;

/**
 * Created by tonytan on 16/4/2017.
 */
public class main {

    public static void main(String[] args){
        AbstractDisplay stringDisplay = new StringDisplay("hello world!");
        AbstractDisplay charDisplay = new CharDisplay('h');

        stringDisplay.display();
        charDisplay.display();
    }
}

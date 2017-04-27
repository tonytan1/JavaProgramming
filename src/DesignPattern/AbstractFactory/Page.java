package DesignPattern.AbstractFactory;

import ShowMeCode.Concurrency.Writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * Created by tonytan on 20/4/2017.
 */
public abstract class Page {
    protected String title;
    protected String author;
    protected ArrayList content = new ArrayList();

    public Page(String title, String author) {
        this.author = author;
        this.title = title;
    }

    public void add(Item item) {
        content.add(item);
    }

    public void output() {
        try {
            String filename = title + ".html";
            FileWriter writer = new FileWriter(filename);
            writer.write(this.makeHTML());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract String makeHTML();
}

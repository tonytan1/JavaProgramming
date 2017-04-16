package DesignPattern.IteratorPattern;


import java.util.ArrayList;

/**
 * aggregate class of methods that it controls object(book).
 * Created by tonytan on 11/4/2017.
 */
public class BookShelf implements Aggregate {
    private ArrayList<Book> books;


    public BookShelf() {
        this.books = new ArrayList<Book>();
    }

    public Book getBookAt(int index){
        return books.get(index);
    }

    public void appendBook(Book book){
        this.books.add(book);
    }

    public int getLength(){
        return this.books.size();
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}

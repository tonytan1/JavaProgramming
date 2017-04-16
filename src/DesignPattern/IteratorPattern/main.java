package DesignPattern.IteratorPattern;

/**
 * main program for iterator-pattern.
 * Created by tonytan on 11/4/2017.
 */
public class main {
    public static void main(String[] args){
        BookShelf bookShelf = new BookShelf();
        bookShelf.appendBook(new Book("Around the world"));
        bookShelf.appendBook(new Book("bible"));
        bookShelf.appendBook(new Book("cindy"));
        bookShelf.appendBook(new Book("daddy"));
        Iterator it = bookShelf.iterator();

        while (it.hasNext()){
            Book book = (Book) it.next();
            System.out.println(book.getName());
        }
    }
}



import java.util.*;

public class Library {
    private Set<Book> stock;

    public Library(){
        stock = new TreeSet<Book>();
    }

    public Collection<Book> getStock(){
        return stock;
    }

    public boolean insertBook(Book toInsertBook){
        if(stock.contains(toInsertBook)){
            return false;
        }
        stock.add(toInsertBook);
        return true;
    }

    public Book searchForIsbn(String isbn){
        Iterator<Book> iterator = stock.iterator();
        while(iterator.hasNext()) {
            Book element = iterator.next();
            if(element.getIsbn() == isbn){
                return element;
            }
        }
        return null;
    }

    public Collection<Book> searchForAuthor(String author){
        SortedSet<Book> booksByOneAuthor = new TreeSet<Book>();

        Iterator<Book> iterator = stock.iterator();
        while(iterator.hasNext()) {
            Book element = iterator.next();
            if(element.getAuthor().equals(author)){
                booksByOneAuthor.add(element);
            }
        }
        return booksByOneAuthor;
    }


}

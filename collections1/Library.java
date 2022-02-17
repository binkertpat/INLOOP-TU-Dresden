package collections1;

import java.util.*;

public class Library{
    private List<Book> stock;

    public Library(){
        stock = new ArrayList<Book>();
    }

    public boolean insertBook(Book toInsertBook){
        stock.add(toInsertBook);
        Collections.sort(stock);
        return true;
    }

    public Book searchForIsbn(String isbn){
        int idx = Collections.binarySearch(stock, new Book(isbn));
        if (idx >= 0) {
            return stock.get(idx);
        } else {
            return null;
        }
    }

    public Collection<Book> searchForAuthor(String author){
        Collection<Book> booksByOneAuthor = new ArrayList<Book>();
        for (Book book : stock) {
            if(book.getAuthor().equals(author)) {
                booksByOneAuthor.add(book);
            }
        }
        return booksByOneAuthor;
    }
}

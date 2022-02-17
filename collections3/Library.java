package collections3;

import java.util.*;

public class Library {
    private Map<String, Set<Book>> stock;

    public Library(){
        stock = new TreeMap<String, Set<Book>>(); 
    }

    public Collection<Book> getStock(){
        Set<Book> output = new TreeSet<Book>();;
        for (Map.Entry<String, Set<Book>> entry : stock.entrySet()) {
            output.addAll(entry.getValue());
        }
        return output;
    }

    public boolean insertBook(Book toInsertBook){

        Set<Book> tempSet = new TreeSet<Book>();
        tempSet.add(toInsertBook);

        if(stock.containsKey(toInsertBook.getAuthor())){
            Set<Book> savedSet = stock.get(toInsertBook.getAuthor());
            savedSet.add(toInsertBook);
            if(savedSet.contains(toInsertBook)){
                return false;
            } else{
                stock.replace(toInsertBook.getAuthor(), savedSet);
            }
        } else{
            stock.put(toInsertBook.getAuthor(), tempSet);
        }
        return true;
    }

    public Book searchForIsbn(String isbn){
        for (Map.Entry<String, Set<Book>> entry : stock.entrySet()) {
            for(Book book : entry.getValue()){
                if(book.getIsbn() == isbn){
                    return book;
                }
            }
        }
        return null;
    }

    public Map<String,Set<Book>> listStockByAuthor(){
        return stock;
    }

    public Collection<Book> searchForAuthor(String author){
        Set<Book> output = new TreeSet<Book>();
        if(!stock.isEmpty()){
            if(stock.get(author) == null){
                return output;
            }
            return stock.get(author);
        } else {
            return (output);
        }

    }


}

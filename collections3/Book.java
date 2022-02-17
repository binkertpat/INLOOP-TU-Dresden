package collections3;

public class Book implements Comparable<Book>{
    private String isbn;
    private String author;
    private String title;

    public Book(String isbn, String author, String title){
        if (isbn == null | author == null | title == null) {
            throw new IllegalArgumentException("Fill the fucking arguments.");
        } else {
            this.isbn = isbn;
            this.author = author;
            this.title = title;
        }
    }

    public Book(String isbn){
        if (isbn == null) {
            throw new IllegalArgumentException("Fill the fucking arguments.");
        } else {
            this.isbn = isbn;
            this.author = "";
            this.title = "";
        }
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString() {
        return this.getTitle() + " by " + this.getAuthor() + " (ISBN " + this.getIsbn() + ")";
    }

    public int hashCode(){
        return isbn.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Book) {
            Book book = (Book) o;
            return this.isbn.equals(book.getIsbn());
        }
        return false;
    }

    @Override
    public int compareTo(Book book) {
        return this.isbn.compareTo(book.getIsbn());
    }

}
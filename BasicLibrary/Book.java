public class Book {

    private String title;

    public Book(String title) {
        this.title = title;
        System.out.println("Book " + title + " created.");
    }

    public String toString() {
        return title;
    }
}

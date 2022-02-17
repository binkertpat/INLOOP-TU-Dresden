public class HelloLibrary {
    public static void main(String[] args) {
          Library lib = new Library();
          Book book1 = new Book("UML");
          Book book2 = new Book("Java2");
           
          lib.add(book1);
          lib.add(book2);

          lib.search("Java");
    }
  
  }
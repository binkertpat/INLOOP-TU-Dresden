

public class LibraryTest {

    public static void main(String[] args){
        Library lib = new Library();

        lib.insertBook(new Book("1234"));
        lib.insertBook(new Book("1234", "Testautor", "Testtitel"));
        lib.insertBook(new Book("12341", "Testautor1", "Testtitel1"));
        lib.insertBook(new Book("12342", "Testautor2", "Testtitel2"));
        lib.insertBook(new Book("12343", "Testautor3", "Testtitel3"));

        System.out.println(lib.searchForIsbn("12341"));
        System.out.println(lib.searchForAuthor("Testautor2"));

    }
    
}


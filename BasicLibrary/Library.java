public class Library {

    private Book [] myBooks;
 
    private int number;
 
    public Library() {
        myBooks = new Book[10];
        number = 0;
        System.out.println("Hello, I am a library, which can store up to 10 books!");
    }
 
    public void add(Book book) {
        if (number == 10){
             System.out.println("The library is full!");
        } else {
             System.out.println("I added the book " + book + "!");
             myBooks[number] = book;
        }
        number += 1;
     }
     
     public Book search(String title) {
        int position = -1;
        for(int i = 0; i < number; i++){
            if(myBooks[i] != null && myBooks[i].toString() == title){
                position = i;
            } 
        }
        if (position != -1){
            System.out.println("The book with the title " + myBooks[position].toString() + " exists in the library!");
            return myBooks[position];
        } else{
            System.out.println("The book with the title " + title + " does not exist in the library!");
            return null;
        }
     }
 }
 
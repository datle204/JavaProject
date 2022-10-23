import java.util.*;

public class bookList {

    // Add new book (1)

    // Create List of book
    private static List<Book> myBooks = new ArrayList<>();

    public static void add() {
        System.out.println("Enter information for the new book:");
        Scanner console = new Scanner(System.in);

        System.out.print("ID: ");
        String id = console.nextLine();

        System.out.print("Title: ");
        String title = console.nextLine();

        System.out.print("Author: ");
        String author = console.nextLine();

        System.out.print("Is borrowed (1 = yes, 0 = no): ");
        int choice = console.nextInt();
        Boolean isBorrowed = false;

        switch (choice) {
            case 1:
                isBorrowed = true;
                break;
            case 0:
                isBorrowed = false;
                break;
        }
        // Add to List of book (make id uppercase)
        addToList(id.toUpperCase(), title, author, isBorrowed);
        System.out.println("A new book has been added");
        
    }

    // Add new book to library
    public static void addToList(String id, String title, String author, Boolean isBorrowed) {

        Book book = new Book(id.toUpperCase(), title, author, isBorrowed);
        myBooks.add(book);
    }

    // Search a book (2)

    public static void search(){

        System.out.println("Enter book title to search.");
        System.out.print("Book title: ");
        Scanner console = new Scanner(System.in);

        // no need exactly like the original
        String searchKey = console.nextLine();  

        // Create a list books was founded;

        List<Book> booksFound = new ArrayList<>();

        // Search all book in myBooks list
        for(Book book : myBooks){
    
            if(book.getTitle().contains(searchKey)){
                booksFound.add(book);
            }
        }
    
        if(booksFound.isEmpty()){
            System.out.println("No book is found");
        }else{
            System.out.println(String.format("%-10s%-20s%-20s%-20s", "ID", "Title", "Author", "Is borrowed"));
            for (Book book : booksFound){
                System.out.println(book.toString());
            }
        }
    }

    // Display list books (3)

    public static void display() {

        System.out.println(String.format("%-10s%-20s%-20s%-20s", "ID", "Title", "Author", "Is borrowed"));
        for (Book book : myBooks) {

            System.out.println(book.toString());
        }
    }


    // Borrow a book (4)

    public static void borrow(){
        System.out.println("Enter book ID to borrow.");
        System.out.print("Book ID: ");

        Scanner console = new Scanner(System.in);
        String id = console.nextLine();

        
        for(Book book : myBooks){
   
            // ignore case when compare
           if(book.getId().equalsIgnoreCase(id)){
               
                if(book.isBorrowed()){
                    System.out.println("You can not borrow this book. The book has been borrowed.");
                    return;
                }
                book.setIsBorrowed(true);
                
                System.out.println("You have successfully borrow the book: " + book.getTitle());
                return;
            }
           
        }
        for(Book book: myBooks){
            if(!book.getId().equalsIgnoreCase(id)){
                System.out.println("The library doesn't have this book");
                return;
            }
        }

    }

    // Exit Program (5)

    public static void exit(){
        System.exit(0);
    }

   

}

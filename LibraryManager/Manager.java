import java.util.*;


public class Manager {

    public static void main(String[] args){
        System.out.println("Welcome to the online book library");
        while(true){
            System.out.println("-----------------------------");
            System.out.println("1. Enter a new book");
            System.out.println("2. Search a book by book title");
            System.out.println("3. Display books");
            System.out.println("4. Borrow a book by book id");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            
            Scanner console = new Scanner(System.in);
            int choice = console.nextInt();
            switch(choice){
                case 1: 
                    bookList.add();
                    break;
                case 2:
                    bookList.search();
                    break;
                case 3: 
                    bookList.display();
                    break;
                case 4:
                    bookList.borrow();
                    break;
                case 5:
                    bookList.exit();
                    break;
            }
        }
    }
   
}

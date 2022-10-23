public class Book {

    private String id;
    private String title;
    private String author;
    private Boolean isBorrowed = false;

    
    public Book(String id, String title, String author, Boolean isBorrowed){

        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = isBorrowed;
    }
   
    // Get id of book
    public String getId(){
        return id;
    }
    // Set id for book
    public void setId(String id){
        this.id = id;
    }

    // Get title of book
    public String getTitle(){
        return title;
    }

    // set title for book
    public void setTitle(String title){
        this.title = title;
    }
    
    // get author of book
    public String author(){
        
        return author;
    }

    // set author for book
    public void setAuthor(String author){
        this.author = author;
    }
    // get status of book
    public Boolean isBorrowed(){
        return isBorrowed;
    }
    // set status for book
    public void setIsBorrowed(Boolean isBorrowed){
        this.isBorrowed = isBorrowed;
    }

    // Ghi đè, format lại toString()
    @Override
    public String toString(){
        return String.format("%-10s%-20s%-20s%-20s", id, title, author, isBorrowed);
    }
   
}

import java.util.ArrayList;
/**
 * Write a description of class BookStore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BookStore
{
    // instance variables - replace the example below with your own
    private ArrayList<Book> booklist;
    private String businessName;

    /**
     * Constructor for objects of class BookStore
     */
    public BookStore()
    {
        // initialise instance variables
        businessName = "Book Store";
        booklist = new ArrayList<Book>();
    }

    /**
     * Non-default Constructor for objects of class BookStore
     */
    public BookStore(String businessName)
    {
        // initialise instance variables using passed in parameters
        setBusinessName(businessName);
        booklist = new ArrayList<Book>();
    }
    
    //Accessor methods
    public String getBusinessName() {
        return businessName;
    }

    //Mutator methods
    public void setBusinessName(String businessName) {
        if(businessName != null) {
            this.businessName = businessName;
        } else if(this.businessName == null) {
            this.businessName = "";
        } else {
            System.out.println("Invalid parameter! Business name not changed.");
        }
    }
    
    //ArrayList methods
    public void addBook(Book book) {
        System.out.println("Attempting to add book to book list...");
        if(book != null) {
            booklist.add(book);
            System.out.println("Success! " + book.getTitle() + " added.");
        } else {
            System.out.println("Invalid book! Please try adding a different book.");
        }
        System.out.println();
    }
    
    public void getBook(int bookIndex) {
        System.out.println("Attempting to get details of the book at index " + bookIndex + " from the book list...");
        if(bookIndex >= 0 && bookIndex < booklist.size()) {
            System.out.println("Success! Book at index " + bookIndex + " details:");
            booklist.get(bookIndex).displayBookDetails();
        } else {
            System.out.println("Invalid book list index! Please enter an index value from 0 to " + (booklist.size()-1) + ".");
        }
        System.out.println();
    }
    
    public void findBook(String bookTitle) {
        System.out.println("Searching book list for: " + bookTitle);
        for(Book currentBook: booklist) {
            if(currentBook.getTitle().equalsIgnoreCase(bookTitle)) {
                System.out.println("Book found!");
                currentBook.displayBookDetails();
                return;
            }
        }
        
        System.out.println("Book NOT found! Please try your search again.");
        System.out.println();
    }
    
    public void displayAllBooks() {
        System.out.println("Details of all books:");
        for(Book currentBook: booklist) {
            currentBook.displayBookDetails();
        }
    }
    
    public static void main(String args[]) {
        Book book1 = new Book("The Art of War", "Sun Tzu", 500, 20);
        Book book2 = new Book("The Robots of Dawn", "Isaac Asimov", 1983, 15);
        Book book3 = new Book("Rocket Men", "Craig Nelson", 2009, 25);
        
        BookStore myBookstore = new BookStore("The Inkwell");
        
        myBookstore.addBook(book1); //adding all three books to the arraylist
        myBookstore.addBook(book2);
        myBookstore.addBook(book3);
        
        myBookstore.getBook(4); //invalid index will give an error message
        myBookstore.getBook(2);
        
        myBookstore.findBook("Space Chronicles"); //book does not exist will give error
        myBookstore.findBook("the ART of war"); //case insensitive search
        
        myBookstore.displayAllBooks();
    }
}

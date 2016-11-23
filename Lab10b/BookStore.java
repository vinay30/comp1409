import java.util.ArrayList;
/**
 * Class describing the fields and methods used to operate a bookstore containing a list of books
 * 
 * @author Vinay Punwani
 * @version v1.0 Nov 22, 2016
 */
public class BookStore
{
    // instance variables
    private ArrayList<Book> booklist;
    private String businessName;

    /**
     * Constructor for objects of class BookStore
     */
    public BookStore()
    {
        // initialise instance variables to default values
        businessName = "Book Store";
        booklist = new ArrayList<Book>();
    }

    /**
     * Non-default Constructor for objects of class BookStore
     *
     * @param businessName A parameter containing the new business name of the book store
     */
    public BookStore(String businessName)
    {
        // initialise instance variables using passed in parameters
        setBusinessName(businessName);
        booklist = new ArrayList<Book>();
    }
    
    //Accessor methods
    /**
     * Method getBusinessName which returns the business name of the book store
     *
     * @return The return value which is a string of the business name
     */
    public String getBusinessName() {
        return businessName;
    }
    
    /**
     * Method getBooklist which returns the arraylist containing all the book objects
     *
     * @return The return value which is the arrayList containing book objects
     */
    public ArrayList<Book> getBooklist() {
        return booklist;
    }

    //Mutator methods
    /**
     * Method setBusinessName which validates and sets the new business name of the book store from a passed in
     * parameter. If the parameter is invalid, the business name is not changed.
     *
     * @param businessName A parameter containing the new business name
     */
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
    /**
     * Method addBook which validates the passed in book object, then adds it to the end of the booklist arraylist
     * If the book object fails validation, an error message is displayed
     *
     * @param book A parameter containing a book object to be added to the booklist arraylist
     */
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
    
    /**
     * Method getBook which uses a passed in parameter containing an arraylist index to retrieve the object
     * at the specified index from the booklist arraylist. The parameter is validated before being used.
     * If the index in the parameter fails validation, an error message is displayed
     *
     * @param bookIndex A parameter containing an index value of the booklist arraylist
     */
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
    
    /**
     * Method findBook which takes a passed in parameter and searches the booklist arraylist for the book object with
     * a title that matches the parameter string. If the book is found, the book's details are displayed. If the
     * book is not found, an error message is displayed.
     *
     * @param bookTitle A parameter containing the book title search query
     */
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
    
    /**
     * Method displayAllBooks which iterates through each book object in the booklist arraylist and then displays
     * the details of each book within the arraylist. In this way, we see the details of all books in the booklist
     *
     */
    public void displayAllBooks() {
        System.out.println("Details of all books:");
        for(Book currentBook: booklist) {
            currentBook.displayBookDetails();
        }
    }
    
    /**
     * Method main which contains all statements that should be evaluated when the program is first run
     *
     * @param args A parameter containing arguments for the main method code
     */
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

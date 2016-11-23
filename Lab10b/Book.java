
/**
 * Class describing the fields and methods used to store and retrieve book information
 * 
 * @author Vinay Punwani
 * @version v1.0 Nov 22, 2016
 */
public class Book
{
    // instance variables
    private String title;
    private String author;
    private int yearPublished;
    private double bookPriceInCAD;

    /**
     * Constructor for objects of class Book
     */
    public Book()
    {
        // initialise instance variables to defaults
        title = "";
        author = "";
        yearPublished = 0;
        bookPriceInCAD = 0.0;
    }
    
    /**
     * Non-default Constructor for objects of class Book
     *
     * @param title A parameter containing the new title of the book
     * @param author A parameter containing the new author of the book
     * @param yearPublished A parameter containing the year of publication for the book
     * @param bookPriceInCAD A parameter containing the book price in CAD
     */
    public Book(String title, String author, int yearPublished, double bookPriceInCAD)
    {
        // initialise instance variables to passed in values
        setTitle(title);
        setAuthor(author);
        setYearPublished(yearPublished);
        setBookPriceInCAD(bookPriceInCAD);
    }

    //Accessor methods begin
    /**
     * Method getTitle which returns the title of the book
     *
     * @return The return value which is the title of the book as a string
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Method getAuthor which returns the author of the book
     *
     * @return The return value which is the author of the book as a string
     */
    public String getAuthor() {
        return author;
    }
    
    /**
     * Method getYearPublished which returns the publication year of the book
     *
     * @return The return value which is an int of the year published
     */
    public int getYearPublished() {
        return yearPublished;
    }
    
    /**
     * Method getBookPriceInCAD which returns the book price in CAD
     *
     * @return The return value which is a double, the book price in CAD
     */
    public double getBookPriceInCAD() {
        return bookPriceInCAD;
    }
    
    //Mutator methods begin
    /**
     * Method setTitle which validates then sets the title of the book from a passed in parameter. If the title
     * is not valid, an error message will be displayed.
     *
     * @param title A parameter containing the book title as a string
     */
    public void setTitle(String title) {
        if(title != null) {
            this.title = title;
        } else if(this.title == null) {
            this.title = "";
        } else {
            System.out.println("Invalid parameter! Title not changed.");
        }
    }
    
    /**
     * Method setAuthor which validates then sets the author of the book from a passed in parameter. If the author
     * is not valid, an error message will be displayed.
     *
     * @param author A parameter containing the book author as a string
     */
    public void setAuthor(String author) {
        if(author != null) {
            this.author = author;
        } else if(this.author == null) {
            this.author = "";
        } else {
            System.out.println("Invalid parameter! Author not changed.");
        }
    }
    
    /**
     * Method setYearPublished which validates and sets the publication year of the book from a passed in parameter.
     *
     * @param yearPublished A parameter containing the publication year of the book, an int
     */
    public void setYearPublished(int yearPublished) {
        if(yearPublished > 0) {
            this.yearPublished = yearPublished;
        } else if(this.yearPublished <= 0) {
            this.yearPublished = 0;
        } else {
            System.out.println("Invalid parameter! Year not changed.");
        }
    }
    
    /**
     * Method setBookPriceInCAD which validates and sets the book price in canadian dollars from a passed in parameter
     *
     * @param bookPriceInCAD A parameter containing the new book price, a double
     */
    public void setBookPriceInCAD(double bookPriceInCAD) {
        if(bookPriceInCAD > 0.0) {
            this.bookPriceInCAD = bookPriceInCAD;
        } else if(this.bookPriceInCAD <= 0.0) {
            this.bookPriceInCAD = 0.0;
        } else {
            System.out.println("Invalid parameter! Price not changed.");
        }
    }
    
    /**
     * Method displayBookDetails which displays all the fields of the book object on the screen
     *
     */
    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year Published: " + yearPublished);
        System.out.println("Price (CAD): $" + bookPriceInCAD);
        System.out.println();
    }
}

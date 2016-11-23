
/**
 * Write a description of class Book here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        // initialise instance variables
        title = "";
        author = "";
        yearPublished = 0;
        bookPriceInCAD = 0.0;
    }
    
    /**
     * Non-default Constructor for objects of class Book
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
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public int getYearPublished() {
        return yearPublished;
    }
    
    public double getBookPriceInCAD() {
        return bookPriceInCAD;
    }
    
    //Mutator methods begin
    public void setTitle(String title) {
        if(title != null) {
            this.title = title;
        } else if(this.title == null) {
            this.title = "";
        } else {
            System.out.println("Invalid parameter! Title not changed.");
        }
    }
    
    public void setAuthor(String author) {
        if(author != null) {
            this.author = author;
        } else if(this.author == null) {
            this.author = "";
        } else {
            System.out.println("Invalid parameter! Author not changed.");
        }
    }
    
    public void setYearPublished(int yearPublished) {
        if(yearPublished > 0) {
            this.yearPublished = yearPublished;
        } else if(this.yearPublished <= 0) {
            this.yearPublished = 0;
        } else {
            System.out.println("Invalid parameter! Year not changed.");
        }
    }
    
    public void setBookPriceInCAD(double bookPriceInCAD) {
        if(bookPriceInCAD > 0.0) {
            this.bookPriceInCAD = bookPriceInCAD;
        } else if(this.bookPriceInCAD <= 0.0) {
            this.bookPriceInCAD = 0.0;
        } else {
            System.out.println("Invalid parameter! Price not changed.");
        }
    }
    
    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year Published: " + yearPublished);
        System.out.println("Price (CAD): $" + bookPriceInCAD);
        System.out.println();
    }
}

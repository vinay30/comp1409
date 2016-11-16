/**
 * Class describing the behaviours, variables, and client data of a book club rewards program
 * 
 * @author Vinay Punwani
 * @version 1.1 Oct 8, 2016
 */
public class BookClub
{
    // static variables defining symbolic constants and variables available to all objects
    private static int totalNumberOfPurchasedBooks = 0;
    public static final int FIRST_REWARD_LEVEL_POINTS = 5;
    public static final int SECOND_REWARD_LEVEL_POINTS = 15;
    public static final int THIRD_REWARD_LEVEL_POINTS = 30;
    public static final int FOURTH_REWARD_LEVEL_POINTS = 60;
    public static final int FIRST_REWARD_LEVEL = 1;
    public static final int SECOND_REWARD_LEVEL = 2;
    public static final int THIRD_REWARD_LEVEL = 3;
    public static final int FOURTH_REWARD_LEVEL = 4;
    
    //instance variables of the class
    private String clientName;
    private int numberOfPurchasedBooksPerMonth;
    private double bookPriceInCAD;
    

    /**
     * Default Constructor for objects of class BookClub
     */
    public BookClub()
    {
        // initialise instance variables to default values
        clientName = "";
        numberOfPurchasedBooksPerMonth = 0;
        bookPriceInCAD = 0.0;
    }

    /**
     * Non-default Constructor for objects of class BookClub
     * 
     * @param newClientName name of a new member of the bookclub
     * @param newNumberOfPurchasedBooksPerMonth additional amount of books purchased in a given month
     * @param newBookPriceInCAD new supplied book price in CAD
     */
    public BookClub(String newClientName, int newNumberOfPurchasedBooksPerMonth, double newBookPriceInCAD)
    {
        // initialise instance variables after validation
        if(newClientName != null) {
            clientName = newClientName;
        } else {
            clientName = "";
        }
        
        if(newNumberOfPurchasedBooksPerMonth > 0) {
            numberOfPurchasedBooksPerMonth = newNumberOfPurchasedBooksPerMonth;
            totalNumberOfPurchasedBooks += numberOfPurchasedBooksPerMonth;
        } else {
            numberOfPurchasedBooksPerMonth = 0;
        }

        if(newBookPriceInCAD > 0.0) {
            bookPriceInCAD = newBookPriceInCAD;
        } else {
            bookPriceInCAD = 0.0;
        }
    }
    
    //Accessor methods start
    /**
     * Accessor method to get the client/member name
     * 
     * @return the client's name as a String
     */
    public String getClientName() {
        return clientName;
    }
    
    /**
     * Accessor method to get the number of purchased books per month
     * 
     * @return the number of purchased books per month as an integer
     */
    public int getNumberOfPurchasedBooksPerMonth() {
        return numberOfPurchasedBooksPerMonth;
    }
    
    /**
     * Accessor method to get the price of the book in CAD
     * 
     * @return the book price in CAD
     */
    public double getBookPriceInCAD() {
        return bookPriceInCAD;
    }
    
    //Static accessor method
    /**
     * Static Accessor method available to all objects to get the total number of purchased books
     * 
     * @return the total number of purchased books as an integer
     */
    public static int getTotalNumberOfPurchasedBooks() {
        return totalNumberOfPurchasedBooks;        
    }
    
    //Mutator methods start
    /**
     * Mutator Method setClientName which sets a new client name from a passed in value after validation
     *
     * @param newClientName New passed in client name
     */
    public void setClientName(String newClientName) {
        if(newClientName != null) {
            clientName = newClientName;
        } else {
            System.out.println("Cannot set name. Please enter a valid name!");
        }
    }
    
    /**
     * Mutator Method setNumberOfPurchasedBooksPerMonth which adds to the number of purchased books per month from a passed in value
     *
     * @param newNumberOfPurchasedBooksPerMonth which is passed in to increase the number of purchased books
     */
    public void setNumberOfPurchasedBooksPerMonth(int newNumberOfPurchasedBooksPerMonth) {
        if(newNumberOfPurchasedBooksPerMonth > 0) {
            numberOfPurchasedBooksPerMonth += newNumberOfPurchasedBooksPerMonth;
            totalNumberOfPurchasedBooks += newNumberOfPurchasedBooksPerMonth;
        } else {
            System.out.println("Cannot update purchased books. Please enter a positive number of books!");
        }
    }
    
    /**
     * Mutator Method setBookPriceInCAD which sets a new book price from a passed in value after validation
     *
     * @param newBookPriceInCAD new book price in CAD
     */
    public void setBookPriceInCAD(double newBookPriceInCAD) {
        if(newBookPriceInCAD > 0.0) {
            bookPriceInCAD = newBookPriceInCAD;
        } else {
            bookPriceInCAD = 0.0;
        }
    }
    
    /**
     * Method calculateBookPoints which calculates the reward points for a member of the book club based on their
     * number of purchased books per month.
     *
     * @return the total amount of reward points calculated for a specific member
     */
    public int calculateBookPoints() {
        int bookPoints = 0;
        
        if(numberOfPurchasedBooksPerMonth == FIRST_REWARD_LEVEL) {
            bookPoints += FIRST_REWARD_LEVEL_POINTS;
        } else if(numberOfPurchasedBooksPerMonth == SECOND_REWARD_LEVEL) {
            bookPoints += SECOND_REWARD_LEVEL_POINTS;
        } else if(numberOfPurchasedBooksPerMonth == THIRD_REWARD_LEVEL) {
            bookPoints += THIRD_REWARD_LEVEL_POINTS;
        } else if(numberOfPurchasedBooksPerMonth >= FOURTH_REWARD_LEVEL) {
            bookPoints += FOURTH_REWARD_LEVEL_POINTS;
        }
    
        return bookPoints;
    }
}
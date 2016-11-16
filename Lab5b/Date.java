import java.util.Calendar;
/**
 * Class to display a specified date in a certain format
 * 
 * @author Vinay Punwani
 * @version 1.0 Oct 16, 2016
 */
public class Date
{
    // static variables accessible and referenced by all objects
    public static final int FIRST_DAY = 1;
    public static final int LAST_DAY = 31;
    public static final int FIRST_MONTH = 1;
    public static final int LAST_MONTH = 12;
    public static final int INITIAL_YEAR = 1900;
    public static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
    
    // instance variables used by all objects
    private int day;
    private int month;
    private int year;

    /**
     * Default Constructor for objects of class Date
     */
    public Date()
    {
        // initialise instance variables to defaults
        day = 0;
        month = 0;
        year = 0;
    }

    /**
     * Non-default Constructor for objects of class Date
     * 
     * @param newDay day of month specified by user as an int
     * @param newMonth month of the year specified by user as an int
     * @param newYear year specified by user as an int
     */
    public Date(int newDay, int newMonth, int newYear)
    {
        // validate and initialise instance variables to passed in params
        if(newDay >= FIRST_DAY && newDay <= LAST_DAY) {
            day = newDay;
        } else {
            day = 0;
        }
        
        if(newMonth >= FIRST_MONTH && newMonth <= LAST_MONTH) {
            month = newMonth;
        } else {
            month = 0;
        }
        
        if(newYear >= INITIAL_YEAR && newYear <= CURRENT_YEAR) {
            year = newYear;
        } else {
            year = 0;
        }
    }
    
    //Accessor methods begin
    /**
     * Method getDay that returns the day of the month as an int
     *
     * @return The return value of the day variable
     */
    public int getDay() {
        return day;
    }
    
    /**
     * Method getMonth that returns the month as an int
     *
     * @return The return value of the month variable
     */
    public int getMonth() {
        return month;
    }
    
    /**
     * Method getYear that returns the year as an int
     *
     * @return The return value of the year variable
     */
    public int getYear() {
        return year;
    }
    
    //Mutator methods begin
    /**
     * Method setDay which sets a new day of the month after validation from a passed in parameter
     *
     * @param newDay A parameter containing the new day of the month supplied by the user as an int
     */
    public void setDay(int newDay) {
        if(newDay >= FIRST_DAY && newDay <= LAST_DAY) {
            day = newDay;
        } else {
            day = 0;
            System.out.println("Invalid day parameter! Default day of 0 will be used.");
        }
    }
    
    /**
     * Method setMonth which sets a new month of the year after validation from a passed in parameter
     *
     * @param newMonth A parameter containing the new month supplied by the user as an int
     */
    public void setMonth(int newMonth) {
        if(newMonth >= FIRST_MONTH && newMonth <= LAST_MONTH) {
            month = newMonth;
        } else {
            month = 0;
            System.out.println("Invalid month parameter! Default month of 0 will be used.");
        }
    }
    
    /**
     * Method setYear which sets a new year after validation from a passed in parameter
     *
     * @param newYear A parameter containing the year supplied by the user as an int
     */
    public void setYear(int newYear) {
        if(newYear >= INITIAL_YEAR && newYear <= CURRENT_YEAR) {
            year = newYear;
        } else {
            year = 0;
            System.out.println("Invalid year parameter! Default year of 0 will be used.");
        }
    }
    
    
    /**
     * Method displayDate uses a switch case statement to display the user specified date
     * in a specific format. Also verifies the validity of date values before displaying.
     *
     */
    public void displayDate() {
        String monthName = "";
        
        switch(month) {
            case 1:
            monthName = "January";
            break;
            case 2:
            monthName = "February";
            break;
            case 3:
            monthName = "March";
            break;
            case 4:
            monthName = "April";
            break;
            case 5:
            monthName = "May";
            break;
            case 6:
            monthName = "June";
            break;
            case 7:
            monthName = "July";
            break;
            case 8:
            monthName = "August";
            break;
            case 9:
            monthName = "September";
            break;
            case 10:
            monthName = "October";
            break;
            case 11:
            monthName = "November";
            break;
            case 12:
            monthName = "December";
            break;
            default:
            System.out.println("Invalid month! Please enter a month from 1 to 12.");
        }
        
        //verify valid date values before attempting to display the date
        if(monthName != "" && day != 0 && year != 0) {
            System.out.println(monthName + " " + day + ", " + year);
        } else {
            System.out.println("Unable to display date due to invalid day, month, or year parameters!");
        }
    }
}

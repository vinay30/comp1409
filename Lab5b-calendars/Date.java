import java.util.Calendar;
import java.text.SimpleDateFormat;
/**
 * Displays the date in a specific format from user submitted values
 * 
 * @author Vinay Punwani
 * @version 1.0 Oct 13, 2016
 */
public class Date
{
    // static variables accessible and referenced by all objects
    public static final int FIRST_DAY = 1;
    public static final int LAST_DAY = 31;
    public static final int FIRST_MONTH = 1;
    public static final int LAST_MONTH = 12;
    public static final int MONTH_OFFSET = 1; // So that month 1 will be January
    public static final int INITIAL_YEAR = 1900;
    public static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
    public static final SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
    
    private Calendar CAL = Calendar.getInstance(); //Different calendars for each object
    /**
     * Constructor for objects of class Date
     */
    public Date()
    {
        // initialise new calendar to default date
        CAL.set(Calendar.DAY_OF_MONTH, FIRST_DAY);
        CAL.set(Calendar.MONTH, FIRST_MONTH-MONTH_OFFSET); //Sets month to 0 (Jan)
        CAL.set(Calendar.YEAR, INITIAL_YEAR);
        System.out.println("Default date of " + dateFormat.format(CAL.getTime()) + " has been set.");
    }

    /**
     * Non-default Constructor for objects of class Date
     * 
     * @param newDay user supplied value for the day of the month
     * @param newMonth user supplied value for the month
     * @param newYear user supplied value for the year
     */
    public Date(int newDay, int newMonth, int newYear)
    {
        // validate and update calendar object
        if(newDay >= FIRST_DAY && newDay <= LAST_DAY) {
            CAL.set(Calendar.DAY_OF_MONTH, newDay);
        } else {
            CAL.set(Calendar.DAY_OF_MONTH, FIRST_DAY);
            System.out.println("Invalid day. " + FIRST_DAY + " has been used instead.");
        }
        
        if(newMonth >= FIRST_MONTH && newMonth <= LAST_MONTH) {
            CAL.set(Calendar.MONTH, newMonth-MONTH_OFFSET); //Reduces month value by 1 since CAL index starts at 0 = January
        } else {
            CAL.set(Calendar.MONTH, FIRST_MONTH-MONTH_OFFSET);
            System.out.println("Invalid month. " + monthFormat.format(CAL.getTime()) + " has been used instead.");
        }
        
        if(newYear >= INITIAL_YEAR && newYear <= CURRENT_YEAR) {
            CAL.set(Calendar.YEAR, newYear);
        } else {
            CAL.set(Calendar.YEAR, INITIAL_YEAR);
            System.out.println("Invalid year. " + INITIAL_YEAR + " has been used instead.");
        }
        
        System.out.println("New date of " + dateFormat.format(CAL.getTime()) + " has been set.");
    }
    
    //Accessor methods begin
    /**
     * Method getDay which returns the day integer from the Calendar instance
     *
     * @return day of the month stored in the Calendar instance as an int
     */
    public int getDay() {
        return CAL.get(Calendar.DAY_OF_MONTH);
    }
    
    /**
     * Method getMonth which returns the month string from the Calendar instance
     *
     * @return month stored in the Calendar instance converted to a string
     */
    public String getMonth() {
        return monthFormat.format(CAL.getTime());
    }
    
    /**
     * Method getYear which returns the year int from the Calendar instance
     *
     * @return year stored in the Calendar instance as an int
     */
    public int getYear() {
        return CAL.get(Calendar.YEAR);
    }
    
    //Mutator methods begin
    /**
     * Method setDay using a java utility function to update the day value in the Calendar instance of the object
     *
     * @param newDay A parameter containing the new day of the month
     */
    public void setDay(int newDay) {
        if(newDay >= FIRST_DAY && newDay <= LAST_DAY) {
            CAL.set(Calendar.DAY_OF_MONTH, newDay);
        } else {
            CAL.set(Calendar.DAY_OF_MONTH, FIRST_DAY);
            System.out.println("Invalid day. " + FIRST_DAY + " has been used instead.");
        }
    }
    
    /**
     * Method setMonth using a java utility function to update the month value in the Calendar instance of the object
     *
     * @param newMonth A parameter holding the new month
     */
    public void setMonth(int newMonth) {
        if(newMonth >= FIRST_MONTH && newMonth <= LAST_MONTH) {
            CAL.set(Calendar.MONTH, newMonth-MONTH_OFFSET);
        } else {
            CAL.set(Calendar.MONTH, FIRST_MONTH-MONTH_OFFSET);
            System.out.println("Invalid month. " + monthFormat.format(CAL.getTime()) + " has been used instead.");
        }
    }
    
    /**
     * Method setYear using a java utility function to update the year value in the Calendar instance of the object
     *
     * @param newYear A parameter containing the new year
     */
    public void setYear(int newYear) {
        if(newYear >= INITIAL_YEAR && newYear <= CURRENT_YEAR) {
            CAL.set(Calendar.YEAR, newYear);
        } else {
            CAL.set(Calendar.YEAR, INITIAL_YEAR);
            System.out.println("Invalid year. " + INITIAL_YEAR + " has been used instead.");
        }
    }
    
    /**
     * Displays date stored in Calendar instance according to specified date format
     * 
     */
    public void displayDate() {
        System.out.println(dateFormat.format(CAL.getTime()));
    }
}

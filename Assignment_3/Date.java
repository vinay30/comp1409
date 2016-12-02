
/**
 * Class describing the methods of the date object
 * 
 * @author Vinay Punwani
 * @version v1.0 Nov 15th, 2016
 */
public class Date
{
    // static variables
    public static final int EARLIEST_YEAR = 1900;
    public static final int FIRST_MONTH = 1;
    public static final int LAST_MONTH = 12;
    public static final int FIRST_DAY = 1;
    public static final int LAST_DAY = 31;
    
    // instance variables
    private int year;
    private int month;
    private int day;

    /**
     * Constructor for objects of class Date
     */
    public Date()
    {
        // initialise instance variables
        day = FIRST_DAY;
        month = FIRST_MONTH;
        year = EARLIEST_YEAR;        
    }

    /**
     * Non-default Constructor for objects of class Date
     *
     * @param year A parameter containing the new year
     * @param month A parameter containing the new month
     * @param day A parameter containing the new day
     */
    public Date(int year, int month, int day)
    {
        // initialise instance variables
        setDay(day);
        setMonth(month);
        setYear(year);    
    }
    
    //Accessor methods begin
    /**
     * Method getDay which returns the day of the date
     *
     * @return The return value which is the int of the day value
     */
    public int getDay() {
        return day;
    }
    
    /**
     * Method getMonth which returns the month of the date
     *
     * @return The return value which is an int of the month value
     */
    public int getMonth() {
        return month;
    }
    
    /**
     * Method getYear which returns the year of the date
     *
     * @return The return value which is an int of the year value
     */
    public int getYear() {
        return year;
    }
    
    //Mutator methods begin
    /**
     * Method setDay which updates or creates a new day value in the date object
     *
     * @param day A parameter containing the new day of the date object
     */
    public void setDay(int day) {
        if(day >= FIRST_DAY && day <= LAST_DAY) {
            this.day = day;
        } else if(this.day < FIRST_DAY || this.day > LAST_DAY) {
            this.day = FIRST_DAY;
        }
    }
    
    /**
     * Method setMonth which updates or creates a new month value in the date object
     *
     * @param month A parameter containing the new month of the date object
     */
    public void setMonth(int month) {
        if(month >= FIRST_MONTH && month <= LAST_MONTH) {
            this.month = month;
        } else if(this.month < FIRST_MONTH || this.month > LAST_MONTH) {
            this.month = FIRST_MONTH;
        }
    }
    
    /**
     * Method setYear which updates or creates a new year value in the date object
     *
     * @param year A parameter containing the new year of the date object
     */
    public void setYear(int year) {
        if(year >= EARLIEST_YEAR) {
            this.year = year;
        } else if(this.year < EARLIEST_YEAR) {
            this.year = EARLIEST_YEAR;
        }
    }
    
    /**
     * Method getDate which returns a properly formatted date string representing the values contained in the date object
     *
     * @return The return value which is a string of the date parts properly formatted to be displayed
     */
    public String getDate() {
        String dayString = String.format("%02d", day); //add leading zeroes up to a width of 2 digits wide
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
            System.out.println("Invalid month! Please enter a month from " + FIRST_MONTH + "to " + LAST_MONTH);
        }
                
        return dayString + " " + monthName + " " + year;
    }
    
    /**
     * Method displayDate which calls another method to display the properly formatted date in the console
     *
     */
    public void displayDate() {
        System.out.println(getDate());
    }
}


/**
 * Class describing the information (driver and speed data) used by police to issue tickets to passing motorists
 * 
 * @author Vinay Punwani
 * @version 1.0 - Sept 30 2016
 */
public class Driver
{
    // instance variables for Driver class
    private String driverName;
    private String driverLicenseNumber;
    private int speedInKilometerPerHour;
    private String driverStanding;

    /**
     * Default Constructor for objects of class Driver which initializes all instance variables to their default values
     */
    public Driver()
    {
        // initialise instance variables for default constructor
        driverName = "";
        driverLicenseNumber = "";
        speedInKilometerPerHour = 0;
        driverStanding = "";
    }
    
    /**
     * Non-default Constructor for objects of class Driver which takes parameters and uses them if they pass validation
     * 
     * @param String New Name of driver
     * @param String New License number of driver
     * @param int New Speed of driver in kilometers per hour
     */
    public Driver(String newDriverName, String newDriverLicenseNumber, int newSpeedInKilometerPerHour)
    {
        // initialise instance variables for non-default constructor
        if (newDriverName != null) {
            driverName = newDriverName;
        } else {
            driverName = "";
        }
        
        if (newDriverLicenseNumber != null) {
            driverLicenseNumber = newDriverLicenseNumber;
        } else {
            driverLicenseNumber = "";
        }
        
        if (newSpeedInKilometerPerHour > 0) {
            speedInKilometerPerHour = newSpeedInKilometerPerHour;
        } else {
            speedInKilometerPerHour = 0;
        }    
        
        driverStanding = "";
    }
    
    //Accessor methods begin
    /**
     * Accessor method to get the name of the driver
     * 
     * @return the driver's name as a string
     */
    public String getDriverName() {
        return driverName;
    }
    
    /**
     * Accessor method to get the license number of the driver
     * 
     * @return the license number of the driver as a string
     */
    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }
    
    /**
     * Accessor method to get the speed in kilometers per hour of the driver
     * 
     * @return the speed of the driver in kilometers per hour
     */
    public int getSpeedInKilometerPerHour() {
        return speedInKilometerPerHour;
    }
    
    /**
     * Accessor method to get the standing of the driver
     * 
     * @return the driver standing as a string
     */
    public String getDriverStanding() {
        return driverStanding;
    }
        
    //Mutator methods begin
    /**
     * Mutator method which sets the value of the driver name string from a new passed in driver name if it is not null
     * Sets the driver name to an empty string if the new passed in parameter is null
     * 
     * @param new driver name which is passed into the method when it is called
     */
    public void setDriverName(String newDriverName) {
        if (newDriverName != null) {
            driverName = newDriverName;
        } else 
            if(newDriverName == null){
            driverName = "";
        }
        System.out.println("Driver name updated to " + driverName + " successfully!");
    }
    
    /**
     * Mutator method which sets the value of the driver license number from a new passed in driver license number if it is not null
     * Sets the driver license to an empty string if the new passed in parameter is null
     * 
     * @param new driver license number which is passed into the method when it is called
     */
    public void setDriverLicenseNumber(String newDriverLicenseNumber) {
        if (newDriverLicenseNumber != null) {
            driverLicenseNumber = newDriverLicenseNumber;
        } else 
            if(newDriverLicenseNumber == null){
            driverLicenseNumber = "";
        }
        System.out.println("Driver license number updated to " + driverLicenseNumber + " successfully!");
    }
    
    /**
     * Mutator method which sets the value of the driver speed in km per hour from a new passed in driver speed if it passes validation
     * 
     * @param new driver speed in km per hour which is passed into the method when it is called
     */
    public void setSpeedInKilometerPerHour(int newSpeedInKilometerPerHour) {
        if (newSpeedInKilometerPerHour >= 0) {
            speedInKilometerPerHour = newSpeedInKilometerPerHour;
        } else 
            if(newSpeedInKilometerPerHour < 0){
            speedInKilometerPerHour = 0;
        }
        System.out.println("Driver speed updated to " + speedInKilometerPerHour + " km/hr" + " successfully!");
        setDriverStanding();
        printDriverDetails();
    }
    
    /**
     * Mutator method which sets the value of the driver standing string based on a check of the speed of the driver in km per hour
     * 
     */
    public void setDriverStanding() {
        if (speedInKilometerPerHour > 80) {
            driverStanding = "big ticket";
            System.out.println("Driver standing updated. Driver will receive a " + driverStanding);
        } else if (speedInKilometerPerHour <= 80 && speedInKilometerPerHour > 60) {
            driverStanding = "small ticket";
            System.out.println("Driver standing updated. Driver will receive a " + driverStanding);
        } else {
            driverStanding = "no ticket";
            System.out.println("Driver standing updated. Driver will receive " + driverStanding);
        }
    }
        
    //Methods for class    
    /**
     * Method that prints all the driver details including name, license number, speed in kilometers per hour and the driver standing
     */
    public void printDriverDetails() {
        System.out.println("Driver Name: " + getDriverName());
        System.out.println("Driver License: " + getDriverLicenseNumber());
        System.out.println("Speed: " + getSpeedInKilometerPerHour() + " K/H");
        System.out.println("Driver Standing: " + getDriverStanding());
    }
}


/**
 * Description of the fields and behaviours(methods) used to describe and interact with a room.
 * 
 * @author Vinay Punwani
 * @version v1.0 Oct 20, 2016
 */
public class Room
{
    // instance variables used by all new room objects
    private double lengthInFeet;
    private double widthInFeet;

    /**
     * Default Constructor for objects of class Room
     */
    public Room()
    {
        // initialise instance variables to default values
        lengthInFeet = 0;
        widthInFeet = 0;
    }

    /**
     * Non-default Constructor for objects of class Room from passed in parameters
     * 
     * @param newLengthInFeet the new supplied room length in feet
     * @param newWidthInFeet the new supplied room width in feet
     */
    public Room(double newLengthInFeet, double newWidthInFeet)
    {
        // initialise instance variables by calling mutators within the class and passing new parameters
        setLengthInFeet(newLengthInFeet);
        setWidthInFeet(newWidthInFeet);
    }
    
    //Accessor methods begin
    /**
     * Method getLengthInFeet which returns the length of the room in feet
     *
     * @return The return value which is the length of the room in feet
     */
    public double getLengthInFeet() {
        return lengthInFeet;
    }
    
    /**
     * Method getWidthInFeet which returns the width of the room in feet
     *
     * @return The return value which is the width of the room in feet
     */
    public double getWidthInFeet() {
        return widthInFeet;
    }
    
    //Mutator methods begin
    /**
     * Method setLengthInFeet which validates and sets the new length of the room in feet from a passed
     * in parameter
     *
     * @param newLengthInFeet A double parameter that represents the length of the room in feet
     */
    public void setLengthInFeet(double newLengthInFeet) {
        if(newLengthInFeet > 0) {
            lengthInFeet = newLengthInFeet;
        } 
    }
    
    /**
     * Method setWidthInFeet which validates and sets the new width of the room in feet from a passed
     * in parameter
     *
     * @param newWidthInFeet A double parameter that represents the width of the room in feet
     */
    public void setWidthInFeet(double newWidthInFeet) {
        if(newWidthInFeet > 0) {
            widthInFeet = newWidthInFeet;
        }
    }
    
    //Other class methods
    /**
     * Method calculateArea Calculates the total area of the room from the length and width variables
     *
     * @return double The return value which is the square footage of the room
     */
    public double calculateArea() {
        return lengthInFeet * widthInFeet;
    }
}

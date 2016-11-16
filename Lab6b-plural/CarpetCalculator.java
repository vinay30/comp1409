
/**
 * Class that describes the fields and methods(behaviours) required to calculate the total cost of a carpet for a room
 * 
 * @author Vinay Punwani
 * @version v1.0 Oct 20, 2016
 */
public class CarpetCalculator
{
    // instance variables used by all objects of this class
    private double pricePerSquareFoot;
    private Room room;

    /**
     * Default Constructor for objects of class CarpetCalculator
     */
    public CarpetCalculator()
    {
        // initialise instance variables to default values
        pricePerSquareFoot = 0.0;
        room = new Room();
    }

    /**
     * Non-default Constructor for objects of class CarpetCalculator from passed in parameters
     * 
     * @param newPricePerSquareFoot the new passed in price of the carpet per square foot of room area
     * @param newRoom the new passed in Room object that also contains various Room fields
     */
    public CarpetCalculator(double newPricePerSquareFoot, Room newRoom)
    {
        // initialise instance variables by calling mutators within the class and passing new parameters
        setPricePerSquareFoot(newPricePerSquareFoot);
        setRoom(newRoom);
    }
    
    //Accessor methods begin
    /**
     * Method getPricePerSquareFoot which returns the price per square foot of the carpet in dollars
     *
     * @return The return value, a double, which is the price per square foot of the carpet in dollars
     */
    public double getPricePerSquareFoot() {
        return pricePerSquareFoot;
    }
    
    /**
     * Method getRoom which returns a Room object containing fields defined in the Room class
     *
     * @return The return value, the Room object
     */
    public Room getRoom() {
        return room;
    }
    
    //Mutator methods begin
    /**
     * Method setPricePerSquareFoot which validates and sets the new price per square foot of the room carpets from
     * a passed in parameter
     *
     * @param newPricePerSquareFoot A parameter, double, that represents the new price per square foot
     */
    public void setPricePerSquareFoot(double newPricePerSquareFoot) {
        if(newPricePerSquareFoot > 0) {
            pricePerSquareFoot = newPricePerSquareFoot;            
        }
    }
    
    /**
     * Method setRoom which validates and assigns a new Room object reference to the room variable from a passed
     * in object parameter
     *
     * @param newRoom A parameter, the Room object instantiated from the Room class
     */
    public void setRoom(Room newRoom) {
        if(newRoom == null) {
            room = new Room();
        } else {
            room = newRoom;
        }
    }
    
    //Other class methods
    /**
     * Method calculateTotalCost which calculates the total cost of the room carpeting from the room area
     * and the price per square foot fields
     *
     * @return The return value which represents the total cost of the room carpet in dollars
     */
    public double calculateTotalCost() {
        return room.calculateArea()*pricePerSquareFoot;
    }
    
    //Use the appropriate units when displaying room dimensions
    /**
     * Method pluralize which returns the plural or non-plural form of the unit used to measure the room, feet or foot
     *
     * @param roomDimension A parameter representing the dimension, length or width, of the room object
     * @return The return value which is feet if the dimension is greater than 1, or foot if the dimension is 1
     */
    public String pluralize(double roomDimension) {
        String units = "";
        
        if(roomDimension > 1) {
            units = "feet.";
        } else {
            units = "foot.";
        }
        
        return units;
    }
    
    //Print the final room calculations
    /**
     * Method printRoomDetails which displays a summary of the room dimensions and carpet costs
     *
     */
    public void printRoomDetails() {
        double roomLength = room.getLengthInFeet();
        double roomWidth = room.getWidthInFeet();
        
        System.out.println("Room length: " + roomLength + " " + pluralize(roomLength));
        System.out.println("Room width: " + roomWidth + " " + pluralize(roomWidth));
        System.out.println("Price per square foot of carpet: $" + pricePerSquareFoot);
        System.out.println("Total cost of carpet: $" + calculateTotalCost());
    }
    
}


/**
 * Class describing the basic properties of a car, including external method calls to
 * track the fuel gauge level
 * 
 * @author Vinay Punwani
 * @version v2.0 Nov 1st, 2016
 */
public class Car
{
    // instance variables for new Car objects
    private String carMake;
    private String carColour;
    private FuelGauge fuelGauge;

    /**
     * Default Constructor for objects of class Car
     */
    public Car()
    {
        // initialise instance variables to default values or objects
        carMake = "";
        carColour = "";
        fuelGauge = new FuelGauge();
    }

    /**
     * Non-default Constructor for objects of class Car
     *
     * @param carMake A parameter holding the new make of the car
     * @param carColour A parameter holding the new car colour
     * @param fuelGauge A parameter holding the initial value passed to the fuel gauge constructor
     * which becomes the initial fuel level
     */
    public Car(String carMake, String carColour,int fuelGauge)
    {
        // initialise instance variables to new parameter values
        setCarMake(carMake);
        setCarColour(carColour);
        setFuelGauge(new FuelGauge(fuelGauge));
    }
    
    //Accessor Methods begin
    /**
     * Method getCarMake which returns the make of the car as a string
     *
     * @return The return value which is the make of the car
     */
    public String getCarMake() {
        return carMake;
    }
    
    /**
     * Method getCarColour which returns the colour of the car as a string
     *
     * @return The return value which is the colour of the car
     */
    public String getCarColour() {
        return carColour;
    }
    
    /**
     * Method getFuelGauge which returns a FuelGauge object representing the car's fuel level
     *
     * @return The return value which is a FuelGauge object containing a field with the current fuel level
     */
    public FuelGauge getFuelGauge() {
        return fuelGauge;
    }
    
    //Mutator methods begin
    /**
     * Method setCarMake which validates and sets a new value for the make of the car
     * from a passed in parameter
     *
     * @param carMake A String parameter holding the new make of the car to be validated
     * and used
     */
    public void setCarMake(String carMake) {
        if(carMake != null) {
            this.carMake = carMake;
        } else if(this.carMake == null) {
            this.carMake = "";
        }
    }
    
    /**
     * Method setCarColour which validates and sets a new value for the colour of the car
     * from a passed in parameter
     *
     * @param carColour A String parameter holding the new colour of the car to be
     * validated and used
     */
    public void setCarColour(String carColour) {
        if(carColour != null) {
            this.carColour = carColour;
        } else if(this.carColour == null) {
            this.carColour = "";
        }
    }
    
    /**
     * Method setFuelGauge which validates and sets a new value for the car's fuel gauge
     * object (and thus fuel level) from a passed in object parameter
     *
     * @param fuelGauge A FuelGauge object parameter holding the details of the car fuel gauge
     */
    public void setFuelGauge(FuelGauge fuelGauge) {
        if(fuelGauge != null) {
            this.fuelGauge = fuelGauge;
        } else if(this.fuelGauge == null) {
            this.fuelGauge = new FuelGauge();
        }
    }   
    
    //Other class methods
    /**
     * Method drive which uses one litre of fuel on each call through an external
     * method that decrements the fuel gauge
     *
     */
    public void drive() {
        fuelGauge.useFuel();
    }
    
    /**
     * Method fillTank which restores one litre of fuel on each call through an external
     * method that increments the fuel gauge
     *
     */
    public void fillTank() {
        fuelGauge.addFuel();
    }
}

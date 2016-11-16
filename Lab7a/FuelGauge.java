
/**
 * This class contains the methods and fields to control the movement of
 * a car's fuel gauge based on initial, min, and max fuel levels.
 * 
 * @author Vinay Punwani
 * @version v2.0 Nov 1st, 2016
 */
public class FuelGauge
{
    //static variables used to define the min and max fuel amounts
    public static final int MIN_FUEL_AMOUNT = 0;
    public static final int MAX_FUEL_AMOUNT = 15;
    
    // instance variables for new objects
    private int amountOfFuelInLitres;

    /**
     * Default Constructor for objects of class FuelGauge
     */
    public FuelGauge()
    {
        // initialise instance variables to default values
        amountOfFuelInLitres = 0;
    }

    /**
     * Non-default Constructor for objects of class FuelGauge
     * 
     * @param amountOfFuelInLitres the initial value of the gauge set when the object
     * is instantiated
     */
    public FuelGauge(int amountOfFuelInLitres)
    {
        setAmountOfFuel(amountOfFuelInLitres);
    }
    
    //Accessor method
    /**
     * Method getAmountOfFuelInLitres which returns the current fuel level on the gauge
     *
     * @return The return value, an int, which is the current fuel level in litres
     */
    public int getAmountOfFuelInLitres() {
        return amountOfFuelInLitres;
    }
    
    //Mutator method
    /**
     * Method setAmountOfFuel which validates and sets a new fuel level on the gauge
     *
     * @param amountOfFuelInLitres A parameter containing the new fuel level in litres
     */
    public void setAmountOfFuel(int amountOfFuelInLitres) {
        if(amountOfFuelInLitres >= MIN_FUEL_AMOUNT && amountOfFuelInLitres <= MAX_FUEL_AMOUNT) {
            this.amountOfFuelInLitres = amountOfFuelInLitres;
        } else if(this.amountOfFuelInLitres < MIN_FUEL_AMOUNT || this.amountOfFuelInLitres > MAX_FUEL_AMOUNT) {
            this.amountOfFuelInLitres = MAX_FUEL_AMOUNT;
        }
    }
    
    /**
     * Method useFuel which uses fuel by decreasing the fuel amount by one litre on each call
     *
     */
    public void useFuel() {
        if(amountOfFuelInLitres == MIN_FUEL_AMOUNT) {
            System.out.println("The tank is empty! The fuel cannot go below 0 litres!");
        } else {
            amountOfFuelInLitres--;
            System.out.println("Fuel Gauge level: " + amountOfFuelInLitres + " litres.");
        }
    }
    
    /**
     * Method addFuel which adds fuel by increasing the fuel amount by one litre on each call
     *
     */
    public void addFuel() {
        if(amountOfFuelInLitres == MAX_FUEL_AMOUNT) {
            System.out.println("Tank is full!");
        } else {
            amountOfFuelInLitres++;
            System.out.println("Fuel Gauge level: " + amountOfFuelInLitres + " litres.");
        }
    }
}

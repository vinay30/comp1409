
/**
 * Class describing information about an item for sale in a store, such as price, description and stock
 * 
 * @author Vinay Punwani
 * @version v2.0 Oct 20, 2016
 */
public class RetailItem
{
    // instance variables for RetailItem class
    private String itemDescription;
    private double itemPriceInCAD;
    private boolean isInDemand;
    private int numberOfUnitsInStock;

    /**
     * Default constructor for objects of class RetailItem, no params
     */
    public RetailItem()
    {
        // initialise instance variables for default constructor to default values
        itemDescription = "";
        itemPriceInCAD = 0.00;
        isInDemand = false;
        numberOfUnitsInStock = 0;
    }

    /**
     * Non-default constructor for objects of class RetailItem, requires params
     * 
     * @param inputItemDescription Short description of retail item for sale
     * @param inputItemPriceInCAD Retail price of item in Canadian dollars
     * @param inputIsInDemand Tells us whether or not the item is in demand, true or false
     * @param inputNumberOfUnitsInStock How many physical units are in stock in our inventory
     * 
     */
    public RetailItem(String inputItemDescription, double inputItemPriceInCAD, boolean inputIsInDemand, int inputNumberOfUnitsInStock)
    {
        // initialise instance variables for non-default constructor with tests for validation
        if (inputItemDescription != null) {
            itemDescription = inputItemDescription;
        } else {
            itemDescription = "";
        }
        
        if (inputItemPriceInCAD >= 0.00) {
             itemPriceInCAD = inputItemPriceInCAD;
        } else {
             itemPriceInCAD = 0.00;
        }
        
        isInDemand = inputIsInDemand;
        
        if (inputNumberOfUnitsInStock >= 0) {
             numberOfUnitsInStock = inputNumberOfUnitsInStock;
        } else {
            numberOfUnitsInStock = 0;
        }
         
    }
    
    //Accessor methods begin - created only the one I needed
    /**
     * Method getItemPriceInCAD which returns the item price in CAD
     *
     * @return The return value which is the item price in CAD, a double
     */
    public double getItemPriceInCAD() {
        return itemPriceInCAD;
    }
}

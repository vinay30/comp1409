import java.text.NumberFormat;
/**
 * Class describing the fields and methods used by a Cash register system to calculate the total price of an item
 * including taxes and to display that information on a receipt
 * 
 * @author Vinay Punwani
 * @version v1.0 Oct 20, 2016
 */
public class CashRegister
{
    // static variable declarations accessible by all objects of this class
    public static final double TAX_RATE = 0.06;
    
    //formatting the receipt prices with the proper currency format
    public static NumberFormat priceWithDecimals = NumberFormat.getCurrencyInstance();
    
    // instance variables required and used by each object
    private RetailItem item;
    private int quantitySold;

    /**
     * Default Constructor for objects of class CashRegister
     * 
     */
    public CashRegister()
    {
        // initialise instance variables to default values
        item = new RetailItem();
        quantitySold = 0;
    }

    /**
     * Non-default Constructor for objects of class CashRegister from passed in parameters
     * 
     * @param newItem the new passed in RetailItem object that contains fields defined in the RetailItem class
     * @param newQuantitySold the new passed in quantity of items sold through the cash register
     */
    public CashRegister(RetailItem newItem, int newQuantitySold)
    {
        // initialise instance variables by calling mutators within the class and passing the new parameters
        setItem(newItem);
        setQuantitySold(newQuantitySold);
    }
    
    //Accessor methods begin
    /**
     * Method getItem which returns an item object from the RetailItem class, with the associated fields
     *
     * @return The return value, the RetailItem object
     */
    public RetailItem getItem() {
        return item;
    }
    
    /**
     * Method getQuantitySold which returns the quantity of items sold through the cash register
     *
     * @return The return value, an int, the number of items sold
     */
    public int getQuantitySold() {
        return quantitySold;
    }
    
    //Mutator methods begin
    /**
     * Method setItem which validates and assigns a new RetailItem object reference to the item variable from a passed
     * in object parameter
     *
     * @param newItem A parameter, the RetailItem object instantiated from the RetailItem class
     */
    public void setItem(RetailItem newItem) {
        if(newItem == null) {
            item = new RetailItem();
        } else {
            item = newItem;
        }
    }
   
    /**
     * Method setQuantitySold which validates and sets the new quantity of items sold through the register from
     * a passed in parameter
     *
     * @param newQuantitySold A parameter, an int, that represents the quantity of items sold
     */
    public void setQuantitySold(int newQuantitySold) {
        if(newQuantitySold > 0) {
            quantitySold = newQuantitySold;
        } else {
            quantitySold = 0;
        }
    }
    
    //Methods begin
    /**
     * Method calculateSubtotal which calculates the subtotal of the cash register transaction by multiplying the
     * quantity of items sold by the item price
     *
     * @return The return value, a double, which is the product of the item quantity sold and the item price
     */
    public double calculateSubtotal() {
        return quantitySold * item.getItemPriceInCAD();
    }
    
    /**
     * Method calculateTax which calculates the tax of a sale by multiplying the subtotal by the tax rate symbolic constant
     *
     * @return The return value, a double, which is the product of the tax rate and the sale subtotal
     */
    public double calculateTax() {
        return calculateSubtotal()*TAX_RATE;
    }
    
    /**
     * Method calculateTotal which calculates the total sale amount through the register by adding the subtotal and the tax
     *
     * @return The return value, a double, the sum of the tax and subtotal from the sale transaction
     */
    public double calculateTotal() {
        return calculateSubtotal() + calculateTax();
    }
    
    /**
     * Method printSalesReceipt which displays a sales receipt on the screen showing the unit price, quantity, subtotal
     * tax amount, and total amount
     * 
     */
    public void printSalesReceipt() {
        System.out.println("Unit Price: " + priceWithDecimals.format(item.getItemPriceInCAD()));
        System.out.println("Quantity: " + quantitySold);
        System.out.println("Subtotal: " + priceWithDecimals.format(calculateSubtotal()));
        System.out.println("Tax amount: " + priceWithDecimals.format(calculateTax()));
        System.out.println("Total: " + priceWithDecimals.format(calculateTotal()));
    }
}

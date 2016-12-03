
/**
 * Class describing the fields and methods of an item of inventory that can be rented, bought or sold in a music store.
 * 
 * @author Vinay Punwani
 * @version v2.0 Dec 2nd, 2016
 */
public class MusicalInstrument
{
    // static variables required by all objects instantiated from the class
    public static final double PROFIT_MARGIN = 0.10;
    public static final double MAX_RENTABLE_FRACTION = 0.50;
    
    // instance variables used by each object
    private String productDescription;
    private String stockCode;
    private int quantityInStock;
    private int quantitySold;
    private double purchasePrice;
    private double sellingPrice;
    private int numberRented;
    
    /**
     * Default Constructor for objects of class MusicalInstrument
     */
    public MusicalInstrument()
    {
        // initialise instance variables to default values
        productDescription = "unknown";
        stockCode = "unknown";
        quantityInStock = 0;
        quantitySold = 0;
        purchasePrice = 0.0;
        sellingPrice = 0.0;
        numberRented = 0;
    }
    
     
    /**
     * Non-default Constructor for objects of class MusicalInstrument
     * 
     * @param newProductDescription A string parameter representing a new description of the instrument
     * @param newStockCode A string parameter representing a new stock code of the instrument
     * @param newPurchasePrice A double parameter representing a new purchase price of the instrument
     * @param newSellingPrice A double parameter representing a new selling price of the instrument
     */
    public MusicalInstrument(String newProductDescription, String newStockCode, double newPurchasePrice, double newSellingPrice)
    {
        // validate and initialise instance variables
        if (newPurchasePrice >= 0) {
            purchasePrice = newPurchasePrice;
        } else {
            purchasePrice = 1;
        }
        
        double minimumSellingPrice = purchasePrice*(1+PROFIT_MARGIN);
        
        if (newSellingPrice < 0 || newSellingPrice < minimumSellingPrice) { //Do I need the first boolean here?
            sellingPrice = minimumSellingPrice;
        } else {
            sellingPrice = newSellingPrice;
        }
        
        quantityInStock = 0;
        quantitySold = 0;
        numberRented = 0;
        
        if(newProductDescription != null) {
            productDescription = newProductDescription;
        } else {
            productDescription = "unknown";
        }
        
        if(newStockCode != null) {
            stockCode = newStockCode;
        } else {
            stockCode = "unknown";
        }
    }
    
    // Accessor methods begin
    /**
     * Method getProductDescription to return the product description field as a string
     *
     * @return String The return value of the productDescription field
     */
    public String getProductDescription() {
        return productDescription;
    }
    
    /**
     * Method getStockCode to return the stockCode field as a string
     *
     * @return String The return value of the stockCode field
     */
    public String getStockCode() {
        return stockCode;
    }
    
    /**
     * Method getQuantityInStock to return the quantity of items currently in stock for a specific instrument
     *
     * @return int The return value of quantityInStock field
     */
    public int getQuantityInStock() {
        return quantityInStock;
    }
    
    /**
     * Method getQuantitySold to return the quantity of inventory sold to customers
     *
     * @return int The return value of the quantitySold field
     */
    public int getQuantitySold() {
        return quantitySold;
    }
    
    /**
     * Method getPurchasePrice to return the purchase price of the item from the manufacturer
     *
     * @return double The return value of the purchasePrice field
     */
    public double getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * Method getSellingPrice to return the selling price of the item sold to a customer
     *
     * @return double The return value of the sellingPrice field
     */
    public double getSellingPrice() {
        return sellingPrice;
    }
    
    /**
     * Method getNumberRented to return the number of instruments rented from the store inventory
     *
     * @return int The return value of the numberRented field
     */
    public int getNumberRented() {
        return numberRented;
    }
    
    //Mutator methods begin
    /**
     * Method setProductDescription which sets a new product description from a passed in string parameter after it is validated
     *
     * @param newProductDescription A parameter containing a string of the new product description
     */
    public void setProductDescription(String newProductDescription) {
        if(newProductDescription != null) {
            productDescription = newProductDescription;
        } else {
            System.out.println("Invalid description. Please enter a valid product description."); //no change to description
        }
    }
    
    /**
     * Method setStockCode which sets a new product stock code from a passed in string parameter after it is validated
     *
     * @param newStockCode A parameter containing a string of the new stock code
     */
    public void setStockCode(String newStockCode) {
        if(newStockCode != null) {
            stockCode = newStockCode;
        } else {
            System.out.println("Invalid stock code. Please enter a valid instrument stock code."); //no change to stock code
        }
    }
    
    /**
     * Method restock which adds stock to the total inventory quantity of the item after the parameter is validated
     *
     * @param stockToAdd An int parameter containing the amount of stock to add
     */
    public void restock(int stockToAdd) {
        if(stockToAdd <= 0) {
            System.out.println("Invalid quantity. Please enter a positive quantity to add to inventory.");
        } else {
            quantityInStock += stockToAdd;
        }
    }
    
    /**
     * Method returnItem which reverses the actions of the add to cart action when called. This is used when a customer removes an item
     * from their cart and increments stock and decrements quantity sold.
     *
     */
    public void returnItem() {
        quantityInStock++;
        quantitySold--;
    }
    
    /**
     * Method sell which reduces stock from the current inventory and increases the quantity of items sold based on the sell parameter
     *
     * @param stockToSell An int parameter containing the number of items to be sold
     */
    public void sell(int stockToSell) {
        if(quantityInStock <= 0) {
            System.out.println("Out of stock. Please add more inventory before selling.");
        } else if(stockToSell <= 0 || stockToSell > quantityInStock) {
            System.out.println("Invalid quantity. Please enter a positive quantity of " + quantityInStock + " or lower.");
        } else {
            quantityInStock -= stockToSell;
            quantitySold += stockToSell;
        }
    }
    
    /**
     * Method setPurchasePrice which accepts a new purchase price parameter and updates the item purchase price after validation
     *
     * @param newPurchasePrice A double parameter containing the new purchase price of the instrument
     */
    public void setPurchasePrice(double newPurchasePrice) {
        if(newPurchasePrice < 0) {
            System.out.println("Invalid purchase price! New purchase price must be $0 or higher.");
        } else {
            purchasePrice = newPurchasePrice;
        }
    }
    
    /**
     * Method setSellingPrice which accepts a new selling price parameter and updates the item selling price after validation
     *
     * @param newSellingPrice A double parameter which contains the new selling price of the instrument
     */
    public void setSellingPrice(double newSellingPrice) {
        double minimumSellingPrice = purchasePrice*(1+PROFIT_MARGIN);
        
        if (newSellingPrice >= 0 && newSellingPrice >= minimumSellingPrice) {
            sellingPrice = newSellingPrice;
            System.out.println("New selling price set to $" + sellingPrice + ".");
        } else {
            System.out.println("Invalid selling price! New selling price must be $" + minimumSellingPrice + " or higher.");
        }   
    }
    
    /**
     * Method setNumberRented which updates the number of instruments currently rented out after the parameter is validated
     *
     * @param newNumberRented An int parameter that represents the total number of instruments rented out
     */
    public void setNumberRented(int newNumberRented) {
        double maxNumberRented = quantityInStock*MAX_RENTABLE_FRACTION;
        
        if(newNumberRented < 0 || newNumberRented > maxNumberRented) {
            System.out.println("Invalid rent quantity! Please enter a positive quantity of " + maxNumberRented + " or lower.");
        } else if(newNumberRented <= maxNumberRented) {
            numberRented = newNumberRented;
        }
    }
    
    //Class Methods begin
    /**
     * Method calcProfit that calculates and returns the profit from the sale of one instrument based on purchase and selling prices
     *
     * @return The return value is the subtraction of the purchase price from the selling price which is a double
     */
    public double calcProfit() {
        return sellingPrice - purchasePrice; //This return value will be equal to the difference between the selling and purchase prices
    }
    
    /**
     * Method calcInventoryValue that calculates and returns the current value of the quantity in stock based on the purchase price
     *
     * @return The return value is the product of the quantity in stock and the purchase price giving the total inventory value
     */
    public double calcInventoryValue() {
        return quantityInStock*purchasePrice; //This return value will be the quantity in stock multiplied by the purchase price
    }
    
    /**
     * Method printDetails which displays all the item information on the screen
     *
     */
    public void printDetails() {
        System.out.println("Description: " + productDescription);
        System.out.println("Stock code: " + stockCode);
        System.out.println("Purchase price: $" + purchasePrice);
        System.out.println("Selling price: $" + sellingPrice);
        System.out.println("Quantity in stock: " + quantityInStock);
        System.out.println("Quantity sold: " + quantitySold);
        System.out.println("Number of instruments rented: " + numberRented);
    }
}

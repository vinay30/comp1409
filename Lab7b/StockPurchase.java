
/**
 * Class describing the information (fields) and behaviour (methods) needed 
 * to buy a certain quantity of a specific stock
 * 
 * @author Vinay Punwani
 * @version v1.0 Nov 1, 2016
 */
public class StockPurchase
{
    // instance variables
    private Stock stock;
    private int numberOfShares;

    /**
     * Default Constructor for objects of class StockPurchase
     */
    public StockPurchase()
    {
        // initialise instance variables to default values
        stock = new Stock();
        numberOfShares = 0;
    }

    /**
     * Non-Default Constructor for objects of class StockPurchase
     *
     * @param stock A parameter containing a new stock object (from Stock class)
     * @param numberOfShares A parameter containing the new number of shares to
     * purchase
     */
    public StockPurchase(Stock stock, int numberOfShares)
    {
        // initialise instance variables to passed in parameters
        setStock(stock);
        setNumberOfShares(numberOfShares);
    }
    
    //Accessor methods begin
    /**
     * Method getStock which returns a Stock object
     *
     * @return The return value of the stock object
     */
    public Stock getStock() {
        return stock;
    }
    
    /**
     * Method getNumberOfShares which returns the number of shares that will be
     * purchased at a specific share price
     *
     * @return The return value is the number of shares that will be purchased
     */
    public int getNumberOfShares() {
        return numberOfShares;
    }
    
    //Mutator methods begin
    /**
     * Method setStock which validates a Stock object parameter and sets the value
     * of the stock field, or instantiates a new Stock object and assigns it to the
     * stock field.
     *
     * @param stock A parameter containing the Stock object to be used
     */
    public void setStock(Stock stock) {
        if(stock != null) {
            this.stock = stock;
        } else if(this.stock == null) { //check existing stock object
            this.stock = new Stock();
        }
    }
    
    /**
     * Method setNumberOfShares which validates and sets the number of shares
     * to be purchased of a stock at the specific share price
     *
     * @param numberOfShares A parameter containing the number of shares
     * to be purchased of a stock
     */
    public void setNumberOfShares(int numberOfShares) {
        if(numberOfShares > 0) {
            this.numberOfShares = numberOfShares;
        } else if(this.numberOfShares <= 0) { //check existing number of shares
            this.numberOfShares = 0;
        }
    }
    
    //Other class methods
    /**
     * Method getTotalCost which calculates and returns the total cost of
     * purchasing a specific number of shares of a particular stock
     *
     * @return The return value is the total cost of buying the stock shares
     */
    public double getTotalCost() {
        return numberOfShares*stock.getSharePrice();
    }
    
    /**
     * Method displayStockDetails which displays the stock info (symbol and price), as
     * well as the total cost of buying the number of shares defined
     *
     */
    public void displayStockDetails() {
        stock.displayStockInfo();
        System.out.println("Total Share Cost: $" + getTotalCost());
    }
}


/**
 * Class describing the methods and fields of a stock that can be purchased
 * 
 * @author Vinay Punwani
 * @version v1.0 Nov 1, 2016
 */
public class Stock
{
    // instance variables
    private String stockSymbol;
    private double sharePrice;

    /**
     * Default Constructor for objects of class Stock
     */
    public Stock()
    {
        // initialise instance variables to default values
        stockSymbol = "";
        sharePrice = 0.0;
    }

    /**
     * Non-Default Constructor for objects of class Stock
     *
     * @param stockSymbol A parameter holding the new stock symbol string
     * @param sharePrice A parameter holding the new stock share price
     */
    public Stock(String stockSymbol, double sharePrice)
    {
        // initialise instance variables to passed in parameters
        setStockSymbol(stockSymbol);
        setSharePrice(sharePrice);
    }
    
    //Accessor methods begin
    /**
     * Method getStockSymbol that returns the stock symbol string
     *
     * @return The return value of the stock symbol as a String
     */
    public String getStockSymbol() {
        return stockSymbol;
    }
    
    /**
     * Method getSharePrice which returns the share price of the stock
     *
     * @return The return value of the share price as a double
     */
    public double getSharePrice() {
        return sharePrice;
    }
    
    //Mutator methods begin
    /**
     * Method setStockSymbol which validates and then sets the value of the stock
     * symbol from a passed in parameter
     *
     * @param stockSymbol A parameter containing the new stock symbol string
     */
    public void setStockSymbol(String stockSymbol) {
        if(stockSymbol != null) {
            this.stockSymbol = stockSymbol;
        } else if(this.stockSymbol == null) { //check existing stock symbol
            this.stockSymbol = "";
        }
    }
    
    /**
     * Method setSharePrice which validates and then sets the value of the share
     * price of the stock from a passed in parameter
     *
     * @param sharePrice A parameter holding the new share price as a double
     */
    public void setSharePrice(double sharePrice) {
        if(sharePrice > 0) {
            this.sharePrice = sharePrice;
        } else if(this.sharePrice <= 0) { //check existing share price
            this.sharePrice = 0;
        }
    }
    
    //Other class methods
    /**
     * Method displayStockInfo which displays the current stock symbol
     * and share price from the object
     *
     */
    public void displayStockInfo() {
        System.out.println("Stock Symbol: " + stockSymbol);
        System.out.println("Share Price: $" + sharePrice);
    }
}

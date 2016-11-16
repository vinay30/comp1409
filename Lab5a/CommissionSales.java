/**
 * Class describing methods and fields used to calculate sales commission based on monthly sales
 * 
 * @author Vinay Punwani
 * @version 1.0 Oct 12, 2016
 */
public class CommissionSales
{
    //static variables referenced by all objects
    public static final double RATE_A = 0.05;
    public static final double RATE_B = 0.10;
    public static final double RATE_C = 0.13;
    public static final double RATE_D = 0.18;
    public static final double RATE_E = 0.22;
    public static final int SALES_DIVISOR = 10000;
    
    //instance variables for each object
    private String salesPersonName;
    private int salesAmountInCAD;
    private double payInCAD;

    /**
     * Default Constructor for objects of class CommissionSales
     */
    public CommissionSales()
    {
        // initialise instance variables to default values
        salesPersonName = "";
        salesAmountInCAD = 0;
        payInCAD = 0.0;
    }

    /**
     * Non-default Constructor for objects of class CommissionSales
     * 
     * @param newSalesPersonName is a string containing the new sales person's name
     * @param newSalesAmountInCAD is an int containing the new total monthly sales of the employee
     */
    public CommissionSales(String newSalesPersonName, int newSalesAmountInCAD)
    {
        // initialise instance variables to new values after validation, or defaults
        if(newSalesPersonName != null) {
            salesPersonName = newSalesPersonName;
        } else if(newSalesPersonName == null) {
            salesPersonName = "";
        }
        
        if(newSalesAmountInCAD > 0) {
            salesAmountInCAD = newSalesAmountInCAD;
        } else if(newSalesAmountInCAD <= 0) {
            salesAmountInCAD = 0;
        }
    }
    
    //Accessor methods begin
    /**
     * Method getSalesPersonName to return the name of the sales person as a string
     *
     * @return String salesPersonName
     */
    public String getSalesPersonName() {
        return salesPersonName;
    }
    
    /**
     * Method getSalesAmountInCAD to return the monthly sales of the sales person
     *
     * @return The return value salesAmountInCAD as an int
     */
    public int getSalesAmountInCAD() {
        return salesAmountInCAD;
    }
    
    /**
     * Method getPayInCAD to return the monthly pay of the sales person based on the total monthly sales
     *
     * @return The return value payInCAD as a double
     */
    public double getPayInCAD() {
        return payInCAD;
    }
    
    //Mutator methods begin    
    /**
     * Method setSalesPersonName to assign a new sales person name from a passed in parameter after validation
     *
     * @param newSalesPersonName A new salesperson name to be validated and assigned
     */
    public void setSalesPersonName(String newSalesPersonName) {
        if(newSalesPersonName != null) {
            salesPersonName = newSalesPersonName;
        } else if(salesPersonName == null) { //checking instance variable not parameter
            salesPersonName = "";
        }
    }
    
    /**
     * Method setSalesAmountInCAD which assigns a new value for sales amount after validation
     *
     * @param newSalesAmountInCAD the sales amount parameter passed in to be validated and assigned
     */
    public void setSalesAmountInCAD(int newSalesAmountInCAD) {
        if(newSalesAmountInCAD > 0) {
            salesAmountInCAD = newSalesAmountInCAD;
        } else {
            System.out.println("Invalid sales amount. Please enter a positive sales amount!");
        }
    }
    
    /**
     * Method calculatePay which calculates the total commission to be paid to the employee based
     * on the total monthly sales and commission rate.
     * 
     * @return payInCAD which is the total commission earned by the salesperson for the month
     */
    public double calculatePay() {
        payInCAD = 0;
        double commissionRate = 0.0;
        
        switch(salesAmountInCAD / SALES_DIVISOR) {
            case 1: 
            commissionRate = RATE_A;
            break;
            case 2: 
            commissionRate = RATE_B;
            break;
            case 3: 
            commissionRate = RATE_C;
            break;
            case 4: 
            commissionRate = RATE_D;
            break;
            case 5: 
            commissionRate = RATE_E;
            break;
            default: 
            commissionRate = 0.0;
            System.out.println("Invalid sales amount! Please enter a sales amount between 0 and 59999");
            break;
        }
        
        payInCAD = salesAmountInCAD * commissionRate;
        return payInCAD;
    }
    
    /**
     * Method displayDetails used to display the sales person's name and pay in Canadian dollars
     *
     */
    public void displayDetails() {
        System.out.println("Salesperson Name: " + salesPersonName);
        System.out.println("Salesperson Pay: " + payInCAD);
    }
}

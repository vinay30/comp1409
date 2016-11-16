
/**
 * Class describing the variables and behaviours used to calculate monthly bank charges
 * 
 * @author Vinay Punwani
 * @version 1.1 Oct 8, 2016
 */
public class BankCharges
{
    // static variables for all objects to be used for symbolic constants
    public static final double FIRST_CHEQUES_CHARGE = 0.10;
    public static final double SECOND_CHEQUES_CHARGE = 0.08;
    public static final double THIRD_CHEQUES_CHARGE = 0.06;
    public static final double FOURTH_CHEQUES_CHARGE = 0.04;
    public static final int BANK_CHARGE = 10;
    public static final int BANK_LOW_BALANCE_CHARGE = 15;
    public static final int LOW_BALANCE_LIMIT = 400;
    public static final int FIRST_CHEQUES_LEVEL = 20;
    public static final int SECOND_CHEQUES_LEVEL = 40;
    public static final int THIRD_CHEQUES_LEVEL = 60;
    
    // instance variables of class for new objects
    private String clientName;
    private double endingBalance;
    private int numberOfCheques;
    
    
    /**
     * Default Constructor for objects of class BankCharges
     */
    public BankCharges()
    {
        // initialise instance variables to default values
        clientName = "";
        endingBalance = 0.0;
        numberOfCheques = 0;
    }
    
    /**
     * Non-default Constructor for objects of class BankCharges
     * 
     * @param cName new customer name holding the account
     * @param cEndingBalance ending balance of the account
     * @param cNumberOfCheques number of cheques drawn on the account
     */
    public BankCharges(String cName, double cEndingBalance, int cNumberOfCheques)
    {
        // initialise instance variables after validation
        if(cName != null) {
            clientName = cName;
        } else {
            clientName = "";
        }
        
        if(cEndingBalance > 0) {
            endingBalance = cEndingBalance;
        } else {
            endingBalance = 0;
        }
        
        if(cNumberOfCheques > 0) {
            numberOfCheques = cNumberOfCheques;
        } else {
            numberOfCheques = 0;
        }       
    }

    //Accessor methods begin
    /**
     * Accessor method to get the client name
     * 
     * @return the client's name as a String
     */
    public String getClientName() {
        return clientName;
    }
    
    /**
     * Accessor method to get the monthly ending balance of the account
     * 
     * @return the ending balance
     */
    public double getEndingBalance() {
        return endingBalance;
    }
    
    /**
     * Accessor method to get the number of cheques used for the month
     * 
     * @return the number of cheques used
     */
    public int getNumberOfCheques() {
        return numberOfCheques;
    }
  
    //Mutator methods begin
    /**
     * Mutator Method setClientName which sets a new client name from a passed in value after validation
     *
     * @param cName New passed in client name
     */
    public void setClientName(String cName) {
        if(cName != null) {
            clientName = cName;
        } else {
            clientName = "";
        }
    }
    
    /**
     * Mutator Method setEndingBalance which sets a new account balance from a passed in value after validation
     *
     * @param cEndingBalance the new passed in ending account balance
     */
    public void setEndingBalance(double cEndingBalance) {
        if(cEndingBalance > 0) {
            endingBalance = cEndingBalance;
        } else {
            endingBalance = 0;
        }
    }
    
    /**
     * Mutator Method setNumberOfCheques which sets a new number of cheques from a passed in value after validation
     *
     * @param cNumberOfCheques A parameter that defines the new number of cheques
     */
    public void setNumberOfCheques(int cNumberOfCheques) {
        if(cNumberOfCheques > 0) {
            numberOfCheques = cNumberOfCheques;
        } else {
            numberOfCheques = 0;
        } 
    }
    
    /**
     * Method to calculate the monthly service fees of a bank account
     * 
     * @return bankServiceFees which is the sum of all account service fees
     */
    public double calculateBankServiceFees() {
        double bankServiceFees = 0;
        bankServiceFees += BANK_CHARGE;
        
        if(numberOfCheques < FIRST_CHEQUES_LEVEL) {
            bankServiceFees += FIRST_CHEQUES_CHARGE*numberOfCheques;
        } else if(numberOfCheques >= FIRST_CHEQUES_LEVEL && numberOfCheques < SECOND_CHEQUES_LEVEL) {
            bankServiceFees += SECOND_CHEQUES_CHARGE*numberOfCheques;
        } else if(numberOfCheques >= SECOND_CHEQUES_LEVEL && numberOfCheques < THIRD_CHEQUES_LEVEL) {
            bankServiceFees += THIRD_CHEQUES_CHARGE*numberOfCheques;
        } else if(numberOfCheques >= THIRD_CHEQUES_LEVEL) {
            bankServiceFees += FOURTH_CHEQUES_CHARGE*numberOfCheques;
        }
        
        if(endingBalance < LOW_BALANCE_LIMIT) {
            bankServiceFees += BANK_LOW_BALANCE_CHARGE;
        }
        
        endingBalance = endingBalance - bankServiceFees;
        
        return bankServiceFees;
    }
}


/**
 * Class describing the important information and methods required for a store to rent instruments using an agreement
 * 
 * @author Vinay Punwani
 * @version v2.0 Dec 2nd, 2016
 */
public class RentalAgreement
{
    // static variables
    public static final int MINIMUM_RENTAL_DURATION = 1;
    public static final int MAXIMUM_RENTAL_DURATION = 62;
    public static final int LENGTH_OF_MONTH = 31;
    public static final int LENGTH_OF_YEAR = 12;
    private static int OBJECT_NUMBER = 0;
    
    // instance variables
    private Customer customer;
    private Date rentalDate;
    private Date estimatedRentEndDate;
    private MusicalInstrument instrumentRented;
    private double rentalFeePerDay;
    private int numberOfDaysRented;
    private String agreementIDNumber;

    /**
     * Constructor for objects of class RentalAgreement
     */
    public RentalAgreement()
    {
        // initialise instance variables
        customer = new Customer();
        rentalDate = new Date();
        estimatedRentEndDate = new Date();
        instrumentRented = new MusicalInstrument();
        rentalFeePerDay = 0.0;
        numberOfDaysRented = 0;
        agreementIDNumber = createIDNumber();
    }

     /**
     * Non-default Constructor for objects of class RentalAgreement
     *
     * @param customer A parameter containing the customer object
     * @param rentalDate A parameter containing the rental date object
     * @param instrumentRented A parameter containing the object describing the musical instrument to be rented
     * @param rentalFeePerDay A parameter containing the instrument daily rental fee
     * @param numberOfDaysRented A parameter containing the number of days requested to rent the instrument by the customer
     */
    public RentalAgreement(Customer customer, Date rentalDate, MusicalInstrument instrumentRented, double rentalFeePerDay, int numberOfDaysRented)
    {
        // initialise instance variables
        setCustomer(customer);
        setRentalDate(rentalDate);
        setNumberOfDaysRented(numberOfDaysRented);
        calculateEstimatedReturnDate();
        setInstrumentRented(instrumentRented);
        setRentalFeePerDay(rentalFeePerDay);
        agreementIDNumber = createIDNumber();
    }
    
    //Accessor methods begin
    /**
     * Method getCustomer which returns the customer object
     *
     * @return The return value of the customer object
     */
    public Customer getCustomer() {
        return customer;
    }
    
    /**
     * Method getRentalDate which returns the date object containing the rental date
     *
     * @return The return value which is the date the customer requested the instrument
     */
    public Date getRentalDate() {
        return rentalDate;
    }
    
    /**
     * Method getEstimatedRentEndDate which returns the date the customer is required to return the instrument
     *
     * @return The return value which is the date object containing the estimated rent end date
     */
    public Date getEstimatedRentEndDate() {
        return estimatedRentEndDate;
    }
    
    /**
     * Method getInstrumentRented which returns the musical instrument object which the customer is renting
     *
     * @return The return value is the instance of the musical instrument object
     */
    public MusicalInstrument getInstrumentRented() {
        return instrumentRented;
    }
    
    /**
     * Method getRentalFeePerDay which returns the daily rental fee of the musical instrument
     *
     * @return The return value which is the rental fee per day of the instrument, a double
     */
    public double getRentalFeePerDay() {
        return rentalFeePerDay;
    }
    
    /**
     * Method getNumberOfDaysRented which returns the number of days the customer is renting the instrument
     *
     * @return The return value is an int of the number of days the customer is renting the instrument
     */
    public int getNumberOfDaysRented() {
        return numberOfDaysRented;
    }
    
    /**
     * Method getAgreementIDNumber which returns the unique identification number assigned to each new rental agreement
     *
     * @return The return value String which is the unique agreement ID number
     */
    public String getAgreementIDNumber() {
        return agreementIDNumber;
    }
    
    //Mutator methods begin
    /**
     * Method setCustomer which adds a new customer to the instrument rental agreement, the customer renting the instrument
     *
     * @param customer A parameter which is an instance of the customer object to be added to the new agreement
     */
    public void setCustomer(Customer customer) {
        if(customer != null) {
            this.customer = customer;
        } else if(this.customer == null) {
            this.customer = new Customer();
        }
    }
    
    /**
     * Method setRentalDate which sets a start date for the instrument rental in the rental agreement
     *
     * @param rentalDate A parameter which is the new rental date, an instance of the date object for the agreement
     */
    public void setRentalDate(Date rentalDate) {
        if(rentalDate != null) {
            this.rentalDate = rentalDate;
        } else if(this.rentalDate == null) {
            this.rentalDate = new Date();
        }
    }
    
    /**
     * Method setInstrumentRented which defines which instrument is being rented within the rental agreement
     *
     * @param instrumentRented A parameter which is an instance of the musical instrument object and is added to each new rental agreement
     */
    public void setInstrumentRented(MusicalInstrument instrumentRented) {
        if(instrumentRented != null) {
            this.instrumentRented = instrumentRented;
        } else if(this.instrumentRented == null) {
            this.instrumentRented = new MusicalInstrument();
        }
    }
    
    /**
     * Method setRentalFeePerDay which sets the daily rental fee the customer must pay in the agreement for the instrument
     *
     * @param rentalFeePerDay A parameter containing the daily rental fee of the instrument
     */
    public void setRentalFeePerDay(double rentalFeePerDay) {
        if(rentalFeePerDay > 0) {
            this.rentalFeePerDay = rentalFeePerDay;
        } else if(this.rentalFeePerDay <= 0) {
            this.rentalFeePerDay = 0;
        }
    }
    
    /**
     * Method setNumberOfDaysRented which sets the number of days the customer will be renting the instrument in the agreement
     *
     * @param numberOfDaysRented A parameter which is an int, that holds the number of days the instrument will be rented
     */
    public void setNumberOfDaysRented(int numberOfDaysRented) {
        if(numberOfDaysRented >= MINIMUM_RENTAL_DURATION && numberOfDaysRented <= MAXIMUM_RENTAL_DURATION) {
            this.numberOfDaysRented = numberOfDaysRented;
        } else if(this.numberOfDaysRented < MINIMUM_RENTAL_DURATION || this.numberOfDaysRented > MAXIMUM_RENTAL_DURATION) {
            this.numberOfDaysRented = 0;
        }
    }
    
    /**
     * Method calculateEstimatedReturnDate which calculates the estimated rental end date, which is the date the instrument should be returned
     *
     */
    private void calculateEstimatedReturnDate() {
        int rentDay = rentalDate.getDay(); 
        int rentMonth = rentalDate.getMonth(); 
        int rentYear = rentalDate.getYear();
        int newMonth = rentMonth;
        int newDay = rentDay + numberOfDaysRented;
        
        if(newDay > LENGTH_OF_MONTH) {
            newDay %= LENGTH_OF_MONTH;
            newMonth = ((LENGTH_OF_MONTH*rentMonth + rentDay + numberOfDaysRented) / LENGTH_OF_MONTH);
        }
        
        if(newMonth > LENGTH_OF_YEAR) {
            newMonth %= LENGTH_OF_YEAR;
            rentYear++;
        }
        
        estimatedRentEndDate = new Date(rentYear, newMonth, newDay);
    }
    
    /**
     * Method calculateTotalRentalFee which calculates the total rental fee based on the number of days rented and the daily fee
     *
     * @return The return value which is a product of the daily rental fee and the number of days rented
     */
    public double calculateTotalRentalFee() {
        return rentalFeePerDay * numberOfDaysRented;
    }
    
    /**
     * Method displayRentalAgreement which displays all the important information of the instrument rental agreement
     *
     */
    public void displayRentalAgreement() {
        System.out.println("Customer: " + customer.getCustomerName());
        System.out.println("Rental Agreement ID Number: " + agreementIDNumber);
        System.out.println("Rental date: " + rentalDate.getDate());
        System.out.println("Instrument rented: " + instrumentRented.getProductDescription());
        System.out.println("Fee per day: " + currency(rentalFeePerDay));
        System.out.println("Number of days rented: " + numberOfDaysRented);
        System.out.println("Total rental fee for this instrument: " + currency(calculateTotalRentalFee()));
    }
    
    /**
     * Method createIDNumber which creates a unique identification number for each new instrument rental agreement so they can be better
     * organized by the store
     *
     * @return The return value which is a string containing the unique ID of the agreement
     */
    private String createIDNumber() {
        OBJECT_NUMBER++;
        return "VAN" + String.format("%03d", OBJECT_NUMBER);
    }
    
    /**
     * Method currency which takes a double and returns a string by adding a currency symbol to the front of the amount
     *
     * @param amount A parameter which is required to be displayed as a currency amount
     * @return The return value is a string that shows the amount with a dollar sign
     */
    private String currency(double amount) {
        return "$" + amount;
    }
    
    /**
     * Method main which executes once the program starts
     * 
     * @param the various possible arguments for the main method
     *
     */
    public static void main(String args[]) {
//         MusicalInstrument instrument1 = new MusicalInstrument();
//         instrument1.printDetails();
//         Customer customer1 = new Customer(null, null, "", "", "");
//         customer1.printDetails();
//         Customer customer2 = new Customer("jOhN", "sMiTh", "1234567891234567", "123 BCIT St, Burnaby", "1234567890");
//         customer2.printDetails();
//         Date date1 = new Date(1899, 13, 32);
//         date1.displayDate();
//         Date rentDate = new Date(2015, 9, 15);
//         rentDate.displayDate();
//         RentalAgreement rentalAgreement1 = new RentalAgreement(customer2, rentDate, instrument1, 30, 30);
//         System.out.println("Estimated Rental End Date: " + rentalAgreement1.estimatedRentEndDate.getDate());
        
        //New code for assignment 3
        Customer customer3 = new Customer();
        MusicalInstrument instrument2 = new MusicalInstrument("Red electric guitar", "RGE333", 1999, 2499);
        Date rentDateGuitar = new Date(2016, 11, 24);
        RentalAgreement rentalAgreement2 = new RentalAgreement(customer3, rentDateGuitar, instrument2, 35, 15);
        instrument2.restock(5); //Add 5 red guitars to stock
        MusicalInstrument instrument3 = new MusicalInstrument("Green electric guitar", "GGE999", 999, 1499);
        instrument3.restock(5); //Add 5 green guitars to stock
        
        //Create shopping cart object
        ShoppingCart myCart = new ShoppingCart();
        
        myCart.addToPurchaseCart(instrument2, 3); //Add 3 red guitars to purchase cart
        myCart.addToPurchaseCart(instrument3, 2); //Add 2 green guitars to purchase cart
        myCart.addToRentalCart(rentalAgreement2); //Add red guitar rental agreement to cart
        
        myCart.viewShoppingCart();
        
        myCart.editShoppingCart(null); //Calling editShoppingCart with null
        myCart.editShoppingCart("blue electric guitar"); //Calling editShoppingCart with an instrument that is not in cart
        myCart.editShoppingCart("RED electric GUITAR"); //Calling editShoppingCart with an instrument that is in cart
    }
}


/**
 * Class describing all the information required to create a customer file in the store
 * 
 * @author Vinay Punwani
 * @version v1.0 Nov 15th, 2016
 */
public class Customer
{
    // static variables
    public static final int MIN_STRING_LENGTH = 1;
    public static final int MIN_PHONE_LENGTH = 10;
    public static final int MIN_CARD_LENGTH = 16;
    
    // instance variables
    private String firstName;
    private String lastName;
    private String creditCardNumber;
    private String address;
    private String phoneNumber;

    /**
     * Default Constructor for objects of class Customer
     */
    public Customer()
    {
        // initialise instance variables
        firstName = "";
        lastName = "";
        creditCardNumber = "";
        address = "";
        phoneNumber = "";
    }
    
    /**
     * Non-default Constructor for objects of class Customer
     *
     * @param firstName A parameter containing the customer's first name
     * @param lastName A parameter containing the customer's last name
     * @param creditCardNumber A parameter containing the customer's credit card number
     * @param address A parameter holding the customer's address
     * @param phoneNumber A parameter holding the customer's phone number
     */
    public Customer(String firstName, String lastName, String creditCardNumber, String address, String phoneNumber)
    {
        // initialise instance variables
        setFirstName(firstName);
        setLastName(lastName);
        setCreditCardNumber(creditCardNumber);
        setAddress(address);
        setPhoneNumber(phoneNumber);
    }

    //Accessor methods begin
    /**
     * Method getFirstName which returns the first name of the customer
     *
     * @return The return value which is the customer's first name
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Method getLastName which returns the last name of the customer
     *
     * @return The return value which is the customer's last name
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Method getCreditCardNumber which returns the credit card number of the customer
     *
     * @return The return value which is the customer's credit card number as a string
     */
    public String getCreditCardNumber() {
        return creditCardNumber;
    }
    
    /**
     * Method getAddress which returns the address of the customer
     *
     * @return The return value which is the address of the customer
     */
    public String getAddress() {
        return address;
    }
    
    /**
     * Method getPhoneNumber which returns the phone number of the customer
     *
     * @return The return value which is a string of the customer's phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    //Mutator methods being
    /**
     * Method setFirstName which updates or creates the customer's first name
     *
     * @param firstName A parameter containing the new customer's first name
     */
    public void setFirstName(String firstName) {
        if(firstName != null && firstName.length() >= MIN_STRING_LENGTH) {
            this.firstName = stringFormatter(firstName);
        } else if(this.firstName == null) {
            this.firstName = "unknown";
        }        
    }
    
    /**
     * Method setLastName which updates or creates the customer's last name
     *
     * @param lastName A parameter containing the new customer's last name
     */
    public void setLastName(String lastName) {
        if(lastName != null && lastName.length() >= MIN_STRING_LENGTH) {
            this.lastName = stringFormatter(lastName);
        } else if(this.lastName == null) {
            this.lastName = "unknown";
        }        
    }
    
    /**
     * Method setCreditCardNumber which updates or creates the customer's credit card number
     *
     * @param creditCardNumber A parameter containing the new customer's credit card number
     */
    public void setCreditCardNumber(String creditCardNumber) {
        if(creditCardNumber != null && creditCardNumber.length() >= MIN_CARD_LENGTH) {
            this.creditCardNumber = creditCardNumber;
        } else if(this.creditCardNumber == null) {
            this.creditCardNumber = "unknown";
        } 
    }
    
    /**
     * Method setAddress which updates or creates the customer's address
     *
     * @param address A parameter containing the new customer's address
     */
    public void setAddress(String address) {
        if(address != null && address.length() >= MIN_STRING_LENGTH) {
            this.address = address;
        } else if(this.address == null) {
            this.address = "unknown";
        }        
    }
    
    /**
     * Method setPhoneNumber which updates or creates the customer's phone number
     *
     * @param phoneNumber A parameter containing the new customer's phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber != null && phoneNumber.length() >= MIN_PHONE_LENGTH) {
            this.phoneNumber = phoneNumber;
        } else if(this.phoneNumber == null) {
            this.phoneNumber = "unknown";
        } 
    }
    
    //Other class methods    
    //Method to properly format the string
    /**
     * Method stringFormatter which takes an unformatted string and capitalizes the first letter, and sets the remaining letters
     * to lower case, then returns the newly formatted string
     *
     * @param unformattedString A parameter which needs to be formatted containing customer information such as a name
     * @return The return value which is a formatted string such as a customer name
     */
    public String stringFormatter(String unformattedString) {
        String firstLetterOfString = unformattedString.toUpperCase().substring(0, 1);
        String remainderOfString = unformattedString.toLowerCase().substring(1);
        return firstLetterOfString + remainderOfString;
    }
    
    /**
     * Method getCustomerName which returns the full customer name from the instance and properly formats it for display
     *
     * @return The return value which is the concatenation of the first and last customer name with a space
     */
    public String getCustomerName() {
        return firstName + " " + lastName;
    }
    
    /**
     * Method printDetails which prints all relevant customer information from the customer file
     *
     */
    public void printDetails() {
        System.out.println("Customer name: " + firstName + " " + lastName);
        System.out.println("Address: " + address);
        System.out.println("Phone number: " + phoneNumber);
        System.out.println("Credit Card Number: " + creditCardNumber);
    }
}

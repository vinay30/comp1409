import java.util.ArrayList;
import java.util.Iterator;
/**
 * Describes the methods and fields used to control the shopping cart of a customer, and keeps a list of whether they are buying or renting items.
 * 
 * @author Vinay Punwani
 * @version v1.0 Dec 2nd, 2016
 */
public class ShoppingCart
{
    // instance variables
    private ArrayList<MusicalInstrument> purchasedItems;
    private ArrayList<RentalAgreement> rentedItems;

    /**
     * Constructor for objects of class ShoppingCart
     */
    public ShoppingCart()
    {
        // initialise instance variables
        purchasedItems = new ArrayList<MusicalInstrument>();
        rentedItems = new ArrayList<RentalAgreement>();
    }

    //Accessor methods begin
    /**
     * Method getPurchasedItems which returns an arraylist of the musical instrument items purchased by the customer
     *
     * @return The return value which is an array list of musical instrument objects currently in the cart for purchase
     */
    public ArrayList<MusicalInstrument> getPurchasedItems() {
        return purchasedItems;
    }
    
    /**
     * Method getRentedItems which returns an array list of the rental agreements initiated by the customer
     *
     * @return The return value which is an a array list of rental agreements which represent the rental of instruments
     */
    public ArrayList<RentalAgreement> getRentedItems() {
        return rentedItems;
    }
    
    /**
     * Method addToPurchaseCart which adds a specified musical instrument at a specified quantity to the purchase cart
     *
     * @param instrument A parameter containing the musical instrument object to be added to the purchase cart
     * @param quantity A parameter containing the desired quantity of the instrument to add to the purchase cart, an int
     */
    public void addToPurchaseCart(MusicalInstrument instrument, int quantity) {
        System.out.println("Attempting to add items to your cart...");        
        boolean isValid;
        int quantityInStock;
        
        if(instrument != null) {
            quantityInStock = instrument.getQuantityInStock();
            isValid = true;
        } else {
            System.out.println("Invalid instrument! Please choose another instrument.");
            return;
        }
        
        if(isValid && quantity > 0 && quantity <= quantityInStock) {
            for(int index = 0; index < quantity; index++) {
                purchasedItems.add(instrument);                
            }
            System.out.println("Success! "+ quantity + " items added to your cart and removed from store inventory.");
            instrument.sell(quantity);
        } else {
            System.out.println("Invalid purchase quantity! Quantity must be " + quantityInStock + " or lower.");
        }
        System.out.println();
    }
    
    /**
     * Method addToRentalCart which adds a specified rental agreement describing the rental of a specific musical instrument to the rental cart
     *
     * @param agreement A parameter which contains the rental agreement object which specifies the instrument the customer wishes to rent
     */
    public void addToRentalCart(RentalAgreement agreement) {
        System.out.println("Attempting to add a rental agreement to your cart...");
        if(agreement != null) {
            rentedItems.add(agreement);
            System.out.println("Success! The " + agreement.getInstrumentRented().getProductDescription().toUpperCase() + " rental agreement has been added to your cart!");            
        } else {
            System.out.println("Invalid rental agreement! Please try another agreement.");
        }
        System.out.println();
    }
    
    /**
     * Method editShoppingCart which searches the shopping cart for a specific instrument description and removes the items from the cart
     * which match that input description. Also updates stock and sold quantities
     *
     * @param instrumentDescription A parameter string containing the description of the instrument to search
     */
    public void editShoppingCart(String instrumentDescription) {
        System.out.print("Searching shopping cart for...");
        if(instrumentDescription != null) {
            System.out.println(instrumentDescription);
            Iterator<MusicalInstrument> iter = purchasedItems.iterator();
            int removed = 0;
            
            while(iter.hasNext()) {
                MusicalInstrument currentInstrument = iter.next();
                if(currentInstrument.getProductDescription().equalsIgnoreCase(instrumentDescription)) {
                    iter.remove();
                    removed++;
                    currentInstrument.returnItem(); //updating stock and sold quantities
                }
            }  
            
            if(removed == 0) {
                System.out.println("An instrument with that description was not found in your cart!"+ "\n");                
            } else {                
                System.out.println(removed + " item(s) found and removed from your cart!" + "\n");
                System.out.println("Updated cart summary:".toUpperCase());
                viewShoppingCart(); //View updated cart after making changes
            }            
        } else {
            System.out.println("\n" + "Invalid description entered! Try entering a new description." + "\n");    
        }
    }
    
    /**
     * Method viewShoppingCart which displays a summary of all purchased and rented items in the shopping cart. Each item is listed with a price and
     * a total for purchased items. Each rental item is also listed with a total rental fee per agreement and a total for all agreements
     *
     */
    public void viewShoppingCart() {
        if(purchasedItems.size() == 0) {
            System.out.println("Your cart is currently empty.");
        } else {
            double purchasedTotal = 0.0;
            double rentedTotal = 0.0;
        
            System.out.println("You are purchasing the following items:");
            int cartItem = 1;
            for(MusicalInstrument currentInstrument: purchasedItems) {
                double currentPrice = currentInstrument.getSellingPrice();
                System.out.println(cartItem + ". " + currentInstrument.getProductDescription() + " $" + currentPrice);
                purchasedTotal += currentPrice;
                cartItem++;
            }
            System.out.println("\n" + "   TOTAL: $" + purchasedTotal + "\n");
            
            System.out.println("You have the following Rental Agreements:");
            for(RentalAgreement currentAgreement: rentedItems) {
                double currentFee = currentAgreement.calculateTotalRentalFee();            
                currentAgreement.displayRentalAgreement();
                rentedTotal += currentFee;
                System.out.println();
            }
            System.out.println("Total rental fee for all instruments: $" + rentedTotal + "\n");
        }
    }
}

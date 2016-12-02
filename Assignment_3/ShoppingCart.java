import java.util.ArrayList;
import java.util.Iterator;
/**
 * Write a description of class ShoppingCart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShoppingCart
{
    // instance variables - replace the example below with your own
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
    public ArrayList<MusicalInstrument> getPurchasedItems() {
        return purchasedItems;
    }
    
    public ArrayList<RentalAgreement> getRentedItems() {
        return rentedItems;
    }
    
    public void addToPurchaseCart(MusicalInstrument instrument, int quantity) {
        int quantityInStock = instrument.getQuantityInStock();
        boolean isValid;
        
        if(instrument != null) {
            System.out.println("Attempting to add items to your cart...");
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
                    currentInstrument.returnItem();
                }
            }  
            
            if(removed == 0) {
                System.out.println("An instrument with that description was not found in your cart!"+ "\n");                
            } else {                
                System.out.println(removed + " item(s) found and removed from your cart!" + "\n");
                System.out.println("Updated cart summary:".toUpperCase());
                viewShoppingCart();
            }            
        } else {
            System.out.println("\n" + "Invalid description entered! Try entering a new description." + "\n");    
        }
    }
    
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

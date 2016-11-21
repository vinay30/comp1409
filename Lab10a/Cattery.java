import java.util.ArrayList;
/**
 * Class describing the fields and methods required to operate a cat shelter business with
 * a list of cats (cat objects) and a business name.
 * 
 * @author Vinay Punwani
 * @version v1.0 Nov 20th, 2016
 */
public class Cattery
{
    // instance variables
    private ArrayList<Cat> cats;
    private String businessName;

    /**
     * Default Constructor for objects of class Cattery
     */
    public Cattery()
    {
        // initialise instance variables to default values
        cats = new ArrayList<Cat>();
        businessName = "";
    }

    /**
     * Non-default Constructor for objects of class Cattery
     *
     * @param businessName A parameter containing the new business name of the cattery
     */
    public Cattery(String businessName)
    {
        // initialise instance variables using passed in parameters
        cats = new ArrayList<Cat>();
        setBusinessName(businessName);
    }
    
    //Accessor methods
    /**
     * Method getBusinessName which returns the business name of the cattery
     *
     * @return The return value which is a string of the business name of the cattery
     */
    public String getBusinessName() {
        return businessName;
    }
    
    //Mutator methods
    /**
     * Method setBusinessName which takes a new business name parameter, then validates it and sets the
     * business name of the cattery using the parameter.
     * If the business name fails validation, an error message is displayed
     *
     * @param businessName A parameter containing the new business name
     */
    public void setBusinessName(String businessName) {
        if(businessName != null) {
            this.businessName = businessName;
        } else if(this.businessName == null) {
            this.businessName = "";
        } else {
            System.out.println("Invalid parameter! Business name not updated.");
        }
    }
    
    //Arraylist methods
    /**
     * Method addCat which validates the passed in cat object, then adds it to the end of the cats arraylist
     * If the cat object fails validation, an error message is displayed
     *
     * @param newCat A parameter containing a cat object to be added to the cats arraylist
     */
    public void addCat(Cat newCat) {
        System.out.println("Attempting to add object to ArrayList...");
        if(newCat != null) {
            cats.add(newCat);
            System.out.println("Success! " + newCat.getName() + " added.");
        } else {
            System.out.println("Invalid object! Please try adding a different object.");
        }
        System.out.println();
    }
    
    /**
     * Method getCat which uses a passed in parameter containing an arraylist index to retrieve the object
     * at the specified index from the cats arraylist. The parameter is validated before being used.
     * If the index in the parameter fails validation, an error message is displayed
     *
     * @param catIndex A parameter containing the index of the cats arraylist
     */
    public void getCat(int catIndex) {
        System.out.println("Attempting to get details of object at index " + catIndex + " from ArrayList...");
        if(catIndex >= 0 && catIndex < cats.size()) {
            System.out.println("Object at index " + catIndex + " details:");
            cats.get(catIndex).printDetails();
        } else {
            System.out.println("Invalid arraylist index! Please enter an index value from 0 to " + (cats.size()-1) + ".");
        }
        System.out.println();
    }
    
    /**
     * Method removeCat which uses a passed in parameter containing an arraylist index to remove the object
     * at the specified index from the cats arraylist. The parameter is validated before being used.
     * If the index in the parameter fails validation, an error message is displayed
     *
     * @param catIndex A parameter containing the index of the cats arraylist
     */
    public void removeCat(int catIndex) {
        System.out.println("Attempting to remove object at index " + catIndex + " from ArrayList...");
        if(catIndex >= 0 && catIndex < cats.size()) {
            cats.remove(catIndex);
            System.out.println("Success! Object at index " + catIndex + " removed.");
        } else {
            System.out.println("Invalid arraylist index! Please enter an index value from 0 to " + (cats.size()-1) + ".");
        }
        System.out.println();
    }
    
    /**
     * Method displayAllCats which iterates through each object in the cats arraylist and displays
     * each cat name on the screen. In this way, we see a list of all cat names in the cattery.
     *
     */
    public void displayAllCats() {
        System.out.println("All current cattery cat names:");
        for(Cat currentCat: cats) {
            System.out.println("Cat name: " + currentCat.getName());
        }
        System.out.println();
    }
    
    /**
     * Method main which contains all statements that should be evaluated when the program is first run
     *
     * @param args A parameter containing arguments for the main method code
     */
    public static void main(String args[]) {
        Cat cat1 = new Cat("Garfield", 1991, 21);
        Cat cat2 = new Cat("Furball", 1992, 22);
        Cat cat3 = new Cat("Fang", 1993, 23);
        
        Cattery cattery1 = new Cattery("Puss In Boots");
        
        //Adding three cats
        cattery1.addCat(cat1);        
        cattery1.addCat(cat2);        
        cattery1.addCat(cat3);
                
        cattery1.getCat(4); //invalid index produces error message        
        cattery1.getCat(2);        
        
        cattery1.displayAllCats(); //three cats displayed        
        
        cattery1.removeCat(4); //invalid index produces error message        
        cattery1.removeCat(2);        
        
        cattery1.displayAllCats(); //two cats displayed
    }
}


/**
 * Class describing basic information about a cat such as name, DOB and weight.
 * 
 * @author Vinay Punwani
 * @version v1.0 Nov 20th, 2016
 */
public class Cat
{
    // instance variables
    private String name;
    private int yearOfBirth;
    private int weightInKilograms;

    /**
     * Default Constructor for objects of class Cat
     */
    public Cat()
    {
        // initialise instance variables to default values
        name = "";
        yearOfBirth = 0;
        weightInKilograms = 0;
    }

    /**
     * Non-default Constructor for objects of class Cat
     *
     * @param name A parameter containing the new name of the cat
     * @param yearOfBirth A parameter containing the cat's year of birth
     * @param weightInKilograms A parameter containing the cat's weight in kilo's
     */
    public Cat(String name, int yearOfBirth, int weightInKilograms)
    {
        // initialise instance variables to passed in values
        setName(name);
        setYearOfBirth(yearOfBirth);
        setWeightInKilograms(weightInKilograms);
    }
    
    //Accessor methods
    /**
     * Method getName which returns the cat's name as a string
     *
     * @return The return value which is the cat's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Method getYearOfBirth which returns the cat's year of birth as an int
     *
     * @return The return value which is the cat's year of birth
     */
    public int getYearOfBirth() {
        return yearOfBirth;
    }
    
    /**
     * Method getWeightInKilograms which returns the cat's weight in kilo's
     *
     * @return The return value which is an int of the cat's weight
     */
    public int getWeightInKilograms() {
        return weightInKilograms;
    }
    
    //Mutator methods
    /**
     * Method setName which validates then sets the name of the cat from a passed in parameter
     *
     * @param name A parameter containing the cat's name as a string
     */
    public void setName(String name) {
        if(name != null) {
            this.name = name;
        } else if(this.name == null) {
            this.name = "";
        } else {
            System.out.println("Invalid parameter! Name has not been updated.");
        }
    }
    
    /**
     * Method setYearOfBirth which validates then sets the birth year of the cat
     * from a passed in parameter
     *
     * @param yearOfBirth A parameter containing the cat's birth year as an int
     */
    public void setYearOfBirth(int yearOfBirth) {
        if(yearOfBirth > 0) {
            this.yearOfBirth = yearOfBirth;
        } else if(this.yearOfBirth <= 0) {
            this.yearOfBirth = 0;
        } else {
            System.out.println("Invalid parameter! Year of birth has not been updated.");
        }
    }
    
    /**
     * Method setWeightInKilograms which validates then sets the cat's weight in kilo's
     * from a passed in parameter
     *
     * @param weightInKilograms A parameter containing the cat's weight as an int
     */
    public void setWeightInKilograms(int weightInKilograms) {
        if(weightInKilograms > 0) {
            this.weightInKilograms = weightInKilograms;
        } else if(this.weightInKilograms <= 0) {
            this.weightInKilograms = 0;
        } else {
            System.out.println("Invalid parameter! Weight has not been updated.");
        }
    }
    
    /**
     * Method printDetails which displays all the details for one cat on the screen
     * 
     */
    public void printDetails() {
        System.out.println("Cat name: " + name);
        System.out.println("Cat year of birth: " + yearOfBirth);
        System.out.println("Cat weight: " + weightInKilograms + " kilograms.");
    }
}

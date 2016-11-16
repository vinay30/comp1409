import java.util.Random;
/**
 * Class describing several methods that process various forms of input
 * 
 * @author Vinay Punwani
 * @version v1.0 Nov 15th, 2016
 */

public class Play
{
    // static variables
    public static int ROW_OFFSET = 1;
    public static int COLUMN_OFFSET = 1;
    public static int MIN_TABLE_DIMENSION = 1;
    public static int MAX_TABLE_DIMENSION = 10;
    
    // instance variables
    private InputReader reader;
    private Random randomNumber;
    
    /**
     * Default Constructor for objects of class Play
     */
    public Play()
    {
        // initialise instance variables
        reader = new InputReader();
        randomNumber = new Random();
    }

    /**
     * Method stringPlay which scans for keyboard input, then formats the string input and prints the string as many times
     * as there are characters in the string input
     *
     */
    public void stringPlay() {
        System.out.print("Enter a string of variable length: ");
        String inputString = reader.readString();
        String firstLetter = inputString.substring(0, 1).toUpperCase();
        String remainingString = inputString.substring(1).toLowerCase();
        String formattedString = firstLetter + remainingString;
        
        int stringLength = formattedString.length();
        int count = 0;
        
        while(count < stringLength) {
            System.out.println(formattedString);
            count++;
        }
    }
    
    /**
     * Method getMultiplicationTable which scans for two integers, validates them, then prints a multiplication table using
     * the inputted integers. The values at each position in the table correspond to the product of the row and column index
     * of the array generated with the inputted integers.
     *
     */    
    public void getMultiplicationTable() {
        int rowNumber;
        int columnNumber;
        boolean isRowValid;
        boolean isColumnValid;
        
        do {
            System.out.print("Enter first integer for the table: ");
            rowNumber = reader.readInt();
            isRowValid = isValidInput(rowNumber);
            
            System.out.print("Enter second integer for the table: ");
            columnNumber = reader.readInt();
            isColumnValid = isValidInput(columnNumber);
            
            if(isRowValid && isColumnValid) {
                System.out.println("Valid integers saved!");
            } else {
                System.out.println("Invalid integers. Please enter two more integers!");
            }
        } while(!(isRowValid && isColumnValid));
        
        int[][] multiplicationTable = new int[rowNumber+ROW_OFFSET][columnNumber+COLUMN_OFFSET];
        System.out.println("Multiplication table:");
        
        for(int rowIndex = 0; rowIndex < multiplicationTable.length; rowIndex++) {
            for(int columnIndex = 0; columnIndex < multiplicationTable[rowIndex].length; columnIndex++) {
                multiplicationTable[rowIndex][columnIndex] = columnIndex*rowIndex;
                System.out.print(multiplicationTable[rowIndex][columnIndex] + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * Method isValidInput which takes an integer and determines whether the integer lies within a valid range of integers or not
     *
     * @param inputNumber A parameter which contains the integer value to test
     * @return The return value which is true if the integer is valid, false if it is not valid
     */    
    private boolean isValidInput(int inputNumber) {
        if(inputNumber >= MIN_TABLE_DIMENSION && inputNumber <= MAX_TABLE_DIMENSION) {            
            return true;
        } else {            
            return false;
        }
    }
    
    //Lab 9b method
    /**
     * Method guessTheNumber which generates a random integer between 1 and 10 and scans for user input
     * to guess the integer. While the user has not yet guessed the number, after each guess the user is told
     * whether the number is higher or lower than the guess. Once the user has guessed correctly,
     * the number of guesses is displayed.
     *
     */
    public void guessTheNumber() {
        System.out.println("A random integer between 1 and 10 inclusive has been generated.");
        int newRandom = randomNumber.nextInt(10)+1;
        int guessCount = 0;
        int guess;
        
        do {
          System.out.print("Enter a guess for the random integer: ");
          guess = reader.readInt();
          guessCount++;
          
          if(guess < newRandom) {
              System.out.println("Your guess is too low.");
          } else if (guess > newRandom) {
              System.out.println("Your guess is too high.");
          }
        } while(guess != newRandom);
        
        System.out.println("Congratulations! You guessed correctly after " + guessCount + " tries.");
    }
    
    /**
     * Method main which is run when the program starts and which calls other methods
     *
     * @param args A parameter which contains the arguments passed to the main method
     */    
    public static void main(String[] args) {
        Play newGame = new Play();
        newGame.stringPlay();
        newGame.getMultiplicationTable();
        newGame.guessTheNumber();
    }
}

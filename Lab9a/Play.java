
/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    
    /**
     * Constructor for objects of class Play
     */
    public Play()
    {
        // initialise instance variables
        reader = new InputReader();
    }

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
    
    private boolean isValidInput(int inputNumber) {
        if(inputNumber >= MIN_TABLE_DIMENSION && inputNumber <= MAX_TABLE_DIMENSION) {            
            return true;
        } else {            
            return false;
        }
    }
    
    public static void main(String[] args) {
        Play newGame = new Play();
        newGame.stringPlay();
        newGame.getMultiplicationTable();
    }
}

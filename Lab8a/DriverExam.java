
/**
 * Write a description of class DriverExam here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DriverExam
{
    //static variables and constants
    public static final String[] ANSWERS = {"B", "D", "A", "A", "C", "A", "B", "A", "C", "D", "B", "C", "D", "A", "D", "C", "C", "B", "D", "A" };
    public static final String[] VALID_INPUTS = {"A", "B", "C", "D" };
    public static final int PASSING_GRADE = 15;
    
    // instance variables - replace the example below with your own
    private String[] driverAnswers;
    private InputReader inputAnswers;

    /**
     * Constructor for objects of class DriverExam
     */
    public DriverExam()
    {
        // initialise instance variables
        driverAnswers = new String[20];
        inputAnswers = new InputReader();
    }

    public void promptStudentAnswers() {
        int questionNumber = 0;
        
        for(int index = 0; index < ANSWERS.length; index++) {
            questionNumber = index + 1;
            System.out.println("Enter an answer for question " + questionNumber);
            String answer = inputAnswers.readString().toUpperCase();
            if(checkValidInputs(answer, questionNumber)) {
                driverAnswers[index] = answer;
            } else {
                index--;
            }
        }
        
        System.out.println("Thanks for completing the exam!");
        System.out.println("You answered " + getTotalCorrectAnswers() + " questions correctly.");
        System.out.println("You answered " + getTotalIncorrectAnswers() + " questions incorrectly.");
    }
    
    public Boolean checkValidInputs(String answer, int questionNumber) {        
        for(int choiceIndex = 0; choiceIndex < VALID_INPUTS.length; choiceIndex++) {
            if(answer != null && answer.equals(VALID_INPUTS[choiceIndex])) {
                System.out.println("Valid answer saved for question " + questionNumber);
                return true;                
            }
        }
        
        System.out.println("Invalid answer for question " + questionNumber + "! Try again.");
        return false;
    }
    
    public int getTotalCorrectAnswers() {
        return checkExamAnswers();
    }
    
    public int getTotalIncorrectAnswers() {
        return ANSWERS.length - checkExamAnswers();
    }
    
    private int checkExamAnswers() {
        int correct = 0;
        
        for(int index = 0; index < ANSWERS.length; index++) {
            if(driverAnswers[index] != null && driverAnswers[index].equals(ANSWERS[index])) {
                correct++;
            }
        }
        
        return correct;
    }
    
    public Boolean passOrFail() {
        if(getTotalCorrectAnswers() >= PASSING_GRADE) {
            System.out.println("Congratulations! You pass!");
            return true;
        }
        
        System.out.println("Please stay off the road. You failed.");
        return false;
    }
    
    public static void main(String[] args) {
        DriverExam currentExam = new DriverExam();
        currentExam.promptStudentAnswers();
        currentExam.passOrFail();
    }
}

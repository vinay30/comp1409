
/**
 * Write a description of class DriverExam here. FIIIIXXXX
 * 
 * @author ENTER THIS SHIIIIZ
 * @version ME TOOOOO
 */
public class DriverExam
{
    //static variables and constants
    public static final String[] ANSWERS = {"B", "D", "A", "A", "C", "A", "B", "A", "C", "D", "B", "C", "D", "A", "D", "C", "C", "B", "D", "A" };
    public static final String[] VALID_INPUTS = {"A", "B", "C", "D" };
    public static final int PASSING_GRADE = 15;
    
    // instance variables - replace the example below with your own
    private String[] driveAnswers;
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
            questionNumber++;
            System.out.println("Enter an answer for question " + questionNumber);
            String answer = inputAnswers.readString().toUpperCase();
            if(checkValidInputs(answer, questionNumber)) {
                driver_answers[index] = answer;
            } else {
                System.out.println("Invalid answer for question " + questionNumber + "! Try again.");
                index--;
                questionNumber--;
            }
        }
        
        System.out.println("Thanks for completing the exam!");
    }
    
    public boolean checkValidInputs(String answer, int questionNumber) {        
        for(int choiceIndex = 0; choiceIndex < VALID_INPUTS.length; choiceIndex++) {
            if(answer != null && answer.equals(VALID_INPUTS[choiceIndex])) {
                System.out.println("Valid answer saved for question " + questionNumber + "!");
                return true;                
            }
        }
        
        return false;
    }
    
    public int getTotalCorrectAnswers() {
        int correct = 0;
        return countCorrectAnswers(correct); // more explicit name?
    }
    
    public int getTotalIncorrectAnswers() {
        int correct = 0;
        return ANSWERS.length - checkExamAnswers(correct);
    }
    
    private int countCorrectAnswers(int correct) {
        for(int index = 0; index < ANSWERS.length; index++) {
            if(driverAnswers[index] != null && driverAnswers[index].equals(ANSWERS[index])) {
                correct++;
            }
        }
        
        return correct;
    }
    
    public boolean passOrFail() {
        if(getTotalCorrectAnswers() >= PASSING_GRADE) {
            return true;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        DriverExam currentExam = new DriverExam();
        currentExam.promptStudentAnswers();
        System.out.println("You answered " + currentExam.getTotalCorrectAnswers() + " questions correctly!");
        System.out.println("You answered " + currentExam.getTotalIncorrectAnswers() + " questions incorrectly!");
        if(currentExam.passOrFail()) {
            System.out.println("Congratulations! You pass!");
        } else {
            System.out.println("Please stay off the road. You failed!");
        }
    }
}


/**
 * Class describing a driver's exam which takes input from a driver and compares the
 * answers to a key and displays whether the driver has passed or failed.
 * 
 * @author Vinay Punwani
 * @version v1.0 Nov 8th, 2016
 */
public class DriverExam
{
    //static variables and constants
    public static final String[] ANSWERS = {"B", "D", "A", "A", "C", "A", "B", "A", "C", "D", "B", "C", "D", "A", "D", "C", "C", "B", "D", "A" };
    public static final String[] VALID_INPUTS = {"A", "B", "C", "D" };
    public static final int PASSING_GRADE = 15;
    public static final int EXAM_LENGTH = 20;
    
    // instance variables
    private String[] driverAnswers;
    private InputReader inputAnswers;

    /**
     * Default Constructor for objects of class DriverExam
     */
    public DriverExam()
    {
        // initialise instance variables
        driverAnswers = new String[EXAM_LENGTH];
        inputAnswers = new InputReader();
    }

    /**
     * Method promptStudentAnswers which prompts the user for answers to twenty questions
     * of the exam and ensures the responses are valid answers, then saves them to
     * a new driver responses array if they are valid. Then displays the results
     * of the exam.
     *
     */
    public void promptStudentAnswers() {
        for(int index = 0; index < ANSWERS.length; index++) {            
            System.out.println("Enter an answer for question " + (index+1));
            String answer = inputAnswers.readString().toUpperCase();
            
            if(checkValidInputs(answer)) {
                System.out.println("Valid answer saved for question " + (index+1));
                driverAnswers[index] = answer;
            } else {
                System.out.println("Invalid answer for question " + (index+1) + "! Try again.");
                index--;
            }
        }
        
        System.out.println("Thanks for completing the exam!");
        System.out.println("You answered " + getTotalCorrectAnswers() + " questions correctly.");
        System.out.println("You answered " + getTotalIncorrectAnswers() + " questions incorrectly.");
    }
    
    /**
     * Method checkValidInputs which compares each answer input from the driver
     * against a list of valid answers, returning true if the answer is valid and
     * false if not valid.
     *
     * @param answer A parameter which contains the response of the driver for each question
     * @return The return value which is true if the response is valid and false if not
     */
    public Boolean checkValidInputs(String answer) {        
        for(int choiceIndex = 0; choiceIndex < VALID_INPUTS.length; choiceIndex++) {
            if(answer != null && answer.equals(VALID_INPUTS[choiceIndex])) {
                return true;                
            }
        }
        
        return false;
    }
    
    /**
     * Method getTotalCorrectAnswers which calls a private method to enumerate all the
     * correct answers provided by the driver
     *
     * @return The return value which is the number of correct answers
     */
    public int getTotalCorrectAnswers() {
        return checkExamAnswers();
    }
    
    /**
     * Method getTotalIncorrectAnswers which calls a private method to enumerate all the
     * correct answers provided by the driver, then returns the difference between that
     * number and the total number of questions
     *
     * @return The return value which is the number of correct answers subtracted from
     * the total number of questions.
     */
    public int getTotalIncorrectAnswers() {
        return ANSWERS.length - checkExamAnswers();
    }
    
    /**
     * Method checkExamAnswers which compares inputted driver responses with the array of
     * exam answers to determine if they match. Increments the number of correct answers
     * if they do.
     *
     * @return The return value which is the number of correct exam answers
     */
    private int checkExamAnswers() {
        int correct = 0;
        
        for(int index = 0; index < ANSWERS.length; index++) {
            if(driverAnswers[index] != null && driverAnswers[index].equals(ANSWERS[index])) {
                correct++;
            }
        }
        
        return correct;
    }
    
    /**
     * Method passOrFail which compares the total number of correct answers with the
     * passing grade and displays a message based on the result
     *
     * @return The return value which indicates whether the driver has passed the exam
     * or not
     */
    public Boolean passOrFail() {
        if(getTotalCorrectAnswers() >= PASSING_GRADE) {
            System.out.println("Congratulations! You pass!");
            return true;
        }
        
        System.out.println("Please stay off the road. You failed.");
        return false;
    }
    
    /**
     * Method main which creates a DriverExam object, then asks for student answers to be
     * validated, then displays whether the student has passed or failed.
     *
     * @param args A parameter representing arguments passed to the main method
     */
    public static void main(String[] args) {
        DriverExam currentExam = new DriverExam();
        currentExam.promptStudentAnswers();
        currentExam.passOrFail();
    }
}


/**
 * Class that describes the fields and methods of a student, including a name, and exams and an
 * average exam mark.
 * 
 * @author Vinay Punwani
 * @version v1.0 Nov 8th, 2016
 */
public class Student
{
    //static variables
    public static final int HIGHEST_EXAM_MARK = 100;
    public static final int LOWEST_EXAM_MARK = 0;
    public static final int PASSING_EXAM_MARK = 50;
    public static final int NUMBER_OF_EXAMS = 10;
    
    // instance variables
    private String name;
    private int[] examMarks;
    private InputReader examMark;

    /**
     * Default Constructor for objects of class Student
     */
    public Student()
    {
        // initialise instance variables to default values
        examMarks = new int[NUMBER_OF_EXAMS];
        examMark = new InputReader();
        name = "";
    }

    /**
     * Non-default Constructor for objects of class Student
     * 
     * @param name A parameter containing the new student's name
     */
    public Student(String name)
    {
        // initialise instance variables
        examMarks = new int[NUMBER_OF_EXAMS];
        examMark = new InputReader();
        setName(name);
    }
    
    //Accessor methods begin
    /**
     * Method getName which returns the student's saved name
     *
     * @return The return value which is the String of the student's name
     */
    public String getName() {
        return name;
    }
    
    //Mutator methods begin
    /**
     * Method setName which validates and sets a new student name from a passed in parameter
     *
     * @param name A parameter String which is the new name of the student
     */
    public void setName(String name) {
        if(name != null && !name.equals("")) {
            this.name = name;
        } else if(this.name == null || this.name.equals("")) {
            this.name = "unknown";
        }
    }
    
    /**
     * Method promptStudentMarks which prompts the user to enter new exam marks for a 
     * specific student, validates the marks, then adds them to the exam marks array holding
     * all the marks
     *
     */
    public void promptStudentMarks() {
        for(int index = 0; index < examMarks.length; index++) {
            System.out.println("Enter a grade for exam " + (index+1));
            int mark = examMark.readInt();
            
            if(checkValidExamMark(mark)) {
                System.out.println("Valid mark saved for exam " + (index+1));
                examMarks[index] = mark;
            } else {
                System.out.println("Invalid mark entered for exam " + (index+1) + "! Try again.");
                index--;
            }
        }
        
        System.out.println("Thanks for entering all your marks!");
   }
    
    /**
     * Method checkValidExamMark which verifies that the entered exam mark is valid and
     * is between the lowest and highest possible exam mark
     *
     * @param mark A parameter which holds the value of the entered exam mark
     * @return The return value which is true if the mark is valid, false otherwise
     */
    public Boolean checkValidExamMark(int mark) {        
        if(mark >= LOWEST_EXAM_MARK && mark <= HIGHEST_EXAM_MARK) {            
            return true;                
        }
        
        return false;
    }
    
    /**
     * Method calculateAverageMark which calculates the average of all exam marks
     *
     * @return The return value which is the calculated average of all exam marks
     * based on values in the exam mark array
     */
    public double calculateAverageMark() {
        int sumOfMarks = 0;
        
        for(int examIndex = 0; examIndex < examMarks.length; examIndex++) {
            sumOfMarks += examMarks[examIndex];
        }
        
        return sumOfMarks / examMarks.length;
    }
    
    /**
     * Method calculateTotalPassedExams which enumerates the total number of exams within
     * the inputted exam mark array that have passing grades
     *
     * @return The return value which is the total number of passed exams from the array
     */
    public int calculateTotalPassedExams() {
        int passedExamCount = 0;
        
        for(int examIndex = 0; examIndex < examMarks.length; examIndex++) {
            if(examMarks[examIndex] >= PASSING_EXAM_MARK) {
                passedExamCount++;
            }
        }
        
        return passedExamCount;
    }
    
    /**
     * Method allPassingMarks which checks whether the student has passed all exams
     *
     * @return The return value which is true if the student has passed all the exams
     * and false otherwise
     */
    public Boolean allPassingMarks() {
        for(int examIndex = 0; examIndex < examMarks.length; examIndex++) {
            if(examMarks[examIndex] < PASSING_EXAM_MARK) {                
                return false;
            }
        }      
        
        return true;
    }
    
    /**
     * Method main which creates a new student with a name, then prompts the user to
     * enter exam marks. Then displays relevant student information and exam averages, 
     * how many exams were passed and whether the student has passed all the exams
     *
     * @param args A parameter representing values passed to the main method
     */
    public static void main(String[] args) {        
        Student student = new Student("Vinay");
        student.promptStudentMarks();
        System.out.println("Student name: " + student.name);
        System.out.println("Average exam mark: " + student.calculateAverageMark());
        System.out.println("Exams passed: " + student.calculateTotalPassedExams());
        if(student.allPassingMarks()) {
            System.out.println("Student has passed all exams!");
        } else {
            System.out.println("Student has failed at least one exam!");
        }
    }
}

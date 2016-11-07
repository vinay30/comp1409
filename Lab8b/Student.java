
/**
 * Write a description of class Student here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Student
{
    //static variables
    public static final int HIGHEST_EXAM_MARK = 100;
    public static final int LOWEST_EXAM_MARK = 0;
    public static final int PASSING_EXAM_MARK = 50;
    
    // instance variables - replace the example below with your own
    private String name;
    private int[] examMarks;
    private InputReader examMark;

    /**
     * Default Constructor for objects of class Student
     */
    public Student()
    {
        // initialise instance variables
        examMarks = new int[10];
        examMark = new InputReader();
        name = "";
    }

    /**
     * Non-default Constructor for objects of class Student
     */
    public Student(String name)
    {
        // initialise instance variables
        examMarks = new int[10];
        examMark = new InputReader();
        setName(name);
    }
    
    //Accessor methods begin
    public String getName() {
        return name;
    }
    
    //Mutator methods begin
    public void setName(String name) {
        if(name != null && !name.equals("")) {
            this.name = name;
        } else if(this.name == null || this.name.equals("")) {
            this.name = "unknown";
        }
    }
    
    public void promptStudentMarks() {
        int examNumber = 0;
        
        for(int index = 0; index < examMarks.length; index++) {
            examNumber = index + 1;
            System.out.println("Enter a grade for exam " + examNumber);
            int mark = examMark.readInt();
            if(checkValidExamMark(mark, examNumber)) {
                examMarks[index] = mark;
            } else {
                index--;
            }
        }
        
        System.out.println("Thanks for entering all your marks!");
   }
    
    public Boolean checkValidExamMark(int mark, int examNumber) {        
        if(mark >= LOWEST_EXAM_MARK && mark <= HIGHEST_EXAM_MARK) {
            System.out.println("Valid mark saved for exam " + examNumber);
            return true;                
        }
        
        System.out.println("Invalid mark entered for exam " + examNumber + "! Try again.");
        return false;
    }
    
    public double calculateAverageMark() {
        int sumOfMarks = 0;
        
        for(int examIndex = 0; examIndex < examMarks.length; examIndex++) {
            sumOfMarks += examMarks[examIndex];
        }
        
        return sumOfMarks / examMarks.length;
    }
    
    public int calculateTotalPassedExams() {
        int passedExamCount = 0;
        
        for(int examIndex = 0; examIndex < examMarks.length; examIndex++) {
            if(examMarks[examIndex] >= PASSING_EXAM_MARK) {
                passedExamCount++;
            }
        }
        
        return passedExamCount;
    }
    
    public Boolean allPassingMarks() {
        for(int examIndex = 0; examIndex < examMarks.length; examIndex++) {
            if(examMarks[examIndex] < PASSING_EXAM_MARK) {                
                return false;
            }
        }        
        return true;
    }
    
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
